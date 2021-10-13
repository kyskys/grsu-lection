package com.company.model;

import java.time.LocalDate;

public class Bread extends AbstractEntity<Bread> {
    private FlourType flour;
    private LocalDate creationDate;
    private Integer aliveDays;
    private Boolean sliced;

    public Bread(FlourType flour, LocalDate creationDate, Integer aliveDays, Boolean sliced) {
        this.flour = flour;
        this.creationDate = creationDate;
        this.aliveDays = aliveDays;
        this.sliced = sliced;
    }

    public FlourType getFlour() {
        return flour;
    }

    public void setFlour(FlourType flour) {
        this.flour = flour;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getAliveDays() {
        return aliveDays;
    }

    public void setAliveDays(Integer aliveDays) {
        this.aliveDays = aliveDays;
    }

    public Boolean isSliced() {
        return sliced;
    }

    public void setSliced(Boolean sliced) {
        this.sliced = sliced;
    }

    @Override
    public void update(Bread newEntity) {
        setSliced(newEntity.isSliced());
        setFlour(newEntity.getFlour());
        setCreationDate(newEntity.getCreationDate());
        setAliveDays(newEntity.getAliveDays());
    }

    @Override
    public String toString() {
        return "Bread{" +
                "flour=" + flour +
                ", creationDate=" + creationDate +
                ", aliveDays=" + aliveDays +
                ", sliced=" + sliced +
                ", id=" + id +
                '}';
    }
}
