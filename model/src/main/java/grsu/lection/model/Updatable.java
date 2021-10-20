package grsu.lection.model;

public interface Updatable <T extends AbstractEntity> {
    void update(T newEntity);
}
