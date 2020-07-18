package com.springboot.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @Title TxOperate.java
 * @Package com.springboot.tx
 * @Description TODO(用一句话描述该文件做什么)
 * @author lizhiqiang
 * @date Jul 18, 2020 10:47:31 AM
 * 
 */
@Component
public class TxOperate {
	
	@Autowired
	private User1Service user1Service;
	
	@Autowired
	private User2Service user2Service;
	
	// ------------------------------REQUIRED------------------------------------
	/**
	 * 
	 * @Title notransaction_exception_required_required  
	 * @Description 无内部异常情况下的 REQUIRED 事务<br>
	 * 
	 */
	public void notransaction_exception_required_required() {
		User1 user1 = new User1();
		user1.setId(1);
		user1.setName("张三");
		user1Service.addRequired(user1);

		User2 user2 = new User2();
		user2.setId(1);
		user2.setName("李四");
		user2Service.addRequired(user2);

		throw new MyException();
	}

	/**
	 * 
	 * @Title notransaction_required_required_exception   
	 * @Description 存在内部异常情况下的 REQUIRED 事务<br>       
	 *
	 */
	public void notransaction_required_required_exception(){
	    User1 user1=new User1();
		user1.setId(1);
	    user1.setName("张三");
	    user1Service.addRequired(user1);
	    
	    User2 user2=new User2();
		user2.setId(1);
	    user2.setName("李四");
	    user2Service.addRequiredException(user2);
	}
	
	/**
	 * 
	 * @Title transaction_exception_required_required   
	 * @Description 外部存在事务，内部存在事务，外部事务异常，内部所有事务回滚       
	 *
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void transaction_exception_required_required(){
	    User1 user1=new User1();
	    user1.setId(1);
	    user1.setName("张三");
	    user1Service.addRequired(user1);
	    
	    User2 user2=new User2();
	    user2.setId(1);
	    user2.setName("李四");
	    user2Service.addRequired(user2);
	    
	    throw new MyException();
	}
	
	/**
	 * 
	 * @Title transaction_required_required_exception   
	 * @Description 外部存在事务，内部存在事务，内部事务异常，内部所有事务回滚        
	 *
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void transaction_required_required_exception(){
	    User1 user1=new User1();
	    user1.setId(1);
	    user1.setName("张三");
	    user1Service.addRequired(user1);
	    
	    User2 user2=new User2();
	    user2.setId(1);
	    user2.setName("李四");
	    user2Service.addRequiredException(user2);
	}
	
	/**
	 * 
	 * @Title transaction_required_required_exception_try   
	 * @Description 外部存在事务，内部存在事务，内部事务异常并且被捕获，内部所有事务回滚        
	 *
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void transaction_required_required_exception_try(){
	    User1 user1=new User1();
	    user1.setId(1);
	    user1.setName("张三");
	    user1Service.addRequired(user1);
	    
	    User2 user2=new User2();
	    user2.setId(1);
	    user2.setName("李四");
	    try {
	        user2Service.addRequiredException(user2);
	    } catch (Exception e) {
	        System.out.println("方法回滚");
	    }
	}
	// ------------------------------REQUIRED END------------------------------------

	// ------------------------------REQUIRED_NEW------------------------------------

	/**
	 * 
	 * @Title notransaction_exception_requiresNew_requiresNew   
	 * @Description 外部存在事务，内部存在事务，外部异常不影响内部事务      
	 *
	 */
	public void notransaction_exception_requiresNew_requiresNew(){
	    User1 user1=new User1();
	    user1.setId(1);
	    user1.setName("张三");
	    user1Service.addRequiresNew(user1);
	    
	    User2 user2=new User2();
	    user2.setId(1);
	    user2.setName("李四");
	    user2Service.addRequiresNew(user2);
	    throw new MyException();
	    
	}
	
