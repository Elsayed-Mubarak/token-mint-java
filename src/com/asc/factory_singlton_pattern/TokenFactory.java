/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asc.factory_singlton_pattern;

import com.asc.singlton.SNSSinglton;
import com.asc.singlton.SoftlockSinglton;
import com.asc.singlton.St3Singlton;
import h3m.H3MAPI;
import java.io.IOException;
import sun.security.pkcs11.wrapper.PKCS11Exception;

/**
 *
 * @author pc3-asc
 */
public class TokenFactory {

    private static H3MAPI token = null;
    public static String lib = "";

    public static H3MAPI getToken() {
        if (lib.equals(ManifacturerLibrary.SOFTLOCK_LIB)) {
            token = new SoftlockSinglton().getInstance();
        } else if (lib.equals(ManifacturerLibrary.SNS_LIB)) {
            token = new SNSSinglton().getInstance();
        } else if (lib.equals(ManifacturerLibrary.ST3_LIB)) {
            token = new St3Singlton().getInstance();
        }
        return token;
    }

    public static void setLib(String lib_)
    {
        lib = lib_;
    }

    public static String getLib()
    {
        return lib;
    }
}
