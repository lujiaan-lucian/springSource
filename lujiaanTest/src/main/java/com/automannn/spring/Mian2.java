package com.automannn.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * @program: springSource
 * @ClassName Mian2
 * @description:
 * @author: lucian
 * @create: 2023-10-07 11:32
 **/
public class Mian2 {

    public static ThreadLocal a = new ThreadLocal<String>();

    public static void main(String[] args) {
        a.set("aa");
        a.get();
//        BeanFactory factory = new XmlBeanFactory(new ClassPathResource("/spring.xml"));
//        A hello2 = (A)factory.getBean("hello");
//        hello2.say();
    }

}
