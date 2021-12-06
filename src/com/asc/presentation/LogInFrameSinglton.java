/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.asc.presentation;

import com.asc.presentation.LogInFrame;

/**
 *
 * @author pc3-asc
 */
public class LogInFrameSinglton {
    public static LogInFrame frame = null;
    public static LogInFrame getInstance()
    {
        if (frame == null)
        {
            frame = new LogInFrame();
            return frame;
        }
        return frame;
    }
}
