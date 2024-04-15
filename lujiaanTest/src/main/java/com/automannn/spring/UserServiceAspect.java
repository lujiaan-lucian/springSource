package com.automannn.spring;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

public class UserServiceAspect {

    /**
     * 前置通知
     * @param jp 连接点，通过这个连接点可以获取目标方法
     */
    public void before(JoinPoint jp){
        System.out.println("前置通知");
    }

    /**
     * 环绕通知
     * @param pjp 连接点，可以获取目标方法参数以及方法信息以及调用目标方法等等
     */
    public Object around(ProceedingJoinPoint pjp) throws Throwable{
        System.out.println("环绕通知前。。。");
        //获取目标方法的的Method对象
        MethodSignature ms = (MethodSignature)pjp.getSignature();
        Method method = ms.getMethod();
        System.out.println("当前调用的目标方法：" + method.getName());
        //调用目标方法
        Object returnVal = pjp.proceed();
        System.out.println("环绕通知后。。。");
        return returnVal;
    }

    /**
     * 后置通知
     * @param returnVal 目标方法的返回值
     */
    public void afterReturning(String returnVal){
        System.out.println("后置通知，返回参数：" + returnVal);
    }

    /**
     * 异常通知
     * @param e 目标方法产生的异常对象
     */
    public void afterThrowing(Throwable e){
        System.out.println("异常通知，异常信息：" + e.getMessage());
    }

    /**
     * 最终通知
     */
    public void after(){
        System.out.println("最终通知");
    }
}