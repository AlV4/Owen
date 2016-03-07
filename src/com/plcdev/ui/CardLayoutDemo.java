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
    protected JLabel text;
    protected JButton user;
    protected JButton engineer;

    public void addComponentToPane(Container pane) {
        //Put the JComboBox in a JPanel to get a nicer look.
        JPanel comboBoxPane = new JPanel(); //use FlowLayout
        String comboBoxItems[] = {MAINPANEL, NO_PRG_PANEL};
        JComboBox<String> cb = new JComboBox<>(comboBoxItems);
        cb.setEditable(false);
        cb.addItemListener(this);
        comboBoxPane.add(cb);

        //Create the "cards".
        JPanel card1 = createMainPanel();

        JPanel card2 = createNoProductPanel();

        //Create the panel that contains the "cards".
        windows = new JPanel(new CardLayout());
        windows.add(card1, MAINPANEL);
        windows.add(card2, NO_PRG_PANEL);

        pane.add(comboBoxPane, BorderLayout.PAGE_START);
        pane.add(windows, BorderLayout.CENTER);
    }

    public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout) (windows.getLayout());
        cl.show(windows, (String) evt.getItem());
    }

    private JPanel createMainPanel(){
        JPanel panel = new JPanel(new GridBagLayout());
        textSet("Please select the use mode.");
        panel.add(text, new GridBagConstraints(
                0, 0, 2, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.VERTICAL, new Insets(0, 0, 0, 0), 0, 0));
        buttonsSet();
        panel.add(user, new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        panel.add(engineer, new GridBagConstraints(1, 1, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        return panel;
    }
    private JPanel createNoProductPanel(){
        JPanel panel = new JPanel(new GridBagLayout());
        textSet("Sorry, there is no available programs at the moment!");
        panel.add(text, new GridBagConstraints(
                0, 0, 2, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.VERTICAL, new Insets(0, 0, 0, 0), 0, 0));
        user = new JButton("BACK");
        user.setVerticalTextPosition(SwingConstants.BOTTOM);
        user.setHorizontalTextPosition(SwingConstants.CENTER);
        user.setIcon(new ImageIcon("back.png"));
        user.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) (windows.getLayout());
                cl.show(windows, MAINPANEL);
            }
        });

        engineer = new JButton("CONFIG MODE");
        engineer.setVerticalTextPosition(SwingConstants.BOTTOM);
        engineer.setHorizontalTextPosition(SwingConstants.CENTER);
        engineer.setIcon(new ImageIcon("settings.png"));

        panel.add(user, new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        panel.add(engineer, new GridBagConstraints(1, 1, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        return panel;
    }

    private void buttonsSet() {
        user = new JButton("START");
        user.setVerticalTextPosition(SwingConstants.BOTTOM);
        user.setHorizontalTextPosition(SwingConstants.CENTER);
        user.setIcon(new ImageIcon("start.png"));
        user.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) (windows.getLayout());
                cl.show(windows, NO_PRG_PANEL);
            }
        });

        engineer = new JButton("CONFIG MODE");
        engineer.setVerticalTextPosition(SwingConstants.BOTTOM);
        engineer.setHorizontalTextPosition(SwingConstants.CENTER);
        engineer.setIcon(new ImageIcon("settings.png"));
    }

    private void textSet(String str) {
        text = new JLabel(str);
        text.setFont(new Font(Font.MONOSPACED, Font.BOLD, 28));
        text.setForeground(new Color(0, 0, 0));
    }
}
