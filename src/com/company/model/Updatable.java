package com.company.model;

public interface Updatable <T extends AbstractEntity> {
    void update(T newEntity);
}
