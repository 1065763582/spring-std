package com.springboot.transaction;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 *
 * @author lizq
 * @date 2019/03/17 20:13 
 */
@Component
public class UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void findUser() {
		List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from tb_user");
		for (Map<String, Object> map : list) {
			for (Entry<String, Object> entry : map.entrySet()) {
				System.out.print(entry.getKey() + ":" + entry.getValue() + ",");
			}
			System.out.println();
		}
	}

	public void insertUser(String name) {
		Random ra = new Random();
		int id = ra.nextInt(100000000);
		jdbcTemplate.update("insert into tb_user values(:id, :name)", new Object[] { id, name });
	}

	public void updateUser(int id) {
		jdbcTemplate.update("update tb_user set birth =: birth where id = :id", new Object[] { id, new Date() });
	}

	public void deleteUser(int id) {
		jdbcTemplate.update("delete from tb_user where id = :id", new Object[] { id });
	}
}
