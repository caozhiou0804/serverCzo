
package com.doctor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class TxInterceptor {
	private final static Logger logger = LoggerFactory.getLogger(TxInterceptor.class);

	@Pointcut("execution(public * com..*Service.*(..))")
	public void service() {
		
	};

	@Around("service()")
	public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
		logger.debug("tx aop控制");
		try {
			return pjp.proceed();// 执行该方法
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
