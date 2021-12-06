/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asc.presentation;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author user
 */
public class TCellRenderer extends JTextPane implements TableCellRenderer {

    public TCellRenderer() {
        setContentType("text/html");
        //setOpaque(false);
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Color bgColor = isSelected ? table.getSelectionBackground()
                : table.getBackground();
        String colorinHex = String.format("#%2X%2X%2X",bgColor.getRed(),bgColor.getGreen(),bgColor.getBlue());
        String back = "<html><body bgcolor='"+colorinHex+"' style='margine:0px;'>";
        if (value instanceof JTextPane) {
            JTextPane jl = (JTextPane) value;
            setText(back+jl.getText() +"</body></html>");
        } else {
            if (value instanceof String) {
                setText(back+(String) value+"</body></html>");
            } else {
                setText(back+value.toString()+"</body></html>");
            }
        }

// highlight selected item
        setBackground(isSelected ? table.getSelectionBackground()
                : table.getBackground());
        setForeground(isSelected ? table.getSelectionForeground()
                : table.getForeground());
       
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
