package com.learnJava.methodreferences;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class MySandbox01 {
    
    private static A aaa = new A(43);
    
    public static void main(String[] args) {
        
        /* WORKS */
        //UnaryOperator<A> u = aaa::m1;
        //UnaryOperator<A> u = s -> s.m1(s);
        UnaryOperator<A> u = A::m2;
        
        /* Next do NOT work */
        //UnaryOperator<A> u = A::m3;
        //UnaryOperator<A> u = A::m1;

        BinaryOperator<A> b = A::sm2;


        A a = new A(42);
        u.apply(a);
    }

    static class A {

        private int f1 = 0;

        public A(int f1) {
            this.f1 = f1;
        }

        public A() {
        }

        static A sm1(A a) {
            System.out.println(String.format("static sm1: %d", a.f1));
            return a;
        }

        static A sm2(A a, A b) {
            return a;
        }

        A m1(A a) {
            System.out.println(String.format("instance m1: %d [ this.f1 = %d ]", a.f1, this.f1));
            return a;
        }

        A m2() {
            System.out.println(String.format("instance m2: [ this.f1 = %d ]", this.f1));
            return this;
        }
        
        void m3(A a) {
            System.out.println(String.format("instance m3: %d", a.f1));
        }
        
        
    }
    
}


