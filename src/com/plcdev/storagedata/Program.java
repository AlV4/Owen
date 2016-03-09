package com.plcdev.storagedata;

import java.util.ArrayList;

public class Program {
    private String name;
    private int amountOfComponents;
    private ArrayList<Component> listOfComponents;

    public Program() {
        listOfComponents = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmountOfComponents() {
        return amountOfComponents;
    }

    public void setAmountOfComponents(int amountOfComponents) {
        this.amountOfComponents = amountOfComponents;
    }

    public ArrayList<Component> getListOfComponents() {
        return listOfComponents;
    }

    public void setListOfComponents(ArrayList<Component> listOfComponents) {
        this.listOfComponents = listOfComponents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Program)) return false;

        Program program = (Program) o;

        if (getAmountOfComponents() != program.getAmountOfComponents()) return false;
        if (getName() != null ? !getName().equals(program.getName()) : program.getName() != null) return false;
        return !(getListOfComponents() != null ? !getListOfComponents().equals(program.getListOfComponents()) : program.getListOfComponents() != null);

    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + getAmountOfComponents();
        result = 31 * result + (getListOfComponents() != null ? getListOfComponents().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Program{" +
                "amountOfComponents=" + amountOfComponents +
                ", name='" + name + '\'' +
                '}';
    }
}
