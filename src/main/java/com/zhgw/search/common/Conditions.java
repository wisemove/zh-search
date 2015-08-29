package com.zhgw.search.common;

/**
 * FactHQ: QBC .Query by Object
 * 
 * @author yunjume
 * @date 2014-11-15
 * @since Hibernate QBC
 */
public class Conditions {

	private StringBuffer sb;

	private String middleHandle = "AND";

	private StringBuffer selectBuffer;

	String order;

	String group;

	public Conditions() {
		// init ...
		sb = new StringBuffer();
		selectBuffer = new StringBuffer();
		this.order = null;
		this.group = null;
	}

	/**
	 * key = value .
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public Conditions eq(String key, Object value) {
		add("=", key, value);
		return this;
	}

	public Conditions rLike(String key, Object value) {
		add(" like ", key, "%" + value);
		return this;
	}

	public Conditions lLike(String key, Object value) {
		add(" like ", key, value + "%");
		return this;
	}

	public Conditions like(String key, Object value) {
		add(" like ", key, "%" + value + "%");
		return this;
	}

	public Conditions neq(String key,Object value){
		add("<>", key, value);
		return this;
	}
	
	/**
	 * c.eq("aaa","111").adMH("and").eq("bbb",222); <br>
	 * SQL is : aaa='111' and bbb=222<br>
	 * value : and . or
	 * 
	 * @param middleHandle
	 * @return
	 */
	/*public Conditions addMH(String middleHandle) {
		this.middleHandle = " " + middleHandle + " ";
		return this;
	}
*/
	
	/**
	 * AND 
	 * @return
	 */
	public Conditions AND() {
		this.middleHandle = " and ";
		return this;
	}
	
	/**
	 * OR
	 * @return
	 */
	public Conditions OR() {
		this.middleHandle = " or ";
		return this;
	}
	
	
	private void add(String opera, String key, Object value) {
		if (!sb.toString().isEmpty()) {
			sb.append(this.middleHandle);
		}
		sb.append(key);
		sb.append(opera);
		if (value instanceof String) {
			sb.append("'").append(value).append("'");
		} else {
			sb.append(value);
		}
	}

	/**
	 * key > value
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public Conditions gt(String key, Object value) {
		add(">", key, value);
		return this;
	}

	/**
	 * key < value
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public Conditions lt(String key, Object value) {
		add("<", key, value);
		return this;
	}

	/**
	 * key >= value
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public Conditions eg(String key, Object value) {
		add(">=", key, value);
		return this;
	}

	/**
	 * key <= value
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public Conditions el(String key, Object value) {
		add("<=", key, value);
		return this;
	}

	/**
	 * c.setOrder("createDate", "DESC");<br>
	 * SQLStatement only have one this.
	 * 
	 * @param key
	 * @param ascORdesc
	 *            ASC or DESC
	 * @return
	 */
	public Conditions setOrder(String key, String ascORdesc) {
		order = " order by " + key + " " + ascORdesc;
		return this;
	}

	/**
	 * c.avg("uv","avgUV"); <br>
	 * SQL Statement : select avg(uv) as avgUV ; pojo class must be have field "avgUV";
	 * 
	 * @param key
	 * @param alias
	 * @return
	 */
	public Conditions avg(String key, String alias) {
		if (key != null && !key.trim().equals("")) {
			if (!selectBuffer.toString().isEmpty()) {
				selectBuffer.append(",");
			}
			selectBuffer.append(" age(").append(key).append(") as ").append(alias).append(" ");
		}
		return this;
	}

	/**
	 * group sql statment only have one instance this.
	 * 
	 * @param alias
	 * @return
	 */
	public Conditions setGroup(String alias) {
		if (alias != null && !alias.trim().equals(""))
			this.group = " group by " + alias;
		return this;
	}

	/**
	 * c.count("people","countPeople").avg("aa","aa"); <br>
	 * sql : select count(people) as countPeople , avg(aa) as aa;
	 * 
	 * @param key
	 * @param alias
	 * @return
	 */
	public Conditions count(String key, String alias) {
		if (key != null && !key.trim().equals("")) {
			if (!selectBuffer.toString().isEmpty()) {
				selectBuffer.append(",");
			}
			selectBuffer.append(" count(").append(key).append(") as ").append(alias).append(" ");
		}
		return this;
	}

