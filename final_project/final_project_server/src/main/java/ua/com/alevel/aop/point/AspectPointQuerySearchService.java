package ua.com.alevel.aop.point;

import org.aspectj.lang.ProceedingJoinPoint;

public interface AspectPointQuerySearchService {

    void pointcut();
    Object doAspect(ProceedingJoinPoint point) throws Throwable;
}
