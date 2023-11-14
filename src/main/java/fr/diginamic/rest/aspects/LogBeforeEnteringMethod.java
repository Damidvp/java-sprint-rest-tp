package fr.diginamic.rest.aspects;

import org.slf4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogBeforeEnteringMethod {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Before("execution(public * fr.diginamic.rest.controller..*(..))")
	public void print(JoinPoint joinPoint) {
		logger.info("Méthode exécutée : {} de la classe {}", 
				joinPoint.getSignature().getName(),
				joinPoint.getTarget().getClass().getSimpleName());
	}
	
}
