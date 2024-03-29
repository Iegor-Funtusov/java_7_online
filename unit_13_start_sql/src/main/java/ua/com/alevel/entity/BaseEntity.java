package ua.com.alevel.entity;

import ua.com.alevel.annotations.PK;

public abstract class BaseEntity {

    @PK
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "id=" + id +
                '}';
    }
}
