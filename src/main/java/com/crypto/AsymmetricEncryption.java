package com.crypto;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

import static com.crypto.util.UtilTools.printByteArray;
import static com.crypto.util.UtilTools.printText;

public class AsymmetricEncryption {
    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, IllegalBlockSizeException {
        asymmetricEncryptionTest();
    }

    private static void asymmetricEncryptionTest() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        // Generate private / public key pair
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(1024);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        printByteArray("PrivateKey", keyPair.getPrivate().getEncoded());
        printByteArray("PublicKey", keyPair.getPublic().getEncoded());

        // input
        byte[] input = "The Lord of the Rings has been read by many people".getBytes();
        printText("input", input);

        // Encryption
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, keyPair.getPrivate());
        byte[] encryptedText = cipher.doFinal(input);
        printByteArray("EncryptedText", encryptedText);

        // Decryption
        cipher.init(Cipher.DECRYPT_MODE, keyPair.getPublic());
        byte[] decryptedText = cipher.doFinal(encryptedText);
        printText("DecryptedText", decryptedText);




    }
}
