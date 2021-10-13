package com.company.model;

import java.awt.Color;

public class Beetle extends AbstractEntity<Beetle> {
    //because every beetle can have its own name
    private String name;
    private Integer legsCount;
    private Color color;

    public Beetle(String name, Integer legsCount, Color color) {
        this.name = name;
        this.legsCount = legsCount;
        this.color = color;
    }

    public Beetle() {
    }

    @Override
    public String toString() {
        return "Beetle{" +
                "name='" + name + '\'' +
                ", legsCount=" + legsCount +
                ", color=" + color +
                ", id=" + id +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLegsCount() {
        return legsCount;
    }

    public void setLegsCount(Integer legsCount) {
        this.legsCount = legsCount;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void update(Beetle newEntity) {
        setColor(newEntity.getColor());
        setLegsCount(newEntity.getLegsCount());
        setName(newEntity.getName());
    }

}
