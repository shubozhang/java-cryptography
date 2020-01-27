package com.crypto;

import javax.crypto.*;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import static com.crypto.Utils.printByteArray;
import static com.crypto.Utils.printText;

public class SymmetricEncryptionECB {

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, BadPaddingException, IllegalBlockSizeException {
        symmetricEncryptionECBTest();
    }

    // ECB: Electronic CopyBook Encryption. It cannot be used for image encryption
    private static void symmetricEncryptionECBTest() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        // Generate key
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(192);
        Key key = keyGenerator.generateKey();
        printByteArray("Key", key.getEncoded());

        byte[] input = "Repeat!!Repeat!!Repeat!!".getBytes();
        printText("Input", input);

        // Encryption with generated key
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedOutput = cipher.doFinal(input);
        printByteArray("EncryptedOutput", encryptedOutput);

        // Decryption with generated key
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedOutput = cipher.doFinal(encryptedOutput);
        printText("DecryptedOutput", decryptedOutput);


    }
}
