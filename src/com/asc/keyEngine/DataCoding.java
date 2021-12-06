/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.asc.keyEngine;

import org.bouncycastle.util.encoders.Base64;

/**
 *
 * @author ASC 0
 */
public abstract class DataCoding {
    
    public static String encodeData(String data) {
        byte[] byts=new byte[2*data.length()];
        for (int i = 0; i < byts.length; i+=2) {
            short shrt = (short) data.charAt(i/2);
            byts[i] = (byte) (shrt & 0x00ff);
            byts[i+1] = (byte) ((shrt & 0xff00)>>8);
        }

        return new String (Base64.encode(byts));
    }

    public static String decodeData(String encodedData) {
        String out = "";
        byte[] byts=Base64.decode(encodedData);
        for (int i = 0; i < byts.length; i+=2) {
            short shrt = (short)(byts[i]  | (byts[i+1] << 8)) ;
            out += (char)shrt;
        }
        return out;
    }
}
