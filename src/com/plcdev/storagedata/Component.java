package com.plcdev.storagedata;

public class Component {
    private String name;
    private boolean isSplittable;
    int weight;
    int mixingTime;

    public Component() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSplittable() {
        return isSplittable;
    }

    public void setIsSplittable(boolean isSplittable) {
        this.isSplittable = isSplittable;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getMixingTime() {
        return mixingTime;
    }

    public void setMixingTime(int mixingTime) {
        this.mixingTime = mixingTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Component)) return false;

        Component component = (Component) o;

        if (isSplittable() != component.isSplittable()) return false;
        if (getWeight() != component.getWeight()) return false;
        if (getMixingTime() != component.getMixingTime()) return false;
        return !(getName() != null ? !getName().equals(component.getName()) : component.getName() != null);

    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (isSplittable() ? 1 : 0);
        result = 31 * result + getWeight();
        result = 31 * result + getMixingTime();
        return result;
    }

    @Override
    public String toString() {
        return "Component{" +
                "mixingTime=" + mixingTime +
                ", weight=" + weight +
                ", isSplittable=" + isSplittable +
                ", name='" + name + '\'' +
                '}';
    }
}
