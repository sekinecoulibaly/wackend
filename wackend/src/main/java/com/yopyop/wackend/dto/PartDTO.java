package com.yopyop.wackend.dto;

import com.yopyop.wackend.model.Tag;

public class PartDTO {

    private Integer id;
	
	private String name;
	
	private Tag tag;
	
	private String url;
	

	public PartDTO() {
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

	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}