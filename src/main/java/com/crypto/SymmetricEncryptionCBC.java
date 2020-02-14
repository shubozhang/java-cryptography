package com.crypto;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import java.security.*;

import static com.crypto.util.UtilTools.printByteArray;
import static com.crypto.util.UtilTools.printText;


// CBC: CCBCipher Block Chaining
public class SymmetricEncryptionCBC {

    public static void main(String[] args) throws NoSuchPaddingException, InvalidKeyException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {
        symmetricEncryptionCBCTest();
    }


    private static void symmetricEncryptionCBCTest() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        // Generate key
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(192);
        Key key = keyGenerator.generateKey();
        printByteArray("Key", key.getEncoded());

        // input
        byte[] input = "Repeat!!Repeat!!Repeat!!".getBytes();
        printText("Input", input);

        // Get IV
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
        byte[] random = new byte[16];
        secureRandom.nextBytes(random);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(random);
        printByteArray("IvParameterSpec", random);

        // Encryption with generated key
        cipher.init(Cipher.ENCRYPT_MODE, key, ivParameterSpec);
        byte[] encryptedOutput = cipher.doFinal(input);
        printByteArray("EncryptedOutput", encryptedOutput);

        // Decryption with generated key
        cipher.init(Cipher.DECRYPT_MODE, key, ivParameterSpec);
        byte[] decryptedOutput = cipher.doFinal(encryptedOutput);
        printText("DecryptedOutput", decryptedOutput);
    }
}
