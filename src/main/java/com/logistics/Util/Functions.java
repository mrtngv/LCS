package com.logistics.Util;

public class Functions {
    public static String getErrorMessage(String fullError) {
       return fullError.split("\\: ")[1];
    }

    public static boolean hasSpecialCharacters(String text) {
        if(text.matches(".*[!@#$%^&*()_+={}';:`~].*"))
            return true;
        return false;
    }
}
