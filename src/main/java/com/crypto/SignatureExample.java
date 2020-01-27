package com.crypto;

import java.security.*;
import static com.crypto.Utils.printByteArray;
import static com.crypto.Utils.printText;

public class SignatureExample {

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        signatureExampleTest();
    }

    private static void signatureExampleTest() throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(1024);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        printByteArray("PrivateKey", keyPair.getPrivate().getEncoded());
        printByteArray("PublicKey", keyPair.getPublic().getEncoded());

        // input
        byte[] input = "The Lord of the Rings has been read by many people".getBytes();
        printText("input", input);

        // Signature: both hashing and encryption
        Signature signature = Signature.getInstance("SHA256WithRSA");
        signature.initSign(keyPair.getPrivate());
        signature.update(input);
        byte[] signedSignature = signature.sign();
        printByteArray("Signed Signature", signedSignature);

        // Verification on the other end
        Signature verifySignature = Signature.getInstance("SHA256WithRSA");
        verifySignature.initVerify(keyPair.getPublic());
        verifySignature.update(input);
        boolean isMatch = verifySignature.verify(signedSignature);
        System.out.println("Signature matches " + isMatch);
    }
}
