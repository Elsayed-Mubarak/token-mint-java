/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asc.singlton;

import com.asc.factory_singlton_pattern.ITokenManufacturer;
import com.asc.factory_singlton_pattern.ManifacturerLibrary;
import com.asc.transactions.*;
import h3m.H3MAPI;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.security.pkcs11.wrapper.PKCS11;
import sun.security.pkcs11.wrapper.PKCS11Exception;

/**
 *
 * @author ASC 0
 */
public class SoftlockSinglton implements ITokenManufacturer{

    private static  H3MAPI api = null;

    public  H3MAPI getInstance(){
        if (api == null) {
            try {
                api = new H3MAPI(ManifacturerLibrary.SOFTLOCK_LIB);
            } catch (IOException ex) {
                Logger.getLogger(SoftlockSinglton.class.getName()).log(Level.SEVERE, null, ex);
            } catch (PKCS11Exception ex) {
                Logger.getLogger(SoftlockSinglton.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return api;
    }
}
