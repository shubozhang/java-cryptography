package com.crypto;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static com.crypto.util.UtilTools.printByteArray;

public class Hashing {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        oneWayOnlyTest();

        deterministicTest();

        fixedSizeTest();

        psuedoRandomTest();
    }


    private static void oneWayOnlyTest() throws NoSuchAlgorithmException {
        String str1 = "one way only";
        byte[] digest1 = hashText(str1);
        System.out.println("Input : " + str1);
        printByteArray("Digest", digest1);

        String digestStr1 = "a68cd9c4ea5f4d0204ee75170d792bd5328795a721f5f4e7556ccbe837bfd";
        System.out.println("Input : " + digestStr1);
        printByteArray("Digest", hashText(digestStr1));
    }

    private static void deterministicTest() throws NoSuchAlgorithmException {
        String str1 = "deterministic";
        byte[] digest1 = hashText(str1);
        System.out.println("Input : " + str1);
        printByteArray("Digest", digest1);

        byte[] digest2 = hashText(str1);
        printByteArray("Digest", digest2);
    }

    private static void fixedSizeTest() throws NoSuchAlgorithmException {
        String str1 = "Fixed size: Security is very important. Never overlook it.";
        byte[] digest1 = hashText(str1);
        System.out.println("Input : " + str1);
        printByteArray("Digest", digest1);
    }

    private static void psuedoRandomTest() throws NoSuchAlgorithmException {
        String str1 = "PsuedoRandom: Security is very important. Never overlook it.";
        byte[] digest1 = hashText(str1);
        System.out.println("Input : " + str1);
        printByteArray("Digest", digest1);

        String str2 = "psuedoRandom: Security is very important. Never overlook it.";
        byte[] digest2 = hashText(str2);
        System.out.println("Input : " + str2);
        printByteArray("Digest", digest2);
    }

    private static byte[] hashText(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] input = str.getBytes();
        byte[] digest = messageDigest.digest(input);
        return digest;
    }

}
