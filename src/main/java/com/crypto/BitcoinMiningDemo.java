package com.crypto;

import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * A small message digest demo.
 */
public class BitcoinMiningDemo {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        miningDemo();
    }

    private static void miningDemo() throws NoSuchAlgorithmException {

        //setup block
        String blockData = "whole bunch of transactions";

        MessageDigest digester = MessageDigest.getInstance("SHA-256");

        int number = 0;
        String blockWithRandomValue = blockData + number;
        while (!(digester.digest(blockWithRandomValue.toString().getBytes())[0] == 0)) {
            System.out.println("block" + blockWithRandomValue + " has hash " + Hex.encodeHexString(digester.digest(blockWithRandomValue.toString().getBytes())) + ", not good enough!");
            number++;
            blockWithRandomValue = blockData + number;
        }

        System.out.println("block " + blockWithRandomValue + " has hash " + Hex.encodeHexString(digester.digest(blockWithRandomValue.toString().getBytes())));
        System.out.println("block took " + number + " iterations to seal.");
    }

}
