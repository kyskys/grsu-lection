package com.company.model;

import java.util.Date;

public class Bread extends AbstractEntity<Bread> {
    private FlourType flour;
    private Date creationDate;
    private Integer aliveDays;
    private Boolean sliced;

    public FlourType getFlour() {
        return flour;
    }

    public void setFlour(FlourType flour) {
        this.flour = flour;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
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
}
