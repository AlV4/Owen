package com.plcdev.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CardLayoutDemo implements ItemListener {
    JPanel windows; //a panel that uses CardLayout
    final static String MAINPANEL = "Start main panel";
    final static String NO_PRG_PANEL = "Panel with no programs";
    final static String USER_PRODUST_CHOOSER = "User product chooser";
    final static String USER_INSTRUCTIONS = "User instructions";
    final static String USER_IN_PROGRESS = "User info in progress";
    final static String USER_OPER_COMPLETED = "User operation completed";
    protected JLabel text;
    protected JButton leftButton;
    protected JButton rightButton;

    public void addComponentToPane(Container pane) {
        //Put the JComboBox in a JPanel to get a nicer look.
        JPanel comboBoxPane = new JPanel(); //use FlowLayout
        String comboBoxItems[] = {
                MAINPANEL,
                NO_PRG_PANEL,
                USER_PRODUST_CHOOSER,
                USER_INSTRUCTIONS,
                USER_IN_PROGRESS,
                USER_OPER_COMPLETED
        };
        JComboBox<String> cb = new JComboBox<>(comboBoxItems);
        cb.setEditable(false);
        cb.addItemListener(this);
        comboBoxPane.add(cb);

        windows = new JPanel(new CardLayout());
        windows.add(mainPanel(), MAINPANEL);
        windows.add(noProductPanel(), NO_PRG_PANEL);
        windows.add(productChooser(), USER_PRODUST_CHOOSER);

        pane.add(comboBoxPane, BorderLayout.PAGE_START);
        pane.add(windows, BorderLayout.CENTER);
    }

    public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout) (windows.getLayout());
        cl.show(windows, (String) evt.getItem());
    }

    private JPanel mainPanel(){
        JPanel panel = new JPanel(new GridBagLayout());
        textSet("Please select the use mode.");
        panel.add(text, new GridBagConstraints(
                0, 0, 2, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.VERTICAL, new Insets(0, 0, 0, 0), 0, 0));

        buttonsSet("START", "CONFIG MODE", "start.png", "settings.png", NO_PRG_PANEL, MAINPANEL);

        panel.add(leftButton, new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        panel.add(rightButton, new GridBagConstraints(1, 1, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        return panel;
    }

    private JPanel noProductPanel(){
        JPanel panel = new JPanel(new GridBagLayout());
        textSet("Sorry, no available programs at the moment!");
        panel.add(text, new GridBagConstraints(
                0, 0, 2, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.VERTICAL, new Insets(0, 0, 0, 0), 0, 0));

        buttonsSet("BACK", "CONFIG MODE", "back.png", "settings.png", MAINPANEL, MAINPANEL);

        panel.add(leftButton, new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        panel.add(rightButton, new GridBagConstraints(1, 1, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        return panel;
    }

    private JPanel productChooser(){
        JPanel panel = new JPanel(new GridBagLayout());
        textSet("Select a program from the list below.");
        panel.add(text, new GridBagConstraints(
                0, 0, 2, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.VERTICAL, new Insets(0, 0, 0, 0), 0, 0));

        String comboBoxItems[] = {
                "First program",
                "Second",
                "So on",
                USER_INSTRUCTIONS,
                USER_IN_PROGRESS,
                USER_OPER_COMPLETED
        };

        JComboBox<String> cb = new JComboBox<>(comboBoxItems);
        cb.setEditable(false);
        cb.addItemListener(this);
        panel.add(cb, new GridBagConstraints(0, 1, 2, 1, 1, 1, GridBagConstraints.ABOVE_BASELINE, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        buttonsSet("BACK", "NEXT", "back.png", "next.png", MAINPANEL, MAINPANEL);

        panel.add(leftButton, new GridBagConstraints(0, 2, 1, 1, 1, 1, GridBagConstraints.ABOVE_BASELINE, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        panel.add(rightButton, new GridBagConstraints(1, 2, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        return panel;
    }

    private void buttonsSet(String button1, String button2,String image1, String image2, final String actionPanel1, final String actionPanel2) {
        leftButton = new JButton(button1);
        leftButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        leftButton.setHorizontalTextPosition(SwingConstants.CENTER);
        leftButton.setIcon(new ImageIcon(image1));
        leftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) (windows.getLayout());
                cl.show(windows, actionPanel1);
            }
        });

        rightButton = new JButton(button2);
        rightButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        rightButton.setHorizontalTextPosition(SwingConstants.CENTER);
        rightButton.setIcon(new ImageIcon(image2));
        rightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) (windows.getLayout());
                cl.show(windows,actionPanel2);
            }
        });
    }

    private void textSet(String str) {
        text = new JLabel(str);
        text.setFont(new Font(Font.MONOSPACED, Font.BOLD, 28));
        text.setForeground(new Color(0, 0, 0));
    }
}
