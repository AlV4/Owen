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
    final static String PASS_WINDOW = "Password window";
    final static String SETUP_PRG_MAIN = "Setup main program";
    final static String SETUP_PRG_ELEMENT = "Setup program element";
    final static String CHECK_PRG = "Checking a new program";
    final static String FINISH_PRG = "Program saved";
    final static String NO_PRG_PANEL = "Panel with no programs";
    final static String USER_PRODUCT_CHOOSER = "User product chooser";
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
                PASS_WINDOW,
                SETUP_PRG_MAIN,
                SETUP_PRG_ELEMENT,
                CHECK_PRG,
                FINISH_PRG,
                NO_PRG_PANEL,
                USER_PRODUCT_CHOOSER,
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
        windows.add(productChooser(), USER_PRODUCT_CHOOSER);
        windows.add(userInstructions(), USER_INSTRUCTIONS);
        windows.add(userInProgress(), USER_IN_PROGRESS);
        windows.add(userComplete(), USER_OPER_COMPLETED);
        windows.add(passwordWindow(), PASS_WINDOW);
        windows.add(setUpProgramMain(), SETUP_PRG_MAIN);
        windows.add(setUpProgramElement(), SETUP_PRG_ELEMENT);
        windows.add(checkProgramInput(),CHECK_PRG);
        windows.add(finishProgramWriting(),FINISH_PRG);

        pane.add(comboBoxPane, BorderLayout.PAGE_START);
        pane.add(windows, BorderLayout.CENTER);
    }

    public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout) (windows.getLayout());
        cl.show(windows, (String) evt.getItem());
    }

    private JPanel mainPanel(){
        JPanel panel = new JPanel(new GridBagLayout());
        textSet("Please select the use mode.", new Color(0, 0, 0),28);
        panel.add(text, new GridBagConstraints(
                0, 0, 2, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.VERTICAL, new Insets(0, 0, 0, 0), 0, 0));

        buttonsSet("START", "CONFIG MODE", "start.png", "settings.png", USER_PRODUCT_CHOOSER, PASS_WINDOW);

        panel.add(leftButton, new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        panel.add(rightButton, new GridBagConstraints(1, 1, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        return panel;
    }

    private JPanel noProductPanel(){
        JPanel panel = new JPanel(new GridBagLayout());
        textSet("Sorry, no available programs at the moment!", new Color(0, 0, 0),28);
        panel.add(text, new GridBagConstraints(
                0, 0, 2, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.VERTICAL, new Insets(0, 0, 0, 0), 0, 0));

        buttonsSet("BACK", "CONFIG MODE", "back.png", "settings.png", MAINPANEL, PASS_WINDOW);

        panel.add(leftButton, new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        panel.add(rightButton, new GridBagConstraints(1, 1, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        return panel;
    }

    private JPanel productChooser(){
        JPanel panel = new JPanel(new GridBagLayout());
        textSet("Select a program from the list below.", new Color(0, 0, 0),28);
        panel.add(text, new GridBagConstraints(
                0, 0, 2, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.VERTICAL, new Insets(0, 0, 0, 0), 0, 0));

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
        panel.add(cb, new GridBagConstraints(0, 0, 2, 1, 1, 1, GridBagConstraints.SOUTH, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        buttonsSet("BACK", "NEXT", "back.png", "next.png", MAINPANEL, USER_INSTRUCTIONS);

        panel.add(leftButton, new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        panel.add(rightButton, new GridBagConstraints(1, 1, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        return panel;
    }

    private JPanel userInstructions(){
        JPanel panel = new JPanel(new GridBagLayout());
        textSet("Program #1", new Color(0, 82, 255), 24);
        panel.add(text, new GridBagConstraints(
                0, 0, 2, 1, 0.5, 0.5, GridBagConstraints.NORTH, GridBagConstraints.VERTICAL, new Insets(0, 0, 0, 0), 0, 0));
        JTextArea message = messageSet("Here will be the message what to do,\n" +
                "what component to put inside, and\n" +
                "how much time to wait approximately.", new Color(232, 232, 232), 24);
        panel.add(message, new GridBagConstraints(
                0, 1, 2, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.VERTICAL, new Insets(0, 0, 0, 0), 0, 0));

        buttonsSet("ABORT", "NEXT", "cancel.png", "next.png", MAINPANEL, USER_IN_PROGRESS);

        panel.add(leftButton, new GridBagConstraints(0, 2, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        panel.add(rightButton, new GridBagConstraints(1, 2, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        return panel;
    }

    private JPanel userInProgress(){
        JPanel panel = new JPanel(new GridBagLayout());
        textSet("Program #1", new Color(0, 82, 255),24);
        panel.add(text, new GridBagConstraints(
                0, 0, 2, 1, 0.5, 0.5, GridBagConstraints.NORTH, GridBagConstraints.VERTICAL, new Insets(0, 0, 0, 0), 0, 0));
        textSet("Time estimated:", new Color(0, 0, 0), 16);
        panel.add(text, new GridBagConstraints(
                0, 1, 1, 1, 0.2, 0.2, GridBagConstraints.EAST, GridBagConstraints.VERTICAL, new Insets(0, 0, 0, 20), 0, 0));
        textSet("5 min 45 sec", new Color(0, 0, 0), 16);
        panel.add(text, new GridBagConstraints(
                1, 1, 1, 1, 0.2, 0.2, GridBagConstraints.WEST, GridBagConstraints.VERTICAL, new Insets(0, 20, 0, 0), 0, 0));

        textSet("Weight loaded:", new Color(0, 0, 0), 16);
        panel.add(text, new GridBagConstraints(
                0, 2, 1, 1, 0.2, 0.2, GridBagConstraints.EAST, GridBagConstraints.VERTICAL, new Insets(0, 0, 0, 20), 0, 0));
        textSet("45 kg", new Color(0, 0, 0), 16);
        panel.add(text, new GridBagConstraints(
                1, 2, 1, 1, 0.2, 0.2, GridBagConstraints.WEST, GridBagConstraints.VERTICAL, new Insets(0, 20, 0, 0), 0, 0));

        textSet("Weight left:", new Color(0, 0, 0), 16);
        panel.add(text, new GridBagConstraints(
                0, 3, 1, 1, 0.2, 0.2, GridBagConstraints.EAST, GridBagConstraints.VERTICAL, new Insets(0, 0, 0, 20), 0, 0));
        textSet("65 kg", new Color(0, 0, 0), 16);
        panel.add(text, new GridBagConstraints(
                1, 3, 1, 1, 0.2, 0.2, GridBagConstraints.WEST, GridBagConstraints.VERTICAL, new Insets(0, 20, 0, 0), 0, 0));

        buttonsSet("STOP", "NEXT", "stop.png", "next.png", USER_OPER_COMPLETED, MAINPANEL);

        panel.add(leftButton, new GridBagConstraints(0, 5, 2, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
//        panel.add(rightButton, new GridBagConstraints(1, 5, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        return panel;
    }

    private JPanel userComplete(){
        JPanel panel = new JPanel(new GridBagLayout());
        textSet("Program #1", new Color(0, 82, 255), 24);
        panel.add(text, new GridBagConstraints(
                0, 0, 2, 1, 0.5, 0.5, GridBagConstraints.NORTH, GridBagConstraints.VERTICAL, new Insets(0, 0, 0, 0), 0, 0));
        textSet("SUCCESSFULLY COMPLETED!", new Color(0, 255, 0), 24);
        panel.add(text, new GridBagConstraints(
                0, 1, 2, 1, 0.2, 0.2, GridBagConstraints.NORTH, GridBagConstraints.VERTICAL, new Insets(0, 0, 0, 20), 0, 0));

        buttonsSet("STOP", "HOME", "stop.png", "home.png", MAINPANEL, MAINPANEL);

//        panel.add(leftButton, new GridBagConstraints(0, 2, 2, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        panel.add(rightButton, new GridBagConstraints(1, 2, 2, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        return panel;
    }


    private JPanel passwordWindow(){
        JPanel panel = new JPanel(new GridBagLayout());
        textSet("Input the password in the window below.", new Color(0, 0, 0),28);
        panel.add(text, new GridBagConstraints(
                0, 0, 2, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.VERTICAL, new Insets(0, 0, 0, 0), 0, 0));

        JPasswordField passField = new JPasswordField(10);

        panel.add(passField, new GridBagConstraints(0, 0, 2, 1, 1, 1, GridBagConstraints.SOUTH, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        buttonsSet("BACK", "NEXT", "back.png", "next.png", MAINPANEL, SETUP_PRG_MAIN);

        panel.add(leftButton, new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        panel.add(rightButton, new GridBagConstraints(1, 1, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        return panel;
    }

    private JPanel setUpProgramMain(){
        JPanel panel = new JPanel(new GridBagLayout());
        textSet("Here you can write a new program", new Color(0, 82, 255), 24);
        panel.add(text, new GridBagConstraints(
                0, 0, 2, 1, 0, 0.5, GridBagConstraints.NORTH, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        textSet("Name of the program:", new Color(0, 0, 0), 16);
        panel.add(text, new GridBagConstraints(
                0, 1, 1, 1, 0, 0.1, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        panel.add(textFieldSet(20), new GridBagConstraints(
                1, 1, 1, 1, 0, 0.1, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

        textSet("Amount of ingredients:", new Color(0, 0, 0), 16);
        panel.add(text, new GridBagConstraints(
                0, 2, 1, 1, 0, 0.1, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        panel.add(textFieldSet(3), new GridBagConstraints(
                1, 2, 1, 1, 0, 0.2, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

        buttonsSet("CANCEL", "NEXT", "cancel.png", "next.png", MAINPANEL, SETUP_PRG_ELEMENT);

        panel.add(leftButton, new GridBagConstraints(0, 3, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        panel.add(rightButton, new GridBagConstraints(1, 3, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        return panel;
    }

    private JPanel setUpProgramElement(){
        JPanel panel = new JPanel(new GridBagLayout());
        textSet("Ingredient properties:", new Color(0, 82, 255), 24);
        panel.add(text, new GridBagConstraints(
                0, 0, 2, 1, 0, 0.3, GridBagConstraints.NORTH, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        textSet("Name of the ingredient:", new Color(0, 0, 0), 16);
        panel.add(text, new GridBagConstraints(
                0, 1, 1, 1, 0, 0.1, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        panel.add(textFieldSet(20), new GridBagConstraints(
                1, 1, 1, 1, 0, 0.1, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

        textSet("Type of delivery:", new Color(0, 0, 0), 16);
        panel.add(text, new GridBagConstraints(
                0, 2, 1, 1, 0, 0.1, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        panel.add(textFieldSet(1), new GridBagConstraints(
                1, 2, 1, 1, 0, 0.2, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

        textSet("Weight of the ingredient:", new Color(0, 0, 0), 16);
        panel.add(text, new GridBagConstraints(
                0, 3, 1, 1, 0, 0.1, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        panel.add(textFieldSet(4), new GridBagConstraints(
                1, 3, 1, 1, 0, 0.2, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

        textSet("Needed mixing time:", new Color(0, 0, 0), 16);
        panel.add(text, new GridBagConstraints(
                0, 4, 1, 1, 0, 0.1, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        panel.add(textFieldSet(4), new GridBagConstraints(
                1, 4, 1, 1, 0, 0.2, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

        buttonsSet("CANCEL", "NEXT", "cancel.png", "next.png", SETUP_PRG_MAIN, CHECK_PRG);

        panel.add(leftButton, new GridBagConstraints(0, 5, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        panel.add(rightButton, new GridBagConstraints(1, 5, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        return panel;
    }

    private JPanel checkProgramInput(){
        JPanel panel = new JPanel(new GridBagLayout());
        textSet("Program #1", new Color(0, 82, 255), 24);
        panel.add(text, new GridBagConstraints(
                0, 0, 2, 1, 0.5, 0.5, GridBagConstraints.NORTH, GridBagConstraints.VERTICAL, new Insets(0, 0, 0, 0), 0, 0));
        JTextArea message = messageSet("Here will be the message what components typed in,\n" +
                "their name, weight, all data,\n" +
                "to confirm consistent of the product\n" +
                "and check errors before writing down the new program.", new Color(232, 232, 232), 18);
        panel.add(message, new GridBagConstraints(
                0, 1, 2, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.VERTICAL, new Insets(0, 0, 0, 0), 0, 0));

        buttonsSet("ABORT", "SAVE", "cancel.png", "ok.png", SETUP_PRG_MAIN, FINISH_PRG);

        panel.add(leftButton, new GridBagConstraints(0, 2, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        panel.add(rightButton, new GridBagConstraints(1, 2, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        return panel;
    }

    private JPanel finishProgramWriting(){
        JPanel panel = new JPanel(new GridBagLayout());
        textSet("NEW Program #1", new Color(0, 82, 255), 24);
        panel.add(text, new GridBagConstraints(
                0, 0, 2, 1, 0.5, 0.5, GridBagConstraints.NORTH, GridBagConstraints.VERTICAL, new Insets(0, 0, 0, 0), 0, 0));
        textSet("SUCCESSFULLY SAVED!", new Color(0, 255, 0), 24);
        panel.add(text, new GridBagConstraints(
                0, 1, 2, 1, 0.2, 0.2, GridBagConstraints.NORTH, GridBagConstraints.VERTICAL, new Insets(0, 0, 0, 20), 0, 0));

        buttonsSet("ANOTHER PRG", "HOME", "back.png", "home.png", SETUP_PRG_MAIN, MAINPANEL);

        panel.add(leftButton, new GridBagConstraints(0, 2, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
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
                cl.show(windows, actionPanel2);
            }
        });
    }

    private void textSet(String str, Color color, int size) {
        text = new JLabel(str);
        text.setFont(new Font(Font.MONOSPACED, Font.BOLD, size));
        text.setForeground(color);
    }

    private JTextField textFieldSet(int columns){
        JTextField field = new JTextField(columns);
        return field;
    }

    private JTextArea messageSet(String str, Color color, int size) {
        JTextArea field = new JTextArea(str);
        field.setFont(new Font(Font.MONOSPACED, Font.BOLD, size));
        field.setEditable(false);
        field.setBackground(color);
        field.setSize(200,100);
        return field;
    }
}
