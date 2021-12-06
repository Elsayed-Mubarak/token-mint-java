/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.asc.factory_singlton_pattern;

import com.asc.keyEngine.TMAPI;

/**
 *
 * @author ASC 0
 */
public class TMAPISinglton /*implements IAPI*/{

 private static TMAPI api = null;

    public static TMAPI getInstance()
    {
        if (api == null)
        {
            api = new TMAPI();
        }
        return api;
    }

}
