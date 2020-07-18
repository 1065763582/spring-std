package com.springboot.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @Title User2Service.java
 * @Package com.springboot.tx
 * @Description TODO(用一句话描述该文件做什么)
 * @author lizhiqiang
 * @date Jul 18, 2020 10:02:07 AM
 * 
 */
@Component
public class User2Service {

	@Autowired
	User2Mapper user2Mapper;
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void addRequired(User2 user) {
		user2Mapper.insertUser2(user);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void addRequiredException(User2 user) {
		user2Mapper.insertUser2(user);
		throw new MyException("REQUIRED-插入User2异常");
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addRequiresNew(User2 user){
        user2Mapper.insertUser2(user);
    }
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addRequiresNewException(User2 user){
        user2Mapper.insertUser2(user);
        throw new MyException("REQUIRES_NEW-插入User2异常");
    }

	@Transactional(propagation = Propagation.NESTED)
    public void addNested(User2 user){
        user2Mapper.insertUser2(user);
    }
    
    @Transactional(propagation = Propagation.NESTED)
    public void addNestedException(User2 user){
        user2Mapper.insertUser2(user);
        throw new MyException("NESTED-插入User2异常");
    }
	
	public boolean existsById(int id){
		return user2Mapper.existsUser2(id);
	}
	
	public void deleteUser2(int id) {
		user2Mapper.deleteUser2(id);
	}
}
