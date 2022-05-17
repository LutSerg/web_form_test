package com.demoqa.webform.components;

import com.github.javafaker.Faker;
import java.util.Random;

import java.util.Locale;

public class  MobilePhone {

    public static String getRandomPhone(int length) {
        String SALTCHARS = "1234567890";
        StringBuilder result = new StringBuilder();
        Random rnd = new Random();
        while (result.length() < length) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            result.append(SALTCHARS.charAt(index));
        }

        return result.toString();
    }

}

