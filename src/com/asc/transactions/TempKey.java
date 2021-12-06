/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.asc.transactions;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Date;

/**
 *
 * @author ASC 0
 */
public class TempKey {
    private Integer id;
    private PrivateKey privateK;
    private PublicKey publicK;
    private String description;
    private Date date;
    private String tag;
    private String alias;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the privateK
     */
    public PrivateKey getPrivateK() {
        return privateK;
    }

    /**
     * @param privateK the privateK to set
     */
    public void setPrivateK(PrivateKey privateK) {
        this.privateK = privateK;
    }

    /**
     * @return the publicK
     */
    public PublicKey getPublicK() {
        return publicK;
    }

    /**
     * @param publicK the publicK to set
     */
    public void setPublicK(PublicKey publicK) {
        this.publicK = publicK;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the tag
     */
    public String getTag() {
        return tag;
    }

    /**
     * @param tag the tag to set
     */
    public void setTag(String tag) {
        this.tag = tag;
    }

    /**
     * @return the alias
     */
    public String getAlias() {
        return alias;
    }

    /**
     * @param alias the alias to set
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }
}
