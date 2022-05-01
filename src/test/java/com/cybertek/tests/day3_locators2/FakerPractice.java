package com.cybertek.tests.day3_locators2;
import com.github.javafaker.Faker;

public class FakerPractice {
    public static void main(String[] args) {

        Faker fakeData = new Faker();

        String name = fakeData.name().firstName();
        System.out.println(name);
    }
}