	/**
	 * sql : select count(*) as alias;
	 * 
	 * @param alias
	 * @return
	 */
	public Conditions count(String alias) {
		if (!selectBuffer.toString().isEmpty()) {
			selectBuffer.append(",");
		}
		selectBuffer.append(" count(*) as ").append(alias);
		return this;
	}

	/**
	 * SUM Function;
	 * 
	 * @param key
	 * @param alias
	 * @return
	 */
	public Conditions sum(String key, String alias) {
		if (key != null && !key.trim().equals("")) {
			if (!selectBuffer.toString().isEmpty()) {
				selectBuffer.append(",");
			}
			selectBuffer.append(" sum(").append(key).append(") as ").append(alias).append(" ");
			;
		}

		return this;
	}

	/**
	 * distinct
	 * 
	 * @param key
	 * @param alias
	 * @return
	 */
	public Conditions distinct(String key, String alias) {
		if (key != null && !key.trim().equals("")) {
			if (!selectBuffer.toString().isEmpty()) {
				selectBuffer.append(",");
			}
			selectBuffer.append(" distinct ").append(key).append(" as ").append(alias).append(" ");
			;
		}

		return this;
	}

	/**
	 * select count(distinct a) as alias;
	 * 
	 * @param key
	 * @param alias
	 * @return
	 */
	public Conditions countDistinct(String key, String alias) {
		if (key != null && !key.trim().equals("")) {
			if (!selectBuffer.toString().isEmpty()) {
				selectBuffer.append(",");
			}
			selectBuffer.append(" count(distinct ").append(key).append(") as ").append(alias).append(" ");
			;
		}

		return this;
	}

	/**
	 * sql field .
	 * 
	 * @param key
	 * @return
	 */
	public Conditions property(String key) {
		if (key != null && !key.trim().equals("")) {
			if (!selectBuffer.toString().isEmpty()) {
				selectBuffer.append(",");
			}
			selectBuffer.append("").append(key).append("");
		}

		return this;
	}

	/**
	 * sql field as alias;
	 * 
	 * @param key
	 * @param alias
	 * @return
	 */
	public Conditions property(String key, String alias) {
		if (key != null && !key.trim().equals("")) {
			if (!selectBuffer.toString().isEmpty()) {
				selectBuffer.append(",");
			}
			selectBuffer.append("").append(key).append(" as ").append(alias);
		}

		return this;
	}

	/**
	 * MAX function
	 * 
	 * @param key
	 * @param alias
	 * @return
	 */
	public Conditions max(String key, String alias) {

		if (key != null && !key.trim().equals("")) {
			if (!selectBuffer.toString().isEmpty()) {
				selectBuffer.append(",");
			}
			selectBuffer.append("max(").append(key).append(") as ").append(alias);
		}

		return this;
	}

	/**
	 * min Function
	 * 
	 * @param key
	 * @param alias
	 * @return
	 */
	public Conditions min(String key, String alias) {

		if (key != null && !key.trim().equals("")) {
			if (!selectBuffer.toString().isEmpty()) {
				selectBuffer.append(",");
			}
			selectBuffer.append("min(").append(key).append(") as ").append(alias);
		}

		return this;
	}

	String toSelectBuffer() {
		return selectBuffer.toString();
	}

	String toWhereBuffer() {
		if (order != null)
			sb.append(order);
		return sb.toString();
	}

	public String toSQL(String table) {
		String sql;
		if (!selectBuffer.toString().isEmpty()) {
			sql = "select " + selectBuffer.toString() + " from " + table;
		} else {
			sql = "select * from " + table;
		}

		if (!sb.toString().isEmpty()) {
			sql = sql + " where " + sb.toString();
		}

		if (this.group != null) {
			sql = sql + this.group;
		}

		if (this.order != null)
			sql = sql + this.order;
		return sql;
	}

	public String toCountSQL(String table) {
		String sql = "select count(1) from (" + toSQL(table) + ") c";
		return sql;
	}
}
