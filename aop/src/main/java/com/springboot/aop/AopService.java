package com.springboot.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import org.springframework.stereotype.Component;

/**
 *
 * @author lizq
 * @date 2019/03/16 15:03 
 */
@Component
@Aspect
public class AopService {

	@Pointcut("execution(public * com.springboot.aop.AopTarget.*(..))")
	public void pointCut() {
	}

	/**
	 * 在目标方法被调用之前做增强处理
	 * @param joinPoint 连接点信息
	 */
	@Before("pointCut()")
	public void doBefore(JoinPoint joinPoint) {
		System.out.println("before :" + joinPoint.getSignature().getName());
	}

	/**
	 * 在目标方法完成之后做增强，无论目标方法是否成功完成
	 * @param joinPoint
	 */
	@After("pointCut()")
	public void doAfter(JoinPoint joinPoint) {
		System.out.println("after :" + joinPoint.getSignature().getName());
	}

	/**
	 * ProceedingJoinPoint对象是JoinPoint的子接口,该对象只用在@Around的切面方法中
	 * @param thisJoinPoint
	 * @return
	 * @throws Throwable
	 */
	@Around("pointCut()")
	public Object doAround(ProceedingJoinPoint thisJoinPoint) throws Throwable {
		System.out.println("around before");
		//try {
		Object o = thisJoinPoint.proceed();
		System.out.println("around after" + o);
		return o;
//		}
//		catch (Throwable e) {
//			e.printStackTrace();
//			return null;
//		}
	}

	@AfterReturning("pointCut()")
	public void doAfterReturning(JoinPoint joinPoint) {
		System.out.println("afterReturning");
	}

	@AfterThrowing(pointcut = "pointCut()", throwing = "ex")
	public void doAfterThrowing(JoinPoint joinPoint, Throwable ex) {
		System.out.println("afterThrowing:" + ex.getMessage());
	}

	@Pointcut(value = "@annotation(com.springboot.aop.MyInfoAnnotation)")
	public void myInfoAnnotation(){}

	@Before(value = "myInfoAnnotation()&&@annotation(annotation)")
	public void annoBefore(JoinPoint joinPoint, MyInfoAnnotation annotation){
		System.out.println("annoBefore " + annotation.value());
	}
}
