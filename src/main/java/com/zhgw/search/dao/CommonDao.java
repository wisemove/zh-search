package com.zhgw.search.dao;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zhgw.search.common.Conditions;
import com.zhgw.search.common.Page;
import com.zhgw.search.common.Table;
import com.zhgw.search.common.lang.Datable;
import com.zhgw.search.util.BeanUtil;
import com.zhgw.search.util.BeanUtil.SQLTransformUtil.InsertBin;
import com.zhgw.search.util.ReflectionUtils;

/**
 * Face pattern .<br>
 * CommonDao power by yunjume 2014<br>
 * <b>@email</b> : <a href="http://yunjume@live.com">yunjume@live.com</a>
 */
public  class CommonDao<T> {

	final Logger logger = LoggerFactory.getLogger(getClass());

	
	private  Class<T> clazz = null;
	
	private  String table = null;  
	
	
	/**
	 * current spring context jdbcTemplate .
	 * 
	 * @return
	 */
	
	@Autowired
	private   JdbcTemplate jdbcTemplate;
	
	public CommonDao(){
		
		clazz = ReflectionUtils.getSuperClassGenricType(getClass());
		table = BeanUtil.AT.getTableName(clazz);
	}
	
	public Long queryCount(String sql, Object... args) {
		if (sql == null || sql.trim().equals("")) {
			logger.error("sql statement is null or empty ! ");
			throw new NullPointerException();
		}
		printSQL(sql);
		return jdbcTemplate.queryForLong(sql, args);
	}

	/**
	 * get count
	 * 
	 * @param clazz
	 * @param conditions
	 * @return
	 */
	public Long queryCount( Conditions conditions) {
		if (conditions == null) {
			logger.error("Conditions must be not null ");
			throw new NullPointerException();
		}
		String sql = conditions.toCountSQL(table);
		return queryCount(sql);

	}

	

	/**
	 * bean --> resultSet mapper class
	 * <table border=1>
	 * <tr>
	 * <td>Persion.java
	 * <tr>
	 * <td>int number , float avgAge
	 * <tr>
	 * <td>SQL: select count(*) as number , avg(age) as avgAge from t_user;
	 * </table>
	 * 
	 * @param page
	 * @param clazz
	 *            bean --> resultSet mapper class
	 * @param sql
	 * @param args
	 * @return
	 */
	public  Page<T> queryPage(Page<T> page, String sql, Object... args) {
		if (page == null) {
			logger.warn("warn : current page is null ! init Page<T>(10) ");
			page = new Page<T>(10);
		}

		if (sql == null) {
			logger.error("error sql statement ");
			throw new NullPointerException();
		}
		if (sql.toLowerCase().contains("limit")) {
			logger.error("The paging information are not allowed in the statement! ");
			throw new IllegalArgumentException();
		}
		String countSql = "select count(1) from (" + sql + " ) t";
		long totalCount = queryCount(countSql, args);
		page.setTotalCount(totalCount);
		sql = sql.concat(" limit ?,? ");
		printSQL(sql);
		Object objs[];
		if (args != null && args.length > 0) {
			objs = new Object[args.length + 2];
			System.arraycopy(args, 0, objs, 0, args.length);
			objs[objs.length - 1] = page.getPageSize();
			objs[objs.length - 2] = (page.getPageNo() - 1) * page.getPageSize();
		} else {
			objs = new Object[] { (page.getPageNo() - 1) * page.getPageSize(), page.getPageSize() };
		}
		
		List<T> list = (List<T>) this.jdbcTemplate.query(sql, objs, BeanUtil.DR.getRowMapper(clazz));
		page.setResult(list);
		return page;
	}

