package com.yopyop.wackend.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.yopyop.wackend.model.Part;


public class TagDTO  {

    private Integer id;
    
	private String name;
	
	private Date validAfter;
	
	private List<PartDTO> parts;

	public TagDTO() {
    }
 
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getValidAfter() {
		return validAfter;
	}

	public void setValidAfter(Date validAfter) {
		this.validAfter = validAfter;
	}
	
    public List<PartDTO> getParts() {
		return parts;
	}

	public void setParts(List<PartDTO> parts) {
		this.parts = parts;
	}
}