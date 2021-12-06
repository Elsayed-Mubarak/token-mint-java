/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asc.presentation;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

/**
 *
 * @author Administrator
 */
class IconListCellRenderer extends DefaultListCellRenderer {

    private static final long serialVersionUID = 1520051460354891238L;

    @Override
    public Component getListCellRendererComponent(JList list, Object value,
            int index, boolean isSelected, boolean cellHasFocus) {

        if (value instanceof JLabel) {
            JLabel jl = (JLabel) value;
            setText(jl.getText());
            setIcon(jl.getIcon());
        } else {
            if (value instanceof String) {
                setText((String) value);
            } else {
                setText(value.toString());
            }
        }

// highlight selected item
        setBackground(isSelected ? list.getSelectionBackground()
                : list.getBackground());
        setForeground(isSelected ? list.getSelectionForeground()
                : list.getForeground());

        return this;
    }


// override paintComponent method, enable antialiasing
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

// for antialiasing geometric shapes

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

// for antialiasing text
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

// to go for quality over speed
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        super.paintComponent(g2d);
    }
}
