package com.crypto;

import java.security.*;
import static com.crypto.util.UtilTools.printByteArray;
import static com.crypto.util.UtilTools.printText;

public class SignatureExample {

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        signatureExampleTest();
    }

    private static void signatureExampleTest() throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        // 1. Certificate Authority generate their public/private key pair
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(1024);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        printByteArray("PrivateKey", keyPair.getPrivate().getEncoded());
        printByteArray("PublicKey", keyPair.getPublic().getEncoded());

        // 2-1. A digest message example of certificate from a company (for example: aol.com)
        byte[] input = "The Lord of the Rings has been read by many people".getBytes();
        printText("input", input);

        // 2-2. CA uses their private key to encrypt the certificate and then generate signature. This signature is attached with
        // certificate. Signature: both hashing and encryption
        Signature signature = Signature.getInstance("SHA256WithRSA");
        signature.initSign(keyPair.getPrivate());
        signature.update(input);
        byte[] signedSignature = signature.sign();
        printByteArray("Signed Signature", signedSignature);

        // 3. Client can use CA's open public key to verify the signature.
        // For example: ca_publickey.decrypt(signature) should match certificate digest message.
        Signature verifySignature = Signature.getInstance("SHA256WithRSA");
        verifySignature.initVerify(keyPair.getPublic());
        verifySignature.update(input);
        boolean isMatch = verifySignature.verify(signedSignature);
        System.out.println("Signature matches " + isMatch);
    }
}
