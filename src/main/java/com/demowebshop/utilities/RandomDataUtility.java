package com.demowebshop.utilities;

import java.util.Random;

public class RandomDataUtility {
    public String getRandomMail() {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        String email2 = "usernames" + randomInt + "@gmail.com";
        return email2;
    }

    public String getRandomMailAlphaNum() {
        // create a string of uppercase and lowercase characters and numbers
        //String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String alphaNumeric = lowerAlphabet + numbers;
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        // specify length of random string
        int length = 10;
        for (int i = 0; i < length; i++) {
            // generate random index number
            int index = random.nextInt(alphaNumeric.length());
            // get character specified by index
            // from the string
            char randomChar = alphaNumeric.charAt(index);
            sb.append(randomChar);
        }
        String randomString = sb.toString();
        String email1 = randomString + "@gmail.com";
        return email1;
    }
}
