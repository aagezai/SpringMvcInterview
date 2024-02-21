package com.InterviewCompleteJavaSpring.OOP.StringCompare;

public class StringDeclarationExample {
    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = new String("Hello");
        String s3 = "Hello";
        String s4 = new String("Hello");

        System.out.println(s1 == s2);//false
        System.out.println(s1.equals(s2));//true

        System.out.println(s1 == s3);//true
        System.out.println(s1.equals(s3));//true

        System.out.println(s2 == s4);//false
        System.out.println(s2.equals(s4));//true
        new StringDeclarationExample().conceptString();
    }
    public void conceptString(){
        String string = "immutable";
        String str = new String("immutable");
        String replaced = str.replaceAll("[a-z]","B");
        System.out.println(str);
        System.out.println(replaced);

        StringBuilder stringBuilder = new StringBuilder("slower mutable");
        stringBuilder.append(" yes it is");
        System.out.println(stringBuilder);
    }
}
