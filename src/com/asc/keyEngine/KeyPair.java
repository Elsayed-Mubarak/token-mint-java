/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.asc.keyEngine;

import java.security.PrivateKey;
import java.security.PublicKey;

/**
 *
 * @author ASC 0
 */
public class KeyPair {
    private PrivateKey privKey;
    private PublicKey pubKey;

    /**
     * @return the privKey
     */
    public PrivateKey getPrivKey() {
        return privKey;
    }

    /**
     * @param privKey the privKey to set
     */
    public void setPrivKey(PrivateKey privKey) {
        this.privKey = privKey;
    }

    /**
     * @return the pubKey
     */
    public PublicKey getPubKey() {
        return pubKey;
    }

    /**
     * @param pubKey the pubKey to set
     */
    public void setPubKey(PublicKey pubKey) {
        this.pubKey = pubKey;
    }

}
