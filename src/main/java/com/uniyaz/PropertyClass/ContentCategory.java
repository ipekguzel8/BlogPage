package com.uniyaz.PropertyClass;

public class ContentCategory {
    private int id;
    private String content;
    private Category category;

    public ContentCategory(int id, String content, Category category) {
        this.id = id;
        this.content = content;
        this.category = category;
    }
    public ContentCategory(String content, Category category) {
        this.content = content;
        this.category = category;
    }
    public ContentCategory(Category category) {
        this.category = category;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
