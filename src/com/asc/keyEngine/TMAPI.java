/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asc.keyEngine;

import com.asc.bean.Key;
import com.asc.dataaccess.KeyDAO;
import com.asc.factory_singlton_pattern.TokenFactory;
import com.asc.transactions.FileStorage;
import h3m.H3MAPI;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sun.security.pkcs11.wrapper.PKCS11Exception;

/**
 *
 * @author ASC 0
 */
public class TMAPI {

    public TMAPI() {
        String s = TokenFactory.lib;
        api = null;
        api = TokenFactory.getToken();
    }
    private KeyGenerator keyGen = new KeyGenerator();
    /*
     * Key Pair generation
     */

    public void generateKeyPair(int len, String description, Date date,
            String tag, String alias) throws IOException {

        keyGen.generateKeyPair(len);

        Key key = new Key();
        key.setPrivateK(KeyConverter.encodePrivate(keyGen.getPrivateKey()));
        key.setPublicK(KeyConverter.encodePublic(keyGen.getPublicKey()));
        key.setDate(date);
        key.setDescription(description);
        key.setTag(tag);
        key.setAlias(alias);

        KeyDAO dao = new KeyDAO();
        dao.addValue(key);
        System.out.println("Key pair generated....");
    }

    public long[] getSlots() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public boolean logIn(char[] pin) throws IOException, PKCS11Exception, Exception {
        try {
            api.connect();
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, DUNDLE.getString("insert_correct_token"));
        }

        if (api.login(pin)) {
            return true;
        }
        api.disconnect();
        return false;
    }

    public void logOut() throws PKCS11Exception {
        api.logout();
    }

    /***
     * @throws PKCS11Exception
     */
    public void disConnect() throws PKCS11Exception {
        api.disconnect();
    }

    /*
     * Import private key.
     */
    public void importPrivateKey(PrivateKey privKey, String alias, String pin) throws IOException, PKCS11Exception, Exception {
        // TODO import key pair to token.
        api.importPrivateKey("SLS", privKey);
        System.out.println("Private key imported...");
    }

    /**
     * Import public key.
     */
    public void importPublicKey(PublicKey pubKey, String alias, String pin) throws IOException, PKCS11Exception, Exception {

        api.importPublicKey("SLS", pubKey);
        System.out.println("Public key imported...");
    }

    /**
     * Import key pair.
     */
    public void importKeyPair(List<KeyPair> listKey, List<Key> keysAlias, String pin) throws IOException, PKCS11Exception, Exception {

        for (int i = 0; i < listKey.size(); i++) {
            importPrivateKey(listKey.get(i).getPrivKey(), DataCoding.decodeData(keysAlias.get(i).getAlias()), pin);
            importPublicKey(listKey.get(i).getPubKey(), DataCoding.decodeData(keysAlias.get(i).getAlias()), pin);
        }
        logOut();
        System.out.println("Key pair imported...");
    }

    /*
     * Select keys from database
     */
    public List<Key> retreiveKeysFromDB() {
        KeyDAO dao = new KeyDAO();
        List<Key> keys = dao.getAllKeys();
        return keys;
    }
    /*
     * Write Keys to file.
     */

    public void writeKeysToFile(List<Key> listKeys, String filePath) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileStorage fs = new FileStorage();
        fs.exportToFile(listKeys, filePath);
    }

    /*
     * Select keys from file
     */
    public List<Key> retreiveKeysFromFile(String filePath) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileStorage fs = new FileStorage();
        List<Key> keys = fs.importFromFile(filePath);
        return keys;
    }

    /**
     * Delete keys from DB.
     */
    public void deleteKey(Key key) {
        KeyDAO dao = new KeyDAO();
        dao.deleteKey(key);
    }

    /**
     * Select key
     */
    public Key selectKey(int id) {
        KeyDAO dao = new KeyDAO();
        return dao.getKey(id);
    }

    /***
     * Select key from file
     */
    public KeyPair selectKeyPairFromFile(String filePath, int id) {
        KeyPair key = null;
        try {
            FileStorage fs = new FileStorage();
            key = fs.importKeyPairFromFile(filePath, id);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TMAPI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TMAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
        return key;
    }

    /***
     * Update table
     */
    public void updateKeys(Key key) {
        KeyDAO dao = new KeyDAO();
        dao.update(key);
    }
    private H3MAPI api = null;
    private static ResourceBundle DUNDLE = ResourceBundle.getBundle("configuration/bundle");
}
