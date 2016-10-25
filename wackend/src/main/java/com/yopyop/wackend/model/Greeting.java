package com.yopyop.wackend.model;

public class Greeting {

    public static final int MAX_LENGTH_CONTENT = 50;
    
    private final long id;
    private final String content;

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}