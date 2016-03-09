package com.plcdev.storagedata;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class UnitManager implements ItemListener{
    public static final int MAX_WEIGHT = 1000;
    private ArrayList<Program> listOfPrograms;
    private String currentProgramName;
    private int step;
    private int currentWeight;
    private Program currentProgram;
    private Component currentComponent;

    public UnitManager() {
        listOfPrograms = new ArrayList<>();
    }

    public Program getCurrentProgram() {
        return currentProgram;
    }

    public void setCurrentProgram(Program currentProgram) {
        this.currentProgram = currentProgram;
    }

    public Component getCurrentComponent() {
        return currentComponent;
    }

    public void setCurrentComponent(Component currentComponent) {
        this.currentComponent = currentComponent;
    }

    public ArrayList<Program> getListOfPrograms() {
        return listOfPrograms;
    }

    public void setListOfPrograms(ArrayList<Program> listOfPrograms) {
        this.listOfPrograms = listOfPrograms;
    }

    public String getCurrentProgramName() {
        return currentProgramName;
    }

    public void setCurrentProgramName(String currentProgramName) {
        this.currentProgramName = currentProgramName;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public int getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(int currentWeight) {
        this.currentWeight = currentWeight;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        currentProgramName = ((String)e.getItem());
    }
}
