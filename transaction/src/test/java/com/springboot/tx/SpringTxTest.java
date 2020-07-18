package com.springboot.tx;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 
 * @Title SpringTxTest.java
 * @Package com.springboot.tx
 * @Description TODO(用一句话描述该文件做什么)
 * @author lizhiqiang
 * @date Jul 18, 2020 10:04:54 AM
 * 
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringTxTest {

	private static final Logger logger = LoggerFactory.getLogger(SpringTxTest.class);

	@Autowired
	private TxOperate txOperate;

	@Autowired
	private User1Service user1Service;

	@Autowired
	private User2Service user2Service;

	@After
	public void after() {
		user1Service.deleteUser1(1);
		user2Service.deleteUser2(1);
		user2Service.deleteUser2(2);

	}

	@Test
	public void test_notransaction_exception_required_required() {

		try {
			txOperate.notransaction_exception_required_required();
		} catch (MyException e) {
			logger.info(e.getMessage());
		} catch (Exception e) {
			logger.error("", e);
		}

		// 外围方法未开启事务，插入“张三”、“李四”方法在自己的事务中独立运行，
		// 外围方法异常不影响内部插入“张三”、“李四”方法独立的事务。
		assertTrue(user1Service.existsById(1));
		assertTrue(user2Service.existsById(1));

	}

	@Test
	public void test_notransaction_required_required_exception() {
		try {
			txOperate.notransaction_required_required_exception();
		} catch (MyException e) {
			logger.info(e.getMessage());
		} catch (Exception e) {
			logger.error("", e);
		}

		// 外围方法没有事务，插入“张三”、“李四”方法都在自己的事务中独立运行,
		// 所以插入“李四”方法抛出异常只会回滚插入“李四”方法，插入“张三”方法不受影响。
		assertTrue(user1Service.existsById(1));
		assertFalse(user2Service.existsById(1));
	}
	
	@Test
	public void test_transaction_exception_required_required() {
		try {
			txOperate.transaction_exception_required_required();
		} catch (MyException e) {
			logger.info(e.getMessage());
		} catch (Exception e) {
			logger.error("", e);
		}

		// 外围方法开启事务，内部方法加入外围方法事务，外围方法回滚，内部方法也要回滚。
		assertFalse(user1Service.existsById(1));
		assertFalse(user2Service.existsById(1));
	}
	
	@Test
	public void test_transaction_required_required_exception() {
		try {
			txOperate.transaction_required_required_exception();
		} catch (MyException e) {
			logger.info(e.getMessage());
		} catch (Exception e) {
			logger.error("", e);
		}

		// 外围方法开启事务，内部方法加入外围方法事务，内部方法抛出异常回滚，外围方法感知异常致使整体事务回滚。
		assertFalse(user1Service.existsById(1));
		assertFalse(user2Service.existsById(1));
	}
	
	@Test
	public void test_transaction_required_required_exception_try() {
		try {
			txOperate.transaction_required_required_exception_try();
		} catch (MyException e) {
			logger.info(e.getMessage());
		} catch (Exception e) {
			logger.error("", e);
		}

		// 外围方法开启事务，内部方法加入外围方法事务，内部方法抛出异常回滚，即使方法被catch不被外围方法感知，整个事务依然回滚。
		assertFalse(user1Service.existsById(1));
		assertFalse(user2Service.existsById(1));
	}
	
	@Test
	public void test_notransaction_exception_requiresNew_requiresNew() {

		try {
			txOperate.notransaction_exception_requiresNew_requiresNew();
		} catch (MyException e) {
			logger.info(e.getMessage());
		} catch (Exception e) {
			logger.error("", e);
		}

		// 外围方法未开启事务，插入“张三”、“李四”方法在自己的事务中独立运行，
		// 外围方法异常不影响内部插入“张三”、“李四”方法独立的事务。
		assertTrue(user1Service.existsById(1));
		assertTrue(user2Service.existsById(1));

	}
	
	@Test
	public void test_notransaction_requiresNew_requiresNew_exception() {

		try {
			txOperate.notransaction_requiresNew_requiresNew_exception();
		} catch (MyException e) {
			logger.info(e.getMessage());
		} catch (Exception e) {
			logger.error("", e);
		}

		// 外围方法没有开启事务，插入“张三”方法和插入“李四”方法分别开启自己的事务，
		// 插入“李四”方法抛出异常回滚，其他事务不受影响。
		assertTrue(user1Service.existsById(1));
		assertFalse(user2Service.existsById(1));

	}
	
	@Test
	public void test_transaction_exception_required_requiresNew_requiresNew() {
		try {
			txOperate.transaction_exception_required_requiresNew_requiresNew();
		} catch (MyException e) {
			logger.info(e.getMessage());
		} catch (Exception e) {
			logger.error("", e);
		}

		// 外围方法开启REQUIRED事务，插入“张三”方法和外围方法一个事务，插入“李四”方法、插入“王五”方法分别在独立的新建事务中，
		// 外围方法抛出异常只回滚和外围方法同一事务的方法，故插入“张三”的方法回滚。
		assertFalse(user1Service.existsById(1));
		assertTrue(user2Service.existsById(1));
		assertTrue(user2Service.existsById(2));

	}
	
	@Test
	public void test_transaction_required_requiresNew_requiresNew_exception() {
		try {
			txOperate.transaction_required_requiresNew_requiresNew_exception();
		} catch (MyException e) {
			logger.info(e.getMessage());
		} catch (Exception e) {
			logger.error("", e);
		}

		// 外围方法开启事务，插入“张三”方法和外围方法一个事务，插入“李四”方法、插入“王五”方法分别在独立的新建事务中。
		// 插入“王五”方法抛出异常，首先插入 “王五”方法的事务被回滚，
		// 异常继续抛出被外围方法感知，外围方法事务亦被回滚，故插入“张三”方法也被回滚。
		assertFalse(user1Service.existsById(1));
		assertTrue(user2Service.existsById(1));
		assertFalse(user2Service.existsById(2));

	}
	
	@Test
	public void test_transaction_required_requiresNew_requiresNew_exception_try() {
		try {
			txOperate.transaction_required_requiresNew_requiresNew_exception_try();
		} catch (MyException e) {
			logger.info(e.getMessage());
		} catch (Exception e) {
			logger.error("", e);
		}

		// 外围方法开启事务，插入“张三”方法和外围方法一个事务，插入“李四”方法、插入“王五”方法分别在独立的新建事务中。
		// 插入“王五”方法抛出异常，首先插入 “王五”方法的事务被回滚，
		// 异常继续抛出被外围方法感知，外围方法事务亦被回滚，故插入“张三”方法也被回滚。
		assertTrue(user1Service.existsById(1));
		assertTrue(user2Service.existsById(1));
		assertFalse(user2Service.existsById(2));
	}
	
	@Test
	public void test_notransaction_exception_nested_nested() {
		try {
			txOperate.notransaction_exception_nested_nested();
		} catch (MyException e) {
			logger.info(e.getMessage());
		} catch (Exception e) {
			logger.error("", e);
		}

		// 外围方法未开启事务，插入“张三”、“李四”方法在自己的事务中独立运行，
		// 外围方法异常不影响内部插入“张三”、“李四”方法独立的事务。
		assertTrue(user1Service.existsById(1));
		assertTrue(user2Service.existsById(1));
	}
	
	@Test
	public void test_notransaction_nested_nested_exception() {
		try {
			txOperate.notransaction_nested_nested_exception();
		} catch (MyException e) {
			logger.info(e.getMessage());
		} catch (Exception e) {
			logger.error("", e);
		}

		// 外围方法没有事务，插入“张三”、“李四”方法都在自己的事务中独立运行,
		// 所以插入“李四”方法抛出异常只会回滚插入“李四”方法，插入“张三”方法不受影响。
		assertTrue(user1Service.existsById(1));
		assertFalse(user2Service.existsById(1));
	}
	
	@Test
	public void test_transaction_exception_nested_nested() {
		try {
			txOperate.transaction_exception_nested_nested();
		} catch (MyException e) {
			logger.info(e.getMessage());
		} catch (Exception e) {
			logger.error("", e);
		}

		// 外围方法开启事务，内部事务为外围事务的子事务，外围方法回滚，内部方法也要回滚
		assertFalse(user1Service.existsById(1));
		assertFalse(user2Service.existsById(1));
	}
	
	@Test
	public void test_transaction_nested_nested_exception() {
		try {
			txOperate.transaction_nested_nested_exception();
		} catch (MyException e) {
			logger.info(e.getMessage());
		} catch (Exception e) {
			logger.error("", e);
		}

		// 外围方法开启事务，内部事务为外围事务的子事务，内部方法抛出异常回滚，
		// 且外围方法感知异常致使整体事务回滚。
		assertFalse(user1Service.existsById(1));
		assertFalse(user2Service.existsById(1));
	}
	
	@Test
	public void test_transaction_nested_nested_exception_try() {
		try {
			txOperate.transaction_nested_nested_exception_try();
		} catch (MyException e) {
			logger.info(e.getMessage());
		} catch (Exception e) {
			logger.error("", e);
		}

		// 外围方法开启事务，内部事务为外围事务的子事务，内部方法抛出异常回滚，
		// 且外围方法感知异常致使整体事务回滚。
		assertTrue(user1Service.existsById(1));
		assertFalse(user2Service.existsById(1));
	}
}
