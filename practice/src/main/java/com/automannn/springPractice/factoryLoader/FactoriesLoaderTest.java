package com.automannn.springPractice.factoryLoader;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author automannn
 * @time 2021/9/10 18:55
 */
public class FactoriesLoaderTest {

    public static void main(String[] args) {
        GenericApplicationContext context = new GenericApplicationContext();
        context.refresh();
        context.close();
    }
}
