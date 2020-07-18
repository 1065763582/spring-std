package com.springboot.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @Title User1Service.java
 * @Package com.springboot.tx
 * @Description TODO(用一句话描述该文件做什么)
 * @author lizhiqiang
 * @date Jul 18, 2020 10:01:00 AM
 * 
 */
@Component
public class User1Service {
	
	@Autowired
	User1Mapper user1Mapper;
	
	public boolean existsById(int id){
		return user1Mapper.existsUser1(id);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void addRequired(User1 user) {
		user1Mapper.insertUser1(user);
	}
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addRequiresNew(User1 user){
        user1Mapper.insertUser1(user);
    }
	
	@Transactional(propagation = Propagation.NESTED)
    public void addNested(User1 user){
        user1Mapper.insertUser1(user);
    }
	
	public void deleteUser1(int id) {
		user1Mapper.deleteUser1(id);
	}
}
