# Base64EcodingAndDecoding

Base 64 encoding  
Base 64 encoded data is a string of character that contains only a-z, A-Z, 0-9, + and / characters and is often used in situations when sending non-text information via a text only transmission protocol. Base 64 Encoding takes a stream of characters and converts them to characters that belong to the universal ASCII character set. Once a stream of characters has been converted to characters that belong to the universal ASCII character set (Base 64 encoded) they can be transported with ease over the Internet using the e-mail protocols.
You are required to prepare a program using Java to code and decode messages encrypted using Base 64 encoding.  Your program will first ask the user if they want to encode or decode a message. It will then ask the user to enter either the plain text or the cipher text. Your program will then output the decoded (plaintext) or the encoded message (cipher text).
Activities:
1.	Create an interface where users are asked if they want to encode or decode a message.
2.	For encoding, convert plain text into 8 bit binary representation as per ASCII Character codes. Then split bits into groups of 6 bits. Use each group of 6 bit to be Base 64 encoding technique which results into a cipher text then. While splitting into a group of 6 bits, make sure all group contain 6 bit otherwise you need to add two extra bits of ‘0’ or 4 extra bits of ‘0’ which in result putting a ‘=’ or ‘==’ at the end of the string encoded.
3.	For decoding implement the same above process vice-versa. 
4.	Display your result as per input.
