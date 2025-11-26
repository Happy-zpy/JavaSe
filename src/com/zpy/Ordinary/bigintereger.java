package com.zpy.Ordinary;

import java.math.BigInteger;

/**
 * 作者：张鹏烨
 **/
public class bigintereger {
    public static void main(String[] args) {
        BigInteger bigInteger = new BigInteger("222299999999999999999999999");
        bigInteger.add(new BigInteger("66666666666666666666666"));
        BigInteger i = bigInteger.multiply(new BigInteger("44444444"));
        System.out.println(i);
    }
}
