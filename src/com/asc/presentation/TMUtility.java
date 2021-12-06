/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.asc.presentation;

import com.asc.bean.Key;
import com.asc.dataaccess.KeyDAO;
import java.util.Date;
import javax.swing.JFileChooser;

/**
 *
 * @author ASC 0
 */
public class TMUtility {
    public static void main(String[] args) 
    {
//--------------------------- Generate key Pair --------------------
//        KeyGenerator keyGen = new KeyGenerator();
//        keyGen.generateKeyPair(1024);

//        System.out.println(keyGen.getPrivateKey());
//        System.out.println(keyGen.getPublicKey());


//------------------------------ Store keys in database. -------------
//        Key key = new Key();
//        key.setPrivateK(keyGen.getPrivateKey());
//        key.setPublicK(keyGen.getPublicKey());

//------------------------------ Key DAO ------------------------------
//        KeyDAO dao = new KeyDAO();
//        dao.addValue(key);

//----------------------------- Retreive keys from database. ----------
//        List<Key> listKeys = dao.getAllKeys();

//        System.out.println( "Private length : " + listKeys.get(0).getPrivateK().length());
//        System.out.println( "Public length : " + listKeys.get(0).getPublicK().length());
        
//----------------------------------Bring keys to be used --------------------
//        byte[] str = Base64.decode(res.getString("KEYBODY"));
//        byte[] privKey = Base64.decode(listKeys.get(0).getPrivateK());
//        byte[] pubKey =  Base64.decode(listKeys.get(0).getPublicK());
//        System.out.println("Private key");
//        System.out.println(new String (privKey));
//        System.out.println("Public key");
//        System.out.println(new String (pubKey));
//--------------------------Prepair keys to be used --------------------------

//        List<KeyPair> list = KeyConverter.convertToBytes(listKeys);
//        System.out.println( "\n\nNumber of keys = " + list.size() + "\n\n" );
//        for(int i = 0; i < list.size(); i++ )
//        {
//            System.out.println("Private key");
//            System.out.println(new String (list.get(i).getPrivKey()) );
//            System.out.println("Public key");
//            System.out.println(new String (list.get(i).getPubKey()) );
//        }

//--------------------------Export keys to file ---------------------------
//        FileStorage file = new FileStorage();
//        file.exportToFile(listKeys, "c:\\test.txt");

/////////////////////////////////////////////////////////////

//        Key k = new Key(new byte[]{1}, new byte[]{1} , "أحمد", new Date(), "تاج", "الياس");
//        KeyDAO dao = new KeyDAO();
//        dao.addValue(k);

        String path = "";
            JFileChooser chooser = new JFileChooser();
            chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            int res = chooser.showOpenDialog(new JFileChooser());
            if (res == JFileChooser.APPROVE_OPTION) {
                path = chooser.getSelectedFile().getPath();
                if (!path.contains(".txt") )
                   path += ".txt" ;
            }
           System.out.println(path);
        System.out.println("Seccess!");

//////////////////////////////////////////////////////////////

    }
}
