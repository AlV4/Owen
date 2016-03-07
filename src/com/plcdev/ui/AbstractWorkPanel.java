package com.plcdev.ui;

import javax.swing.*;
import java.awt.*;

public abstract class AbstractWorkPanel extends JFrame{
    protected JFrame frame;
    protected JButton user;
    protected JButton engineer;
    protected JLabel text;
    protected JPanel panel;
    protected Dimension dimension = new Dimension(800, 600);
    protected boolean isVisible = true;

    @Override
    public boolean isVisible() {
        return isVisible;
    }

    public void setIsVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }
}
