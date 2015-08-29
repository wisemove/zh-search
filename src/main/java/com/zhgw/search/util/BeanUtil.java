package com.zhgw.search.util;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.annotation.AnnotationFormatError;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.zhgw.search.common.Table;
import com.zhgw.search.common.Transient;

/**
 * BeanUtils . AnnotationUtils , ReflectUtils .
 * 
 * @author yunjume
 * 
 */
public class BeanUtil {

	final static Logger logger = LoggerFactory.getLogger(BeanUtil.class);

	/**
	 * DateResultUtils instance
	 */
	public final static DataResultUtils DR = new DataResultUtils();

	/**
	 * Annotations instance
	 */
	public final static AnnotationUtils AT = new AnnotationUtils();

	public static Object newInstance(Class<?> clazz) {
		checkSecurity(clazz);
		Object obj = null;
		try {
			obj = clazz.newInstance();
		} catch (Exception e) {
			logger.error("error instance class ! {}  , has been  occur an exception :  {} ", clazz, e.getMessage());
		}
		return obj;
	}

	public static String getSimpleName(Class<?> clazz) {
		checkSecurity(clazz);
		String name = clazz.getSimpleName();
		return name;
	}

	public static Field[] getDeclateFields(Class<?> clazz) {
		checkSecurity(clazz);
		Field fields[] = clazz.getDeclaredFields();
		return fields;
	}

	public static void invoke(Object obj, Method method, Object... values) {
		try {
			method.invoke(obj, values);
		} catch (Exception e) {
			logger.error("Error invoke this method , {}  it has been occur an exception : {} ", method.getName(), e.getMessage());
		}
	}

	static void checkSecurity(Class<?> clazz) {
		if (clazz == null) {
			logger.error("error instance clazz .  throws  java.lang.NullPointExceotion ! ");
			throw new java.lang.NullPointerException();
		}
	}

	public static class DataResultUtils {
		

		public <T> RowMapper<T> getRowMapper(final Class<T> clazz) {
			RowMapper<T> rm = new RowMapper<T>() {
				@SuppressWarnings("unchecked")
				@Override
				public T mapRow(ResultSet rs, int arg1) throws SQLException {
					Object obj = BeanUtil.newInstance(clazz);
					for (Field f : BeanUtil.getDeclateFields(clazz)) {
						Transient tr = f.getAnnotation(Transient.class);
						if (tr != null && tr.value()) {
							continue;
						}
						String fieldName = f.getName();
						String setMethod = new String("set" + StringUtils.substring(fieldName, 0, 1).toUpperCase() + StringUtils.substring(fieldName, 1));
						try {
							Method M = clazz.getDeclaredMethod(setMethod, f.getType());
							M.setAccessible(true);
							Transient mt = M.getAnnotation(Transient.class);
							if (mt != null && tr.value()) {
								continue;
							}
							if (f.getType().equals(int.class) || f.getType().equals(Integer.class)) {
								M.invoke(obj, rs.getInt(fieldName));
							}
							if (f.getType().equals(float.class) || f.getType().equals(Float.class)) {
								M.invoke(obj, rs.getFloat(fieldName));
							}
							if (f.getType().equals(String.class)) {
								M.invoke(obj, rs.getString(fieldName));
							}
							if (f.getType().equals(long.class) || f.getType().equals(Long.class)) {
								M.invoke(obj, rs.getLong(fieldName));
							}
							if (f.getType().equals(double.class) || f.getType().equals(Double.class)) {
								M.invoke(obj, rs.getDouble(fieldName));
							}
							if (f.getType().equals(java.util.Date.class)) {
								String d = rs.getString(fieldName);
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
								M.invoke(obj, sdf.parse(d));
							}
						} catch (Exception e) {
							if (e instanceof SQLException) { // ignore this exception
								logger.error("To parsing sql row occuer an exception : {}", e.getMessage());
							} else {
								logger.error("To reflect {} occur an Exception ! {} ", clazz.getName(), e.getMessage());
							}
						}

					}
					return (T) obj;
				}

			};

			return rm;
		}
	}

	public static class AnnotationUtils {

		public <A> String getTableName(Class<A> clazz) {
			Table t = clazz.getAnnotation(Table.class);
			if (t == null) {
				logger.error("can't convert class {} to @table annotation class .", clazz.getName());
				throw new AnnotationFormatError(clazz.getName());
			}
			String v = t.name();
			if (v == null || v.trim().equals("")) {
				logger.info("Error bean {}  .table name is empty ! ", clazz.getName());
				throw new NullPointerException();
			}
			return v;
		}

		

		public <A extends Annotation> Set<Class<?>> getAnnotationClass(String packName, Class<A> annotationClass) {
			Set<Class<?>> set = new HashSet<Class<?>>();
			try {
				A a;
				Enumeration<URL> es = Thread.currentThread().getContextClassLoader().getResources(packName);
				while (es.hasMoreElements()) {
					URL url = es.nextElement();
					String protocol = url.getProtocol();
					if ("jar".equals(protocol)) {
						// jar file
						JarFile jarFile = ((JarURLConnection) url.openConnection()).getJarFile();
						Enumeration<JarEntry> entity = jarFile.entries();
						while (entity.hasMoreElements()) {
							String clazz = entity.nextElement().getName();
							if (clazz.endsWith("class")) {
								String clazzStr = new String(clazz.replace("/", ".").substring(0, clazz.lastIndexOf(".")));
								Class<?> c = Class.forName(clazzStr);
								a = c.getAnnotation(annotationClass);
								if (a != null)
									set.add(c);
							}
						}
					}

					if ("file".equals(protocol)) {
						// local file
						List<String> s = FileUtils.listFile(URLDecoder.decode(url.getFile(), "UTF-8"));
						for (String file : s) {
							String clazz = file.substring(file.indexOf(packName));
							clazz = clazz.substring(0, clazz.lastIndexOf(".")).replace(File.separator, ".");
							Class<?> c = Class.forName(clazz);
							a = c.getAnnotation(annotationClass);
							if (a != null)
								set.add(c);
						}
					}
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return set;
		}

	}

}
