package fr.diginamic.rest.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogExecutionTime {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Around("within(fr.diginamic.rest.service..*)")
	public Object print(ProceedingJoinPoint joinPoint) {
		Long startTime = System.currentTimeMillis();
		Object result = null;
		try {
			result = joinPoint.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			logger.info("Temps d'exécution de la méthode {} dans {} : {}", joinPoint.getSignature().getName(),
					joinPoint.getTarget().getClass().getSimpleName(), System.currentTimeMillis() - startTime + " ms");
		}
		return result;
	}

}
