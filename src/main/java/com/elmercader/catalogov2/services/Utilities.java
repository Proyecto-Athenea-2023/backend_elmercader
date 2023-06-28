package com.elmercader.catalogov2.services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utilities {

    /**
     *
     * @param pattern
     * @param candidate
     * @return
     */
    private static boolean validateRegex(String pattern, String candidate){
        Pattern pattern_obj = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern_obj.matcher(candidate);
        return matcher.find();
    }

    /**
     *
     * @param email
     * @return
     */
    public static boolean validateEmail(String email){
        String emailPattern = "[a-z][a-z.]*@(usa.edu.co|gmail.com)";
        return validateRegex(emailPattern, email);
    }
}

