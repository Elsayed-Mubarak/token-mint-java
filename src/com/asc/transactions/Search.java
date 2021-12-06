/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asc.transactions;

import com.asc.bean.Key;
import com.asc.dataaccess.KeyDAO;
import com.asc.keyEngine.DataCoding;

import java.lang.String;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASC 0
 */
public class Search extends DataCoding {

     List<Key> listResult = new ArrayList<Key>();

    public  List<Key> searchInDB(String col, String word) {
        KeyDAO dao = new KeyDAO();
        List<Key> listKeys = dao.getAllKeys();
        List<Key> decodedKeys = new ArrayList<Key>();
        Key key = null;
        for (int i = 0; i < listKeys.size(); i++) {
            key = new Key();
            key.setId(listKeys.get(i).getId());
            key.setAlias(decodeData(listKeys.get(i).getAlias()));
            key.setDescription(decodeData(listKeys.get(i).getDescription()));
            key.setTag(decodeData(listKeys.get(i).getTag()));
            key.setDate(listKeys.get(i).getDate());
            decodedKeys.add(key);
        }

        Key result = null;
        if (col.equals("Alias")) {
            for (int i = 0; i < decodedKeys.size(); i++) {
                if (decodedKeys.get(i).getAlias().toLowerCase().contains(word.toLowerCase())) {
                    result = new Key();
                    result = dao.getKey(decodedKeys.get(i).getId());
                    listResult.add(result);
                }
            }
        } else if (col.equals("Description")) {
            for (int i = 0; i < decodedKeys.size(); i++) {
                if (decodedKeys.get(i).getDescription().toLowerCase().contains(word.toLowerCase())) {
                    result = new Key();
                    result = dao.getKey(decodedKeys.get(i).getId());
                    listResult.add(result);
                }
            }
        } else if (col.equals("Date")) {
            for (int i = 0; i < decodedKeys.size(); i++) {
                if (decodedKeys.get(i).getDate().toString().toLowerCase().contains(word.toLowerCase())) {
                    result = new Key();
                    result = dao.getKey(decodedKeys.get(i).getId());
                    listResult.add(result);
                }
            }
        } else if (col.equals("Tage")) {
            for (int i = 0; i < decodedKeys.size(); i++) {
                if (decodedKeys.get(i).getTag().toLowerCase().contains(word.toLowerCase())) {
                    result = new Key();
                    result = dao.getKey(decodedKeys.get(i).getId());
                    listResult.add(result);
                }
            }
        } else if (col.equals("Any")) {
            for (int i = 0; i < decodedKeys.size(); i++) {
                if (decodedKeys.get(i).getAlias().contains(word)) {
                    result = new Key();
                    result = dao.getKey(decodedKeys.get(i).getId());
                    listResult.add(result);
                } else if (decodedKeys.get(i).getDescription().contains(word)) {
                    result = new Key();
                    result = dao.getKey(decodedKeys.get(i).getId());
                    listResult.add(result);
                } else if (decodedKeys.get(i).getDate().toString().contains(word)) {
                    result = new Key();
                    result = dao.getKey(decodedKeys.get(i).getId());
                    listResult.add(result);
                } else if (decodedKeys.get(i).getTag().contains(word)) {
                    result = new Key();
                    result = dao.getKey(decodedKeys.get(i).getId());
                    listResult.add(result);
                }
            }
        }

        return listResult;
    }

    public static void main(String[] args) {
//        List<Key> list =Search.searchInDB("Any", "e");
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(decodeData(list.get(i).getAlias()));
//        }
    }
}
