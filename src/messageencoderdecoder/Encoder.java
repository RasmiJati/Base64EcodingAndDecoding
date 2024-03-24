/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messageencoderdecoder;

/**
 *
 * @author admin
 */
public class Encoder {

    public Encoder() {
    }

    public String encodeBase64(String plainText) {
        StringBuilder binaryString = new StringBuilder();
        for (char c : plainText.toCharArray()) {
            String binary = Integer.toBinaryString(c);
            while (binary.length() < 8) {
                binary = "0" + binary;
            }
            binaryString.append(binary);
        }

        StringBuilder encodedString = new StringBuilder();
        int index = 0;
        while (index < binaryString.length()) {
            String group = binaryString.substring(index, Math.min(index + 6, binaryString.length()));
            while (group.length() < 6) {
                group += "0";
            }
            int decimalValue = Integer.parseInt(group, 2);
            char base64Char = getBase64Char(decimalValue);
            encodedString.append(base64Char);
            index += 6;
        }

        while (encodedString.length() % 4 != 0) {
            encodedString.append("=");
        }

        return encodedString.toString();
    }

    public char getBase64Char(int decimalValue) {
        if (decimalValue >= 0 && decimalValue <= 25) {
            return (char) (decimalValue + 'A');
        } else if (decimalValue >= 26 && decimalValue <= 51) {
            return (char) (decimalValue - 26 + 'a');
        } else if (decimalValue >= 52 && decimalValue <= 61) {
            return (char) (decimalValue - 52 + '0');
        } else if (decimalValue == 62) {
            return '+';
        } else {
            return '/';
        }
    }
}
