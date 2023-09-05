package com.automannn.spring;

/**
 * @author lucian
 * @date 2023/09/05
 * @description
 */
public class A {

    private String name;

    public void say(){
        System.out.println("hello~" + name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
