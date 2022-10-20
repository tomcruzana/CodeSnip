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

import com.thomascruzana.codesnip.repository.SnippetCollectionRepository;

@Order(2)
@Aspect
@Component
public class RepositoryLoggingAdvise<T> {
    
	private final Logger repositoryLogger = LoggerFactory.getLogger(SnippetCollectionRepository.class);

	// THESE ARE POINTCUT EXPRESSIONS FOR REUSE

	// REPO LAYER POINTCUTS
	@Pointcut("execution(public * com.thomascruzana.codesnip.repository.*.*(..))")
	public void pointCutTemplateRepository() {
	}

	// REPO LAYER ADVISES
	@AfterThrowing(pointcut = "pointCutTemplateRepository()", throwing = "throwingException")
	public void afterRepositoryMethodExceptionCall(Throwable throwingException) {
		repositoryLogger.error("an exception occured when invoking a repository method -" + throwingException);
	}

	@SuppressWarnings("unchecked")
	@Around("pointCutTemplateRepository()")
	public T aroundRepositoryMethodCall(ProceedingJoinPoint jp) throws Throwable {
		// get method signature of the current method
		String methodName = jp.getSignature().getName();

		// get method args size of the current method
		int argSize = jp.getArgs().length;

		repositoryLogger.info(methodName + " method with " + argSize + " arg(s) call start.");

		T result = (T) jp.proceed();

		repositoryLogger.info(methodName + " method with " + argSize + " arg(s) call end.");

		return (T) result;
	}

}