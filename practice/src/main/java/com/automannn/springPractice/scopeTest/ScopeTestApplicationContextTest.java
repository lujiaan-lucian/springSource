package com.automannn.springPractice.scopeTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * @author automannn
 * @time 2021/8/20 11:35
 */
public class ScopeTestApplicationContextTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.automannn.springPractice.scopeTest");

        System.out.println(context.getBean("scopeTestApplicationContextTest.MyABean"));
        System.out.println(context.getBean("scopeTestApplicationContextTest.MyABean"));
        System.out.println(context.getBean("scopeTestApplicationContextTest.MyBBean"));
        System.out.println(context.getBean("scopeTestApplicationContextTest.MyBBean"));

    }

    @Component
    static class MyABean{
        @Autowired
        private MyCBean myCBean;

        @Override
        public String toString() {
            return "MyABean{" +
                    "myCBean=" + myCBean +
                    '}';
        }
    }

    @Component
    static class MyBBean{
        @Autowired
        private MyCBean myCBean;

        @Override
        public String toString() {
            return "MyBBean{" +
                    "myCBean=" + myCBean +
                    '}';
        }
    }

    @Component
    @Scope(scopeName = "prototype",proxyMode = ScopedProxyMode.TARGET_CLASS)
    static class MyCBean{

    }
}
