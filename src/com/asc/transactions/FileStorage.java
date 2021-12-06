/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asc.transactions;

import com.asc.bean.Key;
import com.asc.keyEngine.DataCoding;
import com.asc.keyEngine.KeyPair;
import com.asc.keyEngine.KeyConverter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ASC 0
 */
public class FileStorage implements Serializable{

    /**
     *
     */
    public void exportToFile(List<Key> listKeys, String filePath) throws FileNotFoundException, IOException, ClassNotFoundException {
        if (!filePath.contains(".txt"))
            filePath += ".txt";
        FileOutputStream fout = new FileOutputStream(filePath);
        ObjectOutputStream objOut = new ObjectOutputStream(fout);
        List<KeyPair> listKeyPair = KeyConverter.decodeKeys(listKeys);

        for( int i = 0; i < listKeyPair.size(); i++ )
        {
            objOut.writeObject( listKeys.get(i).getId() );
            objOut.writeObject( listKeyPair.get(i).getPrivKey() );
            objOut.writeObject( listKeyPair.get(i).getPubKey() );
            objOut.writeObject( DataCoding.encodeData(listKeys.get(i).getDescription() ));
            objOut.writeObject( listKeys.get(i).getDate() );
            objOut.writeObject( DataCoding.encodeData(listKeys.get(i).getTag() ));
            objOut.writeObject( DataCoding.encodeData(listKeys.get(i).getAlias() ));
        }

        fout.close();
//        FileWriter fout = new FileWriter("c:\\test.txt");
//        List<KeyPair> byteKeys = KeyConverter.decodeKeys(listKeys);
//
//        for (int i = 0; i < byteKeys.size(); i++) {
//            fout.append("Key pair : " + (i + 1) + "separator");
//            //fout.append("Private key : "  + "separator");
//            fout.append(new String(byteKeys.get(i).getPrivKey()) + "separator");
//            //fout.append("Public key : " + "separator");
//            fout.append(new String(byteKeys.get(i).getPubKey()) + "separator");
//            fout.append("done!");
//        }
//        fout.close();
    }

    public List<Key> importFromFile(String filePath) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream in = new FileInputStream(filePath);
        ObjectInputStream objIn = new ObjectInputStream(in);
        List<Key> listKeys = new ArrayList<Key>();

        Object obj;

        try{
            while( ( obj = objIn.readObject() )!= null )
            {
                Key newKey = new Key();
                newKey.setId((Integer) obj);
                objIn.readObject();
                objIn.readObject();
                newKey.setDescription(DataCoding.decodeData((String) objIn.readObject()));
                newKey.setDate((Date) objIn.readObject());
                newKey.setTag(DataCoding.decodeData((String) objIn.readObject()));
                newKey.setAlias(DataCoding.decodeData((String) objIn.readObject()));
                listKeys.add(newKey);
            }
        }catch(Exception ex){

        }
        in.close();
        return listKeys;
    }

    public KeyPair importKeyPairFromFile(String filePath, int id) throws FileNotFoundException, IOException
    {
        FileInputStream in = new FileInputStream(filePath);
        ObjectInputStream objIn = new ObjectInputStream(in);
        KeyPair newKeyPair = new KeyPair();
        PrivateKey privK = null;
        PublicKey pubK = null;
         Object obj;

        try{
            while( ( obj = objIn.readObject() )!= null )
            {
                int thisId = (Integer)obj;
                privK = ( (PrivateKey) objIn.readObject());
                pubK = ((PublicKey) objIn.readObject());
                objIn.readObject();
                objIn.readObject();
                objIn.readObject();
                objIn.readObject();
                if( thisId == id )
                {
                    newKeyPair.setPrivKey(privK);
                    newKeyPair.setPubKey(pubK);
                    break;
                }
            }
        }catch(Exception ex){

        }
         finally{
             in.close();
             return newKeyPair;
         }
        
    }

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
//        FileStorage fs = new FileStorage();
////        TMAPI api = new TMAPI();
//       List<Key> keys =  fs.importFromFile("c:\\test.txt");
//       for ( int i = 0; i < keys.size(); i++ )
//       {
//           System.out.println("" + keys.get(i).getAlias() );
//       }
////        List<Key> listOfKeys;
////        listOfKeys = api.retreiveKeysFromFile("c:\\test.txt");
////
////        System.out.println(listOfKeys.size());
////        for(int i = 0; i < listOfKeys.size(); i++)
////        {
////            System.out.println("Private: \n"+listOfKeys.get(i).getPrivateK());
////            System.out.println("Public: \n" +listOfKeys.get(i).getPublicK());
////        }
    }
}