	public void notransaction_requiresNew_requiresNew_exception(){
	    User1 user1=new User1();
	    user1.setId(1);
	    user1.setName("张三");
	    user1Service.addRequiresNew(user1);
	    
	    User2 user2=new User2();
	    user2.setId(1);
	    user2.setName("李四");
	    user2Service.addRequiresNewException(user2);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void transaction_exception_required_requiresNew_requiresNew(){
		User2 user2=new User2();
	    user2.setId(1);
	    user2.setName("李四");
	    user2Service.addRequiresNew(user2);
		
	    User1 user1=new User1();
	    user1.setId(1);
	    user1.setName("张三");
	    user1Service.addRequired(user1);
	    
	    User2 user3=new User2();
	    user3.setId(2);
	    user3.setName("王五");
	    user2Service.addRequiresNew(user3);
	    throw new MyException();
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void transaction_required_requiresNew_requiresNew_exception(){
	    User1 user1=new User1();
	    user1.setId(1);
	    user1.setName("张三");
	    user1Service.addRequired(user1);
	    
	    User2 user2=new User2();
	    user2.setId(1);
	    user2.setName("李四");
	    user2Service.addRequiresNew(user2);
	    
	    User2 user3=new User2();
	    user3.setId(2);
	    user3.setName("王五");
	    user2Service.addRequiresNewException(user3);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void transaction_required_requiresNew_requiresNew_exception_try(){
	    User1 user1=new User1();
	    user1.setId(1);
	    user1.setName("张三");
	    user1Service.addRequired(user1);
	    
	    User2 user2=new User2();
	    user2.setId(1);
	    user2.setName("李四");
	    user2Service.addRequiresNew(user2);
	    
	    User2 user3=new User2();
	    user3.setId(2);
	    user3.setName("王五");
	    try {
	        user2Service.addRequiresNewException(user3);
	    } catch (Exception e) {
	        System.out.println("回滚");
	    }
	}
	// ------------------------------REQUIRED_NEW END------------------------------------

	// ------------------------------REQUIRED_NESTED------------------------------------
	public void notransaction_exception_nested_nested(){
	    User1 user1=new User1();
	    user1.setId(1);
	    user1.setName("张三");
	    user1Service.addNested(user1);
	    
	    User2 user2=new User2();
	    user2.setId(1);
	    user2.setName("李四");
	    user2Service.addNested(user2);
	    throw new MyException();
	}
	
	public void notransaction_nested_nested_exception(){
	    User1 user1=new User1();
	    user1.setId(1);
	    user1.setName("张三");
	    user1Service.addNested(user1);
	    
	    User2 user2=new User2();
	    user2.setId(1);
	    user2.setName("李四");
	    user2Service.addNestedException(user2);
	}
	
	@Transactional
	public void transaction_exception_nested_nested(){
	    User1 user1=new User1();
	    user1.setId(1);
	    user1.setName("张三");
	    user1Service.addNested(user1);
	    
	    User2 user2=new User2();
	    user2.setId(1);
	    user2.setName("李四");
	    user2Service.addNested(user2);
	    throw new MyException();
	}
	
	@Transactional
	public void transaction_nested_nested_exception(){
	    User1 user1=new User1();
	    user1.setId(1);
	    user1.setName("张三");
	    user1Service.addNested(user1);
	    
	    User2 user2=new User2();
	    user2.setId(1);
	    user2.setName("李四");
	    user2Service.addNestedException(user2);
	}
	
	@Transactional
	public void transaction_nested_nested_exception_try(){
	    User1 user1=new User1();
	    user1.setId(1);
	    user1.setName("张三");
	    user1Service.addNested(user1);
	    
	    User2 user2=new User2();
	    user2.setId(1);
	    user2.setName("李四");
	    try {
	        user2Service.addNestedException(user2);
	    } catch (Exception e) {
	        System.out.println("方法回滚");
	    }
	}
	
	// ------------------------------REQUIRED_NESTED END------------------------------------

	
	public void rollBack() {
		user1Service.deleteUser1(1);
		user2Service.deleteUser2(1);

	}
}
