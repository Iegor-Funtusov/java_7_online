package ua.com.alevel.aop.point.impl;

import lombok.AllArgsConstructor;
import org.apache.commons.lang3.ArrayUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import org.springframework.stereotype.Component;
import ua.com.alevel.aop.point.AspectPointQuerySearchService;
import ua.com.alevel.service.search.QuerySearchService;

@Aspect
@Component
@AllArgsConstructor
public class AspectPointQuerySearchServiceImpl implements AspectPointQuerySearchService {

    private final QuerySearchService querySearchService;

    @Override
    @Pointcut("execution(* ua.com.alevel.service.search.ProductSearchService.search(..))")
    public void pointcut() { }

    @Override
    @Around(value = "pointcut()")
    public Object doAspect(ProceedingJoinPoint point) throws Throwable {
        Object[] args = point.getArgs();
        if (ArrayUtils.isNotEmpty(args)) {
            String query = (String) args[0];
            querySearchService.save(query);
        }
        return point.proceed();
    }
}
