package com.automannn.spring;

/**
 * @author lucian
 * @date 2023/09/05
 * @description
 */
public class B {

    private String name;

    private A a;

    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }

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
