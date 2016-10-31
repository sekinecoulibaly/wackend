package com.yopyop.wackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "greeting")
public class Greeting {

    public static final int MAX_LENGTH_CONTENT = 50;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator = "greeting_seq_gen")
	@SequenceGenerator(name = "greeting_seq_gen", sequenceName = "greeting_id_seq")
	
	//@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
	
    private String content;

    public Greeting() {	
    }
    
    public Greeting(Integer id, String content) {
        this.id = id;
        this.content = content;
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
}