package com.logistics.Util;

import java.util.Random;

public class Functions {
    public static String getErrorMessage(String fullError) {
       return fullError.split("\\: ")[1];
    }

    public static boolean hasSpecialCharacters(String text) {
        if(text.matches(".*[!@#$%^&*()_+={}';:`~].*"))
            return true;
        return false;
    }

    public static String generatePrivateCode() {
        int leftLimit = 48;
        int rightLimit = 122;
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }
}
