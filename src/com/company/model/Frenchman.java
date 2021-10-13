package com.company.model;

public class Frenchman extends AbstractEntity<Frenchman> {
    private Boolean mime;
    private String name;
    private Integer age;

    public Boolean getMime() {
        return mime;
    }

    public void setMime(Boolean mime) {
        this.mime = mime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public void update(Frenchman newEntity) {
        setName(newEntity.getName());
        setMime(newEntity.getMime());
        setAge(newEntity.getAge());
    }
}
