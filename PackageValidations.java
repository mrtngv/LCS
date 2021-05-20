package com.logistics.Package;

import com.logistics.Util.Functions;
import com.logistics.Util.ValidationConstants;

import java.util.zip.DataFormatException;

public class PackageValidations {
    public static boolean validateName(String name, String field) throws DataFormatException {
        String errorStarting = "Полето {" + field + "} ";
        if (name == null || name.length() == 0)
            throw new DataFormatException(errorStarting + ValidationConstants.NULL.getErrorMessage());
        if (Functions.hasSpecialCharacters(name))
            throw new DataFormatException(errorStarting + ValidationConstants.INVALID_CHARACTERS.getErrorMessage());
        if (name.length() > 50)
            throw new DataFormatException(errorStarting + ValidationConstants.TO_LONG.getErrorMessage());

        return true;
    }

}
