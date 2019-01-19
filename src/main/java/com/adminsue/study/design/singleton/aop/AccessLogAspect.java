package com.adminsue.study.design.singleton.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author adminsue[ceo@adminsue.com]
 * @since 2019-01-19.
 */
@Aspect
@Slf4j
@Component
public class AccessLogAspect {

    @Pointcut("execution(public static * com.adminsue.study.design.singleton.*.getInstance(..))")
    public void getInstanceCut() {
    }

    /**
     * Just add log, <b>but the pointcut failed</b>
     * Note that aop with <b>private constructor</b> class
     *
     * @param pjp pjp, just get method name and args, return.
     * @return method return
     * @throws Throwable if exist, throw exception
     */
    @Around("getInstanceCut()")
    public Object logAccessRecord(ProceedingJoinPoint pjp) throws Throwable {
        Signature signature = pjp.getSignature();
        String methodName = signature.getDeclaringTypeName();
        log.info("entry {} method.", methodName);
        Object proceed = pjp.proceed();
        log.info("exit {} method.", methodName);
        return proceed;

    }


}
