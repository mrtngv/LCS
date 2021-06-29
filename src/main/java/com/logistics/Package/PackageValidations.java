package com.logistics.Package;

import com.logistics.Util.Functions;
import com.logistics.Util.ValidationConstants;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.DataFormatException;

public class PackageValidations {
    public static boolean validateName(String name, String field) throws DataFormatException {
        String errorStarting = "Полето {" + field + "} ";
        if (name == null || name.length() == 0)
            throw new DataFormatException(errorStarting + ValidationConstants.NULL.getErrorMessage());
        if (Functions.hasSpecialCharacters(name))
            throw new DataFormatException(errorStarting + ValidationConstants.INVALID_CHARACTERS.getErrorMessage());
        if (name.length() > 50)
            throw new DataFormatException(errorStarting + ValidationConstants.TOО_LONG.getErrorMessage());

        return true;
    }

    public static boolean validateTelephoneNumber(String number, String field) throws DataFormatException {
        String errorStarting = "Полето {" + field + "} ";
        if (number == null || number.length() == 0)
            throw new DataFormatException(errorStarting + ValidationConstants.NULL.getErrorMessage());
        if (number.length() < 6)
            throw new DataFormatException(errorStarting + ValidationConstants.TOO_SHORT.getErrorMessage());
        if (number.length() > 13)
            throw new DataFormatException(errorStarting + ValidationConstants.TOО_LONG.getErrorMessage());

        return true;
    }

    public static boolean validateEmail(String email, String field) throws DataFormatException {
        String errorStarting = "Полето {" + field + "} ";
        if (email == null || email.length() == 0)
            throw new DataFormatException(errorStarting + ValidationConstants.NULL.getErrorMessage());
        if (email.length() > 50) {
            throw new DataFormatException(errorStarting + ValidationConstants.TOО_LONG.getErrorMessage());
        }
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches())
            throw new DataFormatException(errorStarting + ValidationConstants.INVALID_EMAIL.getErrorMessage());

        return true;
    }
}
