package com.shawn.todolist;

public class todolistItem {
    private long id;
    private String title;
    private String content;

    public todolistItem(long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
