/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dijalmasilva.criptografia.assimetrica;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author dijalmasilva
 */
public class Assimetria {

    //Map<d,n>
    public Map<String, BigInteger> keyPublic;
    //Map<e,n>
    private Map<String, BigInteger> keyPrivate;

    public Assimetria() {
        keyPublic = new HashMap<>();
        keyPrivate = new HashMap<>();
    }

    public void generateKeys(BigInteger p, BigInteger q) {
        BigInteger n = p.multiply(q);
        BigInteger z = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
        System.out.println(n.toString() + ", " + z.toString());
        BigInteger d = Coprime.getCoPrime(z);
        BigInteger e = d.modInverse(z);
//        BigInteger e = findRestModIsOne(d, z);
//        while (!findRestModIsOne(e, d, z)) {
//            e++;
//        }
        keyPublic.put("e", e);
        keyPublic.put("n", n);
        keyPrivate.put("d", d);
        keyPrivate.put("n", n);
    }

    private BigInteger findRestModIsOne(BigInteger d, BigInteger z) {
        BigInteger e = new BigInteger("1");
        while (!verifyMod(e, d, z)) {
            e = e.add(new BigInteger("1"));
        }

        return e;
    }

    private boolean verifyMod(BigInteger e, BigInteger d, BigInteger z) {
        BigInteger multiply = e.multiply(d);
        BigInteger mod = multiply.mod(z);
        return mod.equals(BigInteger.ONE);
    }

    public Map<String, BigInteger> getKeyPublic() {
        return keyPublic;
    }

    public String encrypt(String message) {
        String encrypt = "";

        int[] stringToCode = ConvertASCII.stringToCode(message);
        String code = "";

        for (int i : stringToCode) {
            code += i + " ";
        }

        System.out.println("");
        System.out.println("Message to ASCII : " + code);
        System.out.println("");
        for (int i = 0; i < stringToCode.length; i++) {

            BigInteger expo = new BigInteger("" + stringToCode[i])
                    .pow(keyPublic.get("e").intValue());
            BigInteger mod = expo.mod(keyPublic.get("n"));
            System.out.println("Mod de " + stringToCode[i] + " ^ "
                    + keyPublic.get("e").toString() + " mod "
                    + keyPublic.get("n").toString() + "= " + mod.toString());

            encrypt += mod.toString();

            if (i != stringToCode.length - 1) {
                encrypt += " ";
            }
        }
        System.out.println("Encrypt: " + encrypt);
        System.out.println("");
        return encrypt;
    }

    public String decrypt(String messageEncrypt) {
        String[] encryptPart = messageEncrypt.split(" ");
        int[] codes = new int[encryptPart.length];
        int count = 0;
        String code = "";
        for (String part : encryptPart) {
            BigInteger value = new BigInteger(part);
            BigInteger expo = value.pow(keyPrivate.get("d").intValue());
            BigInteger mod = expo.mod(keyPrivate.get("n"));
            System.out.println("Mod de " + value.toString() + " ^ "
                    + keyPrivate.get("d").toString() + " mod "
                    + keyPrivate.get("n").toString() + "= " + mod.toString());
            codes[count++] = mod.intValue();
        }
        for (int i : codes) {
            code += i + " ";
        }
        System.out.println("Pos mod: " + code);
        String codeToString = ConvertASCII.codeToString(codes);
        System.out.println("ASCII to text: " + codeToString);
        System.out.println("");
        return codeToString;
    }

    public String getKeyPublicWithString() {
        return " (" + keyPublic.get("e") + ", " + keyPublic.get("n") + ");";
    }

    public String getKeyPrivateWithString() {
        return " (" + keyPrivate.get("d") + ", " + keyPrivate.get("n") + ");";
    }
}
