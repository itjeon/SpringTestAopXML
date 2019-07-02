package lejit.test.aop.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class TestAdvice {
	
	private static final Logger logger = LoggerFactory.getLogger(TestAdvice.class);
	
	@Pointcut("execution(* lejit.test.aop.web.*Controller.*(..))")
	public void commonPointcut() { }
	
	
	@Before("commonPointcut()")
	public void beforeMethod(JoinPoint jp) throws Exception {
		logger.info("beforeMethod() called.....");
		Object arg[] = jp.getArgs();
		logger.info("args length : " + arg.length);
		logger.info("arg0 name : " + arg[0].getClass().getName());
		logger.info(jp.getSignature().getName());
	}
	
	@After("commonPointcut()")
	public void afterMethod(JoinPoint jp) throws Exception {
		logger.info("afterMethod() called.....");
	}
	
	@AfterReturning(pointcut="commonPointcut()", returning="returnString")
	public void afterReturningMethod(JoinPoint jp, String returnString) throws Exception {
		
		logger.info("afterReturningMethod() called.....");
		logger.info("afterReturningMethod() returnString : " + returnString);
		
	}
	
	@Around("commonPointcut()")
	public Object aroundMethod(ProceedingJoinPoint pjp) throws Throwable {
		
		logger.info("aroundMethod() before called.....");

		Object result = pjp.proceed();
	
		logger.info("aroundMethod() after called.....");
		
		return result;
	}
	
	@AfterThrowing(pointcut="commonPointcut()", throwing="exception")
	public void afterThrowingMethod(JoinPoint jp, Exception exception) throws Exception {
		logger.info("afterThrowingMethod() called.....");
		logger.info(exception.getMessage());
	}
}
