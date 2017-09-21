package com.sandyspring.logging

import groovy.util.logging.Slf4j
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.After
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.springframework.stereotype.Component

/**
 * Created by sande on 7/8/2017.
 */
@Component
@Aspect
@Slf4j
class LoggerAspect {

    @Around("execution(* com.sandyspring.controller.SampleController.sayHi(..))")
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
        log.info "=====================before logging ================"
        // start stopwatch
        Object retVal = pjp.proceed();
        // stop stopwatch

        log.debug "=============after logging=============="
        return retVal;
    }

    @After("execution(* com.sandyspring.controller.SampleController.*(..))")
    public void log(JoinPoint point) {
        log.debug point.getSignature().getName() + " called..."
    }
}
