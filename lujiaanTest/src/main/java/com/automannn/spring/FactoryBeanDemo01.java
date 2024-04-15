package com.automannn.spring;

import org.springframework.beans.factory.FactoryBean;

/**
 * @program: springSource
 * @ClassName FactoryBeanDemo01
 * @description:
 * @author: lucian
 * @create: 2023-12-13 09:31
 **/
public class FactoryBeanDemo01 implements FactoryBean<FactoryBeanDemo01> {

    @Override
    public FactoryBeanDemo01 getObject() throws Exception {
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

}
