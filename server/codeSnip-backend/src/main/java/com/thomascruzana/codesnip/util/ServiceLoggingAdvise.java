package com.thomascruzana.codesnip.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.thomascruzana.codesnip.service.SnippetCollectionServiceImpl;

@Order(1)
@Aspect
@Component
public class ServiceLoggingAdvise<T> {

	private final Logger serviceLogger = LoggerFactory.getLogger(SnippetCollectionServiceImpl.class);

	// THESE ARE POINTCUT EXPRESSIONS FOR REUSE

	// SERVICE LAYER POINTCUTS
	@Pointcut("execution(public * com.thomascruzana.codesnip.service.*.*(..))")
	public void pointCutTemplateService() {
	}

	@Pointcut("execution(public * com.thomascruzana.codesnip.service.*.post*(..))")
	public void pointCutTemplateServiceForPost() {
	}

	@Pointcut("execution(public * com.thomascruzana.codesnip.service.*.create*(..))")
	public void pointCutTemplateServiceForCreate() {
	}

	@Pointcut("execution(public * com.thomascruzana.codesnip.service.*.get*(..))")
	public void pointCutTemplateServiceForGet() {
	}

	@Pointcut("execution(public * com.thomascruzana.codesnip.service.*.read*(..))")
	public void pointCutTemplateServiceForRead() {
	}

	@Pointcut("execution(public * com.thomascruzana.codesnip.service.*.put*(..))")
	public void pointCutTemplateServiceForPut() {
	}

	@Pointcut("execution(public * com.thomascruzana.codesnip.service.*.patch*(..))")
	public void pointCutTemplateServiceForPatch() {
	}

	@Pointcut("execution(public * com.thomascruzana.codesnip.service.*.update*(..))")
	public void pointCutTemplateServiceForUpdate() {
	}

	@Pointcut("execution(public * com.thomascruzana.codesnip.service.*.delete*(..))")
	public void pointCutTemplateServiceForDelete() {
	}

	// SERVICE LAYER ADVISES
	@AfterThrowing(pointcut = "pointCutTemplateServiceForPost() || pointCutTemplateServiceForCreate()", throwing = "throwingException")
	public void afterServiceExceptionCallForCreate(Throwable throwingException) {
		serviceLogger.error("an exception occured when creating the resource -" + throwingException);
	}

	@AfterThrowing(pointcut = "pointCutTemplateServiceForGet() || pointCutTemplateServiceForRead()", throwing = "throwingException")
	public void afterServiceExceptionCallForRead(Throwable throwingException) {
		serviceLogger.error("an exception occured when reading the resource -" + throwingException);
	}

	@AfterThrowing(pointcut = "pointCutTemplateServiceForPut() || pointCutTemplateServiceForPatch() || pointCutTemplateServiceForUpdate()", throwing = "throwingException")
	public void afterServiceExceptionCallForUpdate(Throwable throwingException) {
		serviceLogger.error("an exception occured when updating the resource -" + throwingException);
	}

	@AfterThrowing(pointcut = "pointCutTemplateServiceForDelete()", throwing = "throwingException")
	public void afterServiceExceptionCallForDelete(Throwable throwingException) {
		serviceLogger.error("an exception occured when deleting the resource -" + throwingException);
	}

	@SuppressWarnings("unchecked")
	@Around("pointCutTemplateService()")
	public T aroundServiceMethodCall(ProceedingJoinPoint jp) throws Throwable {
		// get method signature of the current method
		String methodName = jp.getSignature().getName();

		// get method args size of the current method
		int argSize = jp.getArgs().length;

		serviceLogger.info(methodName + " method with " + argSize + " arg(s) call start.");

		T result = (T) jp.proceed();

		serviceLogger.info(methodName + " method with " + argSize + " arg(s) call end.");

		return (T) result;
	}

}
