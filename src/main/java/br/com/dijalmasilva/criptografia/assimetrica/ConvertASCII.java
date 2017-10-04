/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dijalmasilva.criptografia.assimetrica;

/**
 *
 * @author dijalmasilva
 */
public class ConvertASCII {

    public static int[] stringToCode(String msg) {

        int[] i = new int[msg.length()];
        for (int j = 0; j < msg.length(); j++) {

            i[j] = (int) msg.charAt(j);
        }
        return i;
    }

//    public static int stringToCode(String msg){
//        String code = "";
//            
//        
//        int i = Integer.parseInt(code);
//        return i;
//    }
    public static String codeToString(int[] codes) {

        String message = "";
        for (int code : codes) {
            message += (char) code;
        }
        return message;
    }
}
