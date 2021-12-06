/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.asc.keyEngine;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;


/**
 *
 * @author ASC 0
 */
public class KeyGenerator {

    private PrivateKey privateKey;
    private PublicKey publicKey;

    

    public void generateKeyPair(int len)
    {
        try {
            //---------------------- writting the objects --------------------
            SecureRandom sr = new SecureRandom();
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
			         keyGen.initialize(len, sr);
            KeyPair keypair = keyGen.generateKeyPair();
            PublicKey publicK = keypair.getPublic();
            PrivateKey privateK = keypair.getPrivate();

            setPrivateKey(privateK);
            setPublicKey(publicK);
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * @return the privateKey
     */
    public PrivateKey getPrivateKey() {
       return privateKey;
    }

    /**
     * @param privateKey the privateKey to set
     */
    public void setPrivateKey(PrivateKey privateKey) {
        this.privateKey = privateKey;
    }

    /**
     * @return the publicKey
     */
    public PublicKey getPublicKey() {
        return publicKey;
    }

    /**
     * @param publicKey the publicKey to set
     */
    public void setPublicKey(PublicKey publicKey) {
        this.publicKey = publicKey;
    }

}
