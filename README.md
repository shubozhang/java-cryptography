# Java Cryptography

### Contents
1. [Introduction-What does cryptography solve](#1-introduction-what-cryptography-solves)
2. [Hashing](#2-hashing)
3. [Symmetric Encryption](#3-symmetric-encryption) 
4. [Asymmetric Encryption](#4-asymmetric-encryption)
5. [Digital Signatures](#5-digital-signatures)
6. [Certificates](#6-certificates)


### 1. Introduction-What does cryptography solve?
![Alt text](images/0_what_does_cryptography_solv.png)
* Confidentiality (encryption): message should be encrypted
* Integrity (digital signatures): message should not be changed
* Authenticity (certificate): receiver should be the right one

* Contemporary Cryptography
    * Symmetric encryption
    * Asymmetric encryption
    ![Alt text](images/1_contemporary_cryptography.png)


* Java Cryptography
    * JCA (Java Cryptography Architecture)
    * JCE (Java Cryptography Extension)
    ![Alt text](images/2_jce.png)

* How to plug in a security provider
    * First way:
        ```
        Security.addProvider(new SpecificProvider()); // extends java.security.Provider
        ```
    * Second way: edit java.security file

* JCA/JCE API Summary:    
    ![Alt text](images/3_jce_api.png)


**[⬆ Back to top](#Contents)**

### 2. Hashing
* Properties:
    * one-way
    * deterministic
    * fixed-size
    * psuedo random
    ![Alt text](images/hashing-1.png)
* Hashing algorithm
    * ![Alt text](images/hashing-2.png)

* Application: Password hashing
    * Rainbow table(pre-hashing for regular words) may crack the password.
    ![Alt text](images/hashing-3.png)
    * One solution is to use random salt
    ![Alt text](images/hashing-4.png)

### 3. Symmetric Encryption
* Symmetric encryption
    ![Alt text](images/symmetric-encryption-1.png)

* Example
    ![Alt text](images/symmetric-encryption-examples.png)

* Algorithms
    ![Alt text](images/symmetric-encryption-algs.png)
* Implementation in Java
    ![Alt text](images/symmetric-encryption-java.png)

* Electronic CopyBook Encryption(ECB)
    ![Alt text](images/symmetric-ECB.png)
    
* Cipher Block Chaining
    ![Alt text](images/symmetric-CBC.png)


* Symmetric encryption with IV in Java
    ![Alt text](images/symmetric-CBC-java.png)


* How to exchange symmetric encryption key in public channel
    ![Alt text](images/symmetric-exchange-key.png)


### 4. Asymmetric Encryption
* Asymmetric encryption
    ![Alt text](images/AES.png)

* Asymmetric encryption algorithm
    ![Alt text](images/AES-alogs.png)

* Asymmetric encryption in Java
    ![Alt text](images/AES-java.png)

* Asymmetric encryption limitation
    ![Alt text](images/AES-note.png)


### 5. Digital Signatures
* Digital Signatures
    ![Alt text](images/DS-1.png)
* HMAC signing
    ![Alt text](images/DS-2-using-symmetric-encrption.png)
    
* DS using asymmetric encryption
    ![Alt text](images/DS-4-AES.png)

* DS in Java
    ![Alt text](images/DS-3-in-java.png)

* DS application
    ![Alt text](images/DS-5-application.png)


### 6. Certificates
It is used for authenticity.

* How does this work?
    ![Alt text](images/CA-1.png)

* Create a certificate in Java
    ![Alt text](images/CA-2-in-java.png)
  
    ![Alt text](images/CA-3-keytools.png)
    
* HTTPS   
    ![Alt text](images/HTTPS.png)
    ![Alt text](images/HTTPS-2.png)