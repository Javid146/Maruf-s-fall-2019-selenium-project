package com.cybertek.tests.day7_review;

public class SystemPropertiesExample {

    public static void main(String[] args) {
        String property = System.getProperty("os.name");

        System.out.println(property);

        System.out.println("OS: " + property + "; Version: " + System.getProperty("os.version"));

    }
}
