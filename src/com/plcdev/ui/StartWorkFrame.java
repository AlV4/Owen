package com.plcdev.ui;

import com.plcdev.storagedata.*;
import com.plcdev.storagedata.Component;

import javax.swing.*;
import java.awt.*;

public class StartWorkFrame {

    public StartWorkFrame() {
        JFrame frame = new JFrame("OWEN PLC emulation window");
        frame.setMinimumSize(new Dimension(800, 600));
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        UnitManager manager = new UnitManager();
        for(int j = 1; j < 4; j++) {
            Program program = new Program();
            program.setName("Program #" + j);
            program.setAmountOfComponents(3);

            com.plcdev.storagedata.Component component = new Component();
            for (int i = 1; i < 4; i++) {
                component.setName(i + " component");
                component.setIsSplittable(false);
                component.setWeight(i * 100);
                component.setMixingTime(i * i * 30);

                program.getListOfComponents().add(component);
            }
            manager.getListOfPrograms().add(program);
        }
        manager.setCurrentProgram(manager.getListOfPrograms().get(0));
//        manager.setCurrentProgramName(manager.getCurrentProgram().getName());
//        manager.getListOfPrograms().add(new Program());
        DeviceFrames demo = new DeviceFrames(manager);

        demo.addComponentToPane(frame.getContentPane());

        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
