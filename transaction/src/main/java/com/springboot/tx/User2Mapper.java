package com.springboot.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * 
 * @Title User2Mapper.java
 * @Package com.springboot.tx
 * @Description TODO(用一句话描述该文件做什么)
 * @author lizhiqiang
 * @date Jul 18, 2020 9:56:03 AM
 * 
 */
@Component
public class User2Mapper {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int insertUser2(User2 user) {
		String sql = "insert into User2(id, name) values(?,?)";
		return jdbcTemplate.update(sql, user.getId(), user.getName());
	}

	public int deleteUser2(int id) {
		String sql = "delete from User2 where id = ?";
		return jdbcTemplate.update(sql, id);
	}

	public boolean existsUser2(int id) {
		String sql = "select count(1) from User2 where id = ? limit 0, 1";
		Object[] args = new Object[1];
		args[0] = id;
		return jdbcTemplate.queryForObject(sql, args,Integer.class) > 0;
	}
}
