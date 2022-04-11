package com.group2.swing;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollBar;

public class ScrollBarCustomCbo extends JScrollBar {

    public ScrollBarCustomCbo() {
        setUI(new ModernScrollBarUICbo());
        setPreferredSize(new Dimension(8, 8));
        setForeground(new Color(48, 144, 216));
        setBackground(Color.WHITE);
    }
}
