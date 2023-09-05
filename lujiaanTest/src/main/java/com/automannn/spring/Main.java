package com.automannn.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring.xml");
        A hello = (A)context.getBean("hello");
        hello.say();
    }

}