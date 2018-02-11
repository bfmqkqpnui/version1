package com.limovue.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.LinkedHashSet;
import java.util.Set;


@Aspect         //通过注解申明一个切面
@Component      //让这个切面成为spring容器管理的bean
public class LogAopInterceptor {
    /**
     * 日志
     */
    private static final Logger logger = LoggerFactory.getLogger(LogAopInterceptor.class);

    private long beginTime;
    /**
     * 定义拦截规则：拦截com.limovue.controller包下面的所有类中，有@RequestMapping注解的方法。
     */
    @Pointcut("execution(* com.limovue.controller..*(..)) && @annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void controllerMethodPointcut() {
    }

    /**
     * 拦截器具体实现
     *
     * @param pjp
     * @return
     */
    /*@Around("controllerMethodPointcut()")
    public Object aroundInterceptor(ProceedingJoinPoint pjp) {
        long beginTime = System.currentTimeMillis();
        Object obj = null;
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod(); //获取被拦截的方法
        String methodName = method.getName(); //获取被拦截的方法名
        Set<Object> allParams = new LinkedHashSet<>(); //保存所有请求参数，用于输出到日志中
        logger.info(method + "环绕拦截器请求开始，方法：{}", methodName);
        try {
            obj = pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return obj;
    }*/

    @Before("controllerMethodPointcut()")
    public void beforeInterceptor(JoinPoint pjp) {
        beginTime = System.currentTimeMillis();
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod(); //获取被拦截的方法
        String methodName = method.getName(); //获取被拦截的方法名
        logger.info("开始请求[" + method.getDeclaringClass().getName() +"]类的【"+methodName+"】方法");
    }

    @After("controllerMethodPointcut()")
    public void afterInterceptor(JoinPoint pjp) {
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod(); //获取被拦截的方法
        String methodName = method.getName(); //获取被拦截的方法名
        logger.info("完成请求[" + method.getDeclaringClass().getName() +"]类的【"+methodName+"】方法，耗时["+(System.currentTimeMillis()-beginTime)+"]毫秒");
    }
}
