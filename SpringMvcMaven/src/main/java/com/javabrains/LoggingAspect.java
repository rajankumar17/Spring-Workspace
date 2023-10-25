package com.javabrains;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {
	
	@Around("@annotation(com.javabrains.Loggable)")
	public void loggingMessage(ProceedingJoinPoint jp){
		System.out.println("Before method " );
		try {
			jp.proceed();
		} catch (Throwable e) {
			// TODO: handle exception
		}
		System.out.println("After method " );
	}
	
	@Pointcut("execution(public void draw(*))")
	public void usingPointCut(){
	}
}
