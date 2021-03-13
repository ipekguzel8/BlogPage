package com.uniyaz.PropertyClass;

public class Category {
    private int id;
    private String name;

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public Category(Category category) {
        this.id = category.getId();
        this.name = category.getName();
    }
    public Category( String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return  name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
