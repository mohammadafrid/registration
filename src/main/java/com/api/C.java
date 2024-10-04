package com.api;

public class C {
    public static void main(String[] args) {
        C c1 = new C();
        int val = c1.test();
        System.out.println(val);
        E e1 = new E();
        e1.test2();
    }
    public int test()
    {
        System.out.println("Hello");
        D d1 = new D();
        return d1.test1();
    }
}
