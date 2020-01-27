package com.crypto;

public class Utils {

    public static void printByteArray(String arryName, byte[] digest) {
        //Converting the byte array in to HexString format
        StringBuffer hexString = new StringBuffer();

        for (int i = 0; i < digest.length; i++) {
            hexString.append(Integer.toHexString(0xFF & digest[i]));
        }
        System.out.println(arryName + " in Hex format : " + hexString.toString());
        System.out.println(arryName + " size " + digest.length + "  and bit size is " + digest.length * 8);
        System.out.println();
    }

    public static void printText(String name, byte[] text) {
        String str = new String(text);
        System.out.println(name + " : " + str);
    }
}
