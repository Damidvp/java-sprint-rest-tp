package fr.diginamic.rest.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAfterGetMethod {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@After("execution(* fr.diginamic.rest..*.*get*(..))")
	public void print(JoinPoint joinPoint) {
		logger.info("Getter executé par la méthode {}", joinPoint.getSignature().getName());
	}
	
}
