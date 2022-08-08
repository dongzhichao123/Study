package com.example.springboot_demo.test;

public class Demo {
    public static void main(String[] args) {

    }
    static class A{
        A(){
            System.out.println("1");
           this.count();
        }
        int name=21;
        public void count(){
            System.out.println();
        }
    }
    static class B extends A{

    }
}
