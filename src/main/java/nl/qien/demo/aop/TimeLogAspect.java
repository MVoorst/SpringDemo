package nl.qien.demo.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class TimeLogAspect {
    private Logger logger = LoggerFactory.getLogger(TimeLogAspect.class);

    @Around("@annotation(nl.qien.demo.aop.Timed) && execution(public * *(..))")
    public Object time(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        long start = System.currentTimeMillis();

        Object value;

        try {

            // please proceed with the REAL code
            value = proceedingJoinPoint.proceed();

        } catch (Throwable throwable) {

            throw throwable;

        } finally {

            // when done ...
            long duration = System.currentTimeMillis() - start;

            logger.info("{}.{} took {} ms",
                    proceedingJoinPoint.getSignature().getDeclaringType().getSimpleName(),
                    proceedingJoinPoint.getSignature().getName(),
                    duration);
        }

        return value;
    }
}
