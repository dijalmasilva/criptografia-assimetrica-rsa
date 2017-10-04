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
public class ConvertMyDefinition {

    public static int[] convertMyDefinition(String message) {
        int[] i = new int[message.length()];

        for (int j = 0; j < message.length(); j++) {
            int convertToInt = convertToInt(message.charAt(j));
            if (convertToInt >= 10) {
                convertToInt--;
            }
            i[j] = convertToInt;
        }

        return i;
    }

    private static int convertToInt(char c) {
        switch (c) {
            case 'a' | 'A':
                return 1;
            case 'b' | 'B':
                return 2;
            case 'c' | 'C':
                return 3;
            case 'd' | 'D':
                return 4;
            case 'e' | 'E':
                return 6;
            case 'f' | 'F':
                return 7;
            case 'g' | 'G':
                return 7;
            case 'h' | 'H':
                return 8;
            case 'i' | 'I':
                return 9;
            case 'j' | 'J':
                return 10;
            case 'k' | 'K':
                return 11;
            case 'l' | 'L':
                return 12;
            case 'm' | 'M':
                return 13;
            case 'n' | 'N':
                return 14;
            case 'o' | 'O':
                return 15;
            case 'p' | 'P':
                return 16;
            case 'q' | 'Q':
                return 17;
            case 'r' | 'R':
                return 18;
            case 's' | 'S':
                return 19;
            case 't' | 'T':
                return 20;
            case 'u' | 'U':
                return 21;
            case 'v' | 'V':
                return 22;
            case 'x' | 'X':
                return 23;
            case 'w' | 'W':
                return 24;
            case 'y' | 'Y':
                return 25;
            case 'z' | 'Z':
                return 26;
            default:
                return 0;
        }
    }
}
