/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.asc.dataaccess;

import com.asc.bean.Key;
import com.asc.presentation.UserFrame;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Query;

/**
 *
 * @author ASC 0
 */
public class KeyDAO extends DAO{
    
    public void addValue(Key key)
    {
        try{
            begin();
            getSession().save(key);
            commit();
        }catch(HibernateException ex)
        {
            rollback();
            ex.printStackTrace();
        }
        finally
        {
            close();
        }
    }

    public List<Key> getAllKeys()
    {
        List<Key> listKeys = null;
        try
        {
            begin();
            String hql = "from Key";
            Query query = getSession().createQuery(hql);
            listKeys = query.list();
            commit();
        }
        catch(HibernateException ex)
        {
            UserFrame uf = new UserFrame();
            uf.setVisible(true);
            rollback();
            ex.printStackTrace();
        }
        finally
        {
            close();
        }
        return listKeys;
    }

    public void deleteKey(Key key)
    {
        try
        {
            begin();
            getSession().delete(key);
            commit();
        }
        catch(HibernateException ex)
        {
            rollback();
            ex.printStackTrace();
        }
        finally
        {
            close();
        }
    }

    public Key getKey(int id)
    {
        Key key = new Key();
        try
        {
            begin();
            String hql = "from Key where id = :ID";
            Query query = getSession().createQuery(hql);
            query.setString("ID", id + "");
            key = (Key) query.uniqueResult();
        }
        catch(HibernateException ex)
        {
            rollback();
            ex.printStackTrace();
        }
        finally
        {
            close();
        }
        return key;
    }

    public List<Key> getKey(String column, String tag)
    {
       List<Key> keys = null;
        try
        {
            begin();
            String hql = "from Key where " + column + " like '%" + tag + "%'";
            Query query = getSession().createQuery(hql);
            keys = query.list();
            commit();
        }
        catch(HibernateException ex)
        {
            rollback();
            ex.printStackTrace();
        }
        finally
        {
            close();
        }
        return keys;
    }

    public List<Key> getAny(String tag)
    {
       List<Key> keys = null;
        try
        {
            begin();
            String hql = "from Key where description like '%" + tag + "%'" +
                          " or date like '%" + tag + "%'" +
                          " or tag like '%" + tag + "%'" +
                          " or alias like '%" + tag + "%'" ;
            Query query = getSession().createQuery(hql);
            keys = query.list();
            commit();
        }
        catch(HibernateException ex)
        {
            rollback();
            ex.printStackTrace();
        }
        finally
        {
            close();
        }
        return keys;
    }

    public void update(Key key)
    {
        try
        {
            begin();
            getSession().update(key);
            commit();
        }
        catch(HibernateException ex)
        {
            rollback();
            ex.printStackTrace();
        }
        finally
        {
            close();
        }
    }

    public List<String> getColumn(String colName)
    {
        List<String> list= null;
        try
        {
            begin();
            String hql = "select '" + colName + "' from Key";
            Query query = getSession().createQuery(hql);
            list = query.list();
            commit();
        }
        catch(HibernateException ex)
        {
            rollback();
            ex.printStackTrace();
        }
        finally
        {
            close();
            return list;
        }
    }
}
