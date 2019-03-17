package com.springboot.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author lizq
 * @date 2019/03/17 20:30 
 */
@Component
public class UserManager {
	@Autowired
	private UserDao userDao;

	public void createUser(int count){
		for (int i = 0; i < count; i++){
			userDao.insertUser("lzq");
		}
	}
}
