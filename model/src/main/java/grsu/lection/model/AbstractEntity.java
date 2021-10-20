package grsu.lection.model;

public abstract class AbstractEntity <T extends AbstractEntity> implements Updatable<T> {
    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
