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
public class Decoder {

    public Decoder() {
    }

    public String decodeBase64(String encodedText) {
        StringBuilder binaryString = new StringBuilder();
        for (char c : encodedText.toCharArray()) {
            try {
                int decimalValue = getDecimalValue(c);
                String binary = Integer.toBinaryString(decimalValue);
                while (binary.length() < 6) {
                    binary = "0" + binary;
                }
                binaryString.append(binary);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid Base64 character: " + c );
            }
        }
        System.out.println("=======================================================================");
        System.out.println("Binary Representation for \"" + encodedText + "\":");
        System.out.println(binaryString.toString().trim());
        System.out.println("=======================================================================");

        StringBuilder decodedString = new StringBuilder();
        System.out.println("Grouped Binary Representation:");
        for (int i = 0; i < binaryString.length(); i += 8) {
            String group = binaryString.substring(i, Math.min(i + 8, binaryString.length()));
            int decimalValue = Integer.parseInt(group, 2);
            char decodedChar = (char) decimalValue;
            decodedString.append(decodedChar);
            System.out.print(group.trim() + "\t"); // Trim to remove the trailing space
        }
        System.out.println("");
        System.out.println("=======================================================================");

        return decodedString.toString();
    }

    public int getDecimalValue(char base64Char) {
        if (base64Char >= 'A' && base64Char <= 'Z') {
            return base64Char - 'A';
        } else if (base64Char >= 'a' && base64Char <= 'z') {
            return base64Char - 'a' + 26;
        } else if (base64Char >= '0' && base64Char <= '9') {
            return base64Char - '0' + 52;
        } else if (base64Char == '+') {
            return 62;
        } else if (base64Char == '/') {
            return 63;
        } else {
            throw new IllegalArgumentException("Invalid Base64 character: " + base64Char);
        }
    }
}
