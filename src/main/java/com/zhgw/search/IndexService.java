package com.zhgw.search;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;


@Service
public class IndexService {

	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void test(){

		System.out.println("Test");
		jdbcTemplate.query("select * from test ",new RowMapper() {

			@Override
			public Object mapRow(ResultSet arg0, int arg1) throws SQLException {
				// TODO Auto-generated method stub
					
					System.out.println(arg0.getString("id") + "  "+arg0.getString("name"));
				return null;
			}
		});
		
		
	}
}

