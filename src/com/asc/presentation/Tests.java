package com.asc.presentation;

import com.asc.bean.Key;
import com.asc.dataaccess.KeyDAO;

import com.asc.keyEngine.KeyPair;
import com.asc.transactions.FileStorage;
import h3m.H3MAPI;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import sun.security.pkcs11.wrapper.PKCS11Exception;


public class Tests{
    public static void main(String[] args) throws FileNotFoundException, IOException, PKCS11Exception, Exception
    {
//        FileStorage fs = new FileStorage();
//        KeyPair kPair = fs.importKeyPairFromFile("D:\\AKamal\\hamed.txt", 122);
//
//        System.out.println("Key pair1 " + kPair.getPrivKey().toString());
//        System.out.println("Key pair1 " + kPair.getPubKey().toString());
//
//        PrintWriter out = new PrintWriter("D:\\AKamal\\hamed_String.txt");
//        out.println(kPair.getPrivKey().toString());
//        out.println(kPair.getPubKey().toString());
//        out.close();

//        H3MAPI api = new H3MAPI("SLSTSDK.DLL");
//        api.connect();
//        api.login("12345678".toCharArray());
//
//        long priv = api.getPrivateKey();
//        api.get
//
//        api.disconnect();
//        api.logout();
    }
}