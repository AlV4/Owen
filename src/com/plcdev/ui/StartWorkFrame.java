package com.plcdev.ui;

import javax.swing.*;

public class StartWorkFrame extends AbstractWorkPanel {

    public StartWorkFrame() {
        frame = new JFrame("OWEN PLC emulation window");
        frame.setMinimumSize(dimension);
        frame.setLocationRelativeTo(null);

        CardLayoutDemo demo = new CardLayoutDemo();

        demo.addComponentToPane(frame.getContentPane());

        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(isVisible);
    }
}
