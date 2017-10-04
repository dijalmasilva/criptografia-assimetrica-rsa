/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dijalmasilva.criptografia.assimetrica;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dijalmasilva
 */
public class Coprime {

//    public static BigInteger findCoprimo(BigInteger z) {
//        BigInteger d = new BigInteger("2");
//
//        while (!verifyNumber(z, d)) {
//            d = d.add(new BigInteger("1"));
//        }
//
//        return d;
//    }
//
//    private static boolean verifyNumber(BigInteger z, BigInteger d) {
//        if (d.equals(z)) {
//            return false;
//        }
//        BigInteger x = mdc(z, d);
//        return x.equals(BigInteger.ONE);
//    }
//
//    private static BigInteger mdc(BigInteger a, BigInteger b) {
//        if (b.equals(BigInteger.ZERO)) {
//            return a;
//        } else {
//            return mdc(b, a.mod(b));
//        }
//    }
    public static BigInteger getCoPrime(BigInteger z) {
        BigInteger coPrime = new BigInteger("2");
        List<BigInteger> mdcDivisorsZ = mdcDivisors(z);

        while (!coPrime.equals(z) && !isCoPrime(mdcDivisorsZ, mdcDivisors(coPrime))) {
            coPrime = coPrime.add(new BigInteger("1"));
        }
        return coPrime;
    }

    private static List<BigInteger> mdcDivisors(BigInteger n) {

        List<BigInteger> listDivisors = new ArrayList<>();

        for (int i = 2; i <= n.intValue(); i++) {
            BigInteger mod = n.mod(new BigInteger("" + i));
            if (mod.equals(BigInteger.ZERO)) {
                listDivisors.add(new BigInteger("" + i));
            }
        }

        return listDivisors;
    }

    private static boolean isCoPrime(List<BigInteger> z, List<BigInteger> d) {
        boolean isCoPrime = true;

        for (BigInteger bigD : d) {
            for (BigInteger bigZ : z) {
                if (bigD.equals(bigZ)) {
                    isCoPrime = false;
                    break;
                }
            }
        }

        return isCoPrime;
    }
}
