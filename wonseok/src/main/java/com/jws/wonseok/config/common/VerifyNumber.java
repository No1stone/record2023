package com.jws.wonseok.config.common;

import java.util.Random;

/**
 * Email verify random number gen code
 * number 6 digits
 * 안씀
 */
public class VerifyNumber {
    public static String verifyNumber(){
        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        // this will convert any number sequence into 6 character.
        return String.format("%06d", number);
    }
}
