package com.facebooked.demofacebooked.OOP;

import org.hibernate.metamodel.internal.JpaStaticMetaModelPopulationSetting;

import java.io.IOException;

public class A {
    public void show() throws IOException {
        System.out.println("this from A.,,,,parent");
       // throw new ArithmeticException();


    }

    public void disply() {
        System.out.println("this from A.,,,,parent");
    }
}

class B extends A {
    public static void main(String[] args)   {
        A b = new B();
        try {
            b.show();
        } catch (IOException e) {
            System.out.println("from parent exe"+e.getMessage());
        }
        b.disply();
        B bb = new B();
        bb.view();
    }

    public void view() {
        System.out.println("this from child");
    }

    @Override
    public void show() throws IOException {
        if(1/1==1){
         throw new ArithmeticException("Art");
        }
        throw new IOException("ioexe");

    }
}
