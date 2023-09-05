package com.automannn.springPractice.beanDefinition;

import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * @author automannn
 * @time 2021/8/21 11:42
 */
public class GenericBeanDefinitionTest {
    public static void main(String[] args) {
        GenericBeanDefinition definition = new GenericBeanDefinition();
        definition.setBeanClass(MYSG.class);
        System.out.println(definition.getResolvableType());

    }
    static class MYSG{}
}
