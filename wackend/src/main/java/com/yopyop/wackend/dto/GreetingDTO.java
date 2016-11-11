package com.yopyop.wackend.dto;

import com.yopyop.wackend.model.Greeting;

import org.hibernate.validator.constraints.Length;

public class GreetingDTO {

    private Integer id;

    @Length(max = Greeting.MAX_LENGTH_CONTENT)
    private String content;

    public GreetingDTO() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return id.toString();
    }
}