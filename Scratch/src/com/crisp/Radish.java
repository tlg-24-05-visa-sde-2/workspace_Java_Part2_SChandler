package com.crisp;

public class Radish implements Comparable<Radish> {
    private String color;
    private double size;
    private double tailLength;
    private int sproutsOnTop;

    public Radish(String color, double size, double tailLength, int sproutsOnTop) {
        this.color = color;
        this.size = size;
        this.tailLength = tailLength;
        this.sproutsOnTop = sproutsOnTop;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getTailLength() {
        return tailLength;
    }

    public void setTailLength(double tailLength) {
        this.tailLength = tailLength;
    }

    public int getSproutsOnTop() {
        return sproutsOnTop;
    }

    public void setSproutsOnTop(int sproutsOnTop) {
        this.sproutsOnTop = sproutsOnTop;
    }

    @Override
    public int compareTo(Radish o) {
        return Double.compare(this.size, o.size);
    }

    @Override
    public String toString() {
        return String.format("%s: color=%s, size=%s, tailLength=%s, sproutsOnTop=%d",
                getClass().getSimpleName(), getColor(), getSize(), getTailLength(), getSproutsOnTop());
    }
}
