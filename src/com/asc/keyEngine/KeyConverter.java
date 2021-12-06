/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.asc.keyEngine;


import com.asc.bean.Key;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import org.codehaus.xfire.util.Base64;



/**
 *
 * @author ASC 0
 */
public class KeyConverter extends DataCoding{
    private static List<KeyPair> listOfByteKeys = new ArrayList<KeyPair>();
    private static byte[] privateKey;
    private static byte[] publicKey;



    public static List<KeyPair> decodeKeys(List<Key> listKeys) throws IOException, ClassNotFoundException
    {
        listOfByteKeys.clear();
        for(int i = 0; i < listKeys.size(); i++ )
        {
            KeyPair keyPair = new KeyPair();
            keyPair.setPrivKey( decodePrivate( listKeys.get(i).getPrivateK() ));
            keyPair.setPubKey( decodePublic( listKeys.get(i).getPublicK() ));
            listOfByteKeys.add(keyPair);
        }
        return listOfByteKeys;
    }
    public static byte[] encodePrivate(PrivateKey privKey) throws IOException
    {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream objOut = new ObjectOutputStream(out);

        objOut.writeObject(privKey);
        objOut.close();

        String s = Base64.encode(out.toByteArray());
        privateKey = s.getBytes();
        return privateKey;
    }

    public static byte[] encodePublic(PublicKey pubKey) throws FileNotFoundException, IOException
    {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream objOut = new ObjectOutputStream(out);

        objOut.writeObject(pubKey);
        objOut.close();

        String s = Base64.encode(out.toByteArray());
        publicKey = s.getBytes();
        return publicKey;
    }

    public static PrivateKey decodePrivate(byte[] privKey) throws IOException, ClassNotFoundException
    {
        privKey = Base64.decode(new String(privKey));
        ByteArrayInputStream in = new ByteArrayInputStream(privKey);
        ObjectInputStream objIn = new ObjectInputStream(in);
        return (PrivateKey)objIn.readObject();

    }

    public static PublicKey decodePublic(byte[] pubKey) throws IOException, ClassNotFoundException
    {
        pubKey = Base64.decode(new String(pubKey));
        ByteArrayInputStream in = new ByteArrayInputStream(pubKey);
        ObjectInputStream objIn = new ObjectInputStream(in);
        return (PublicKey)objIn.readObject();

    }
}
