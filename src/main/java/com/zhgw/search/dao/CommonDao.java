package com.zhgw.search.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zhgw.search.common.Conditions;
import com.zhgw.search.common.Page;
import com.zhgw.search.common.Table;
import com.zhgw.search.common.lang.Datable;
import com.zhgw.search.util.BeanUtil;

/**
 * Face pattern .<br>
 * CommonDao power by yunjume 2014<br>
 * <b>@email</b> : <a href="http://yunjume@live.com">yunjume@live.com</a>
 */
public abstract class CommonDao {

	final Logger logger = LoggerFactory.getLogger(getClass());

	public Long queryCount(String sql, Object... args) {
		if (sql == null || sql.trim().equals("")) {
			logger.error("sql statement is null or empty ! ");
			throw new NullPointerException();
		}
		printSQL(sql);
		return getTemplate().queryForLong(sql, args);
	}

	/**
	 * get count
	 * 
	 * @param clazz
	 * @param conditions
	 * @return
	 */
	public Long queryCount(Class<?> clazz, Conditions conditions) {
		if (conditions == null) {
			logger.error("Conditions must be not null ");
			throw new NullPointerException();
		}

		String table = BeanUtil.AT.getTableName(clazz);
		String sql = conditions.toCountSQL(table);
		return queryCount(sql);

	}

	/**
	 * current spring context jdbcTemplate .
	 * 
	 * @return
	 */
	protected abstract JdbcTemplate getTemplate();

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
	public <T> Page<T> queryPage(Page<T> page, Class<T> clazz, String sql, Object... args) {
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
		List<T> list = this.getTemplate().query(sql, objs, BeanUtil.DR.getRowMapper(clazz));
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
	public <T> Page<T> queryPage(Page<T> page, Class<T> clazz, Conditions conditions) {
		if (page == null) {
			logger.warn("warn : current page is null ! init Page<T>(10) ");
			page = new Page<T>(10);
		}
		if (conditions == null) {
			logger.error("Conditions must be not null ");
			throw new NullPointerException();
		}

		String table = BeanUtil.AT.getTableName(clazz);
		String sql = conditions.toSQL(table);
		sql = sql + (" limit ?,?");
		printSQL(sql);
		long totalCount = queryCount(clazz, conditions);
		List<T> list = getTemplate().query(sql, new Object[] { (page.getPageNo() - 1) * page.getPageSize(), page.getPageSize() }, BeanUtil.DR.getRowMapper(clazz));
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
	public <T> List<T> queryAll(final Class<T> clazz, String sql, Object... args) {
		return getTemplate().query(sql, args, BeanUtil.DR.getRowMapper(clazz));
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
	public <T> List<T> queryAll(final Class<T> clazz, Conditions conditions) {
		if (conditions == null) {
			logger.error("Conditions must be not null ");
			throw new NullPointerException();
		}
		String table = BeanUtil.AT.getTableName(clazz);
		String sql = conditions.toSQL(table);
		printSQL(sql);
		List<T> list = getTemplate().query(sql, BeanUtil.DR.getRowMapper(clazz));
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
	public <T> T queryUnique(final Class<T> clazz, Conditions conditions) {
		List<T> ls = queryAll(clazz, conditions);
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
	public Datable queryUnique(String table, Class<? extends Datable> clazz, Conditions c) {

		String sql = c.toSQL(table);
		printSQL(sql);
		@SuppressWarnings("unchecked")
		List<Datable> ls = (List<Datable>) getTemplate().query(sql, BeanUtil.DR.getRowMapper(clazz));
		if (ls != null && ls.size() > 0)
			return ls.get(0);
		logger.warn("query Unique . no row returned ");
		return null;
	}

	void printSQL(String sql) {

		logger.info("FQL : {}", sql);
	}

}
