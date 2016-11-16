package com.yopyop.wackend.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "tag")
public class Tag implements Serializable {

	private static final long serialVersionUID = -1643026316218007340L;
	
	@Id
    @SequenceGenerator(name="tag_seq_gen", sequenceName="tag_id_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="tag_seq_gen")
	@Column(name = "id", unique = true, nullable = false)
    private Integer id;
	
	@Column(unique=true)
	private String name;
	
	private Date validAfter;
	
    @OneToMany (fetch=FetchType.LAZY, mappedBy = "tag",cascade = CascadeType.ALL)
	private List<Part> parts;

	public Tag() {
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

    public List<Part> getParts() {
		return parts;
	}

	public void setParts(List<Part> parts) {
		this.parts = parts;
	}
}