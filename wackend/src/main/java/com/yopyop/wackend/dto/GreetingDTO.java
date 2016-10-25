package com.yopyop.wackend.dto;

import com.yopyop.wackend.model.Greeting;

import org.hibernate.validator.constraints.Length;

/**
 * A form object for contracts.
 * @author Petri Kainulainen
 */
public class GreetingDTO {

    private Long id;

    @Length(max = Greeting.MAX_LENGTH_CONTENT)
    private String content;

    public GreetingDTO() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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