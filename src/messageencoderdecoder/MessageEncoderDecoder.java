/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messageencoderdecoder;

import java.util.Scanner;

/**
 *
 * @author admin
 */
public class MessageEncoderDecoder {

    public static void main(String[] args) {
        Encoder encode = new Encoder();
        Decoder decode = new Decoder();

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("###################################");
            System.out.println(" Message Encoding and Decoding ");
            System.out.println("###################################");
            System.out.println("1. Enter 1 for Encode");
            System.out.println("2. Enter 2 for Decode");
            System.out.println("3. Enter 3 to Exit");
            System.out.println("-----------------------------------");
            System.out.print("Enter your choice : ");
            String choice = sc.next();
            System.out.println("------------------------------------");
            sc.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("Enter the plain text to encode: ");
                    String plainText = sc.nextLine();
                    String encodedText = encode.encodeBase64(plainText);
                    System.out.println("Encoded Text: ");
                    System.out.println(encodedText);
                    System.out.println("");
                    break;
                case "2":
                    System.out.println("Enter the Base 64 encoded text to decode: ");
                    String encodedTextToDecode = sc.nextLine();
                    String decodedText = decode.decodeBase64(encodedTextToDecode);
                    System.out.println("Decoded Text: ");
                    System.out.println(decodedText);
                    System.out.println("");
                    break;
                case "3":
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please choose 1, 2, or 3.");
            }
        }
    }
}