	/**
	 * 分页适用于mysql
	 * 
	 * @param page
	 * @param clazz
	 *            Annotation class . see {@link Table}
	 * @param conditions
	 * @return
	 */
	public  Page<T> queryPage(Page<T> page, Conditions conditions) {
		if (page == null) {
			logger.warn("warn : current page is null ! init Page<T>(10) ");
			page = new Page<T>(10);
		}
		if (conditions == null) {
			logger.error("Conditions must be not null ");
			throw new NullPointerException();
		}
		String sql = conditions.toSQL(table);
		sql = sql + (" limit ?,?");
		printSQL(sql);
		long totalCount = queryCount( conditions);
		List<Serializable> param = conditions.getParamterList();
		param.add((page.getPageNo() - 1) * page.getPageSize());
		param.add(page.getPageSize());
		List<T> list = jdbcTemplate.query(sql, param.toArray(), BeanUtil.DR.getRowMapper(clazz));
		page.setTotalCount(totalCount);
		page.setResult(list);
		return page;
	}

	/**
	 * Query All by statement
	 * 
	 * @param clazz
	 *            transmit class . row mapping class .
	 * @param sql
	 * @param args
	 * @return
	 */
	public  List<T> queryAll( String sql, Object... args) {
		return (List<T>) jdbcTemplate.query(sql, args, BeanUtil.DR.getRowMapper(clazz));
	}

	/**
	 * Query All column by Object
	 * 
	 * @param clazz
	 *            Annotation class . see {@link Table}
	 * @param conditions
	 *            current query conditions
	 * @return List&lt;T&gt;
	 */
	public  List<T> queryAll( Conditions conditions) {
		if (conditions == null) {
			logger.error("Conditions must be not null ");
			throw new NullPointerException();
		}
		String sql = conditions.toSQL(table);
		List<Serializable> paramters = conditions.getParamterList();
		printSQL(sql);
		List<T> list = jdbcTemplate.query(sql,paramters.toArray(), BeanUtil.DR.getRowMapper(clazz));
		return list;
	}

	/**
	 * Query by Unique if there is multi row has returned . then return onec row . if there is no row to returned .then return null
	 * 
	 * @param clazz
	 *            @table annotation class
	 * @param conditions
	 * @return
	 */
	public  T queryUnique( Conditions conditions) {
		List<T> ls = queryAll(conditions);
		if (ls != null && ls.size() > 0)
			return ls.get(0);
		logger.error("query Unique . no row returned .");
		return null;
		// ignore
	}

	/**
	 * $eg..
	 * 
	 * <pre>
	 * Conditions c = new Conditions();
	 * c.property(&quot;vip&quot;, Alias.LONGABLE);
	 * Longable a = (Longable) queryUnique(&quot;t_visiter&quot;, Longable.class, c);
	 * if (a == null)
	 * 	return 0;
	 * return a.getValue();
	 * </pre>
	 * 
	 * @param table
	 * @param clazz
	 *            class extends {@link Datable}
	 * @param c
	 *            conditions
	 * @return
	 */
	public Datable queryUnique(Class<? extends Datable> clazz, Conditions c) {

		String sql = c.toSQL(BeanUtil.AT.getTableName(clazz));
		printSQL(sql);
		List<Serializable> param = c.getParamterList();
		@SuppressWarnings("unchecked")
		List<Datable> ls = (List<Datable>) jdbcTemplate.query(sql,param.toArray(), BeanUtil.DR.getRowMapper(clazz));
		if (ls != null && ls.size() > 0)
			return ls.get(0);
		logger.warn("query Unique . no row returned ");
		return null;
	}
	
	
	
	public void save(T t){
		InsertBin bin = BeanUtil.SQLT.insertSql(t);
		String sql = bin.sql;
		printSQL(sql);
	    this.jdbcTemplate.update(sql, bin.param);
	}

	public void update(T t){
		InsertBin bin = BeanUtil.SQLT.updateSql(t,true);
		String sql = bin.sql;
		printSQL(sql);
	    this.jdbcTemplate.update(sql, bin.param);
	}
	
	public void updateNotNull(T t){
		InsertBin bin = BeanUtil.SQLT.updateSql(t,false);
		String sql = bin.sql;
		printSQL(sql);
	    this.jdbcTemplate.update(sql, bin.param);
	}
	void printSQL(String sql) {

		logger.info("sql : {}", sql);
	}

}
