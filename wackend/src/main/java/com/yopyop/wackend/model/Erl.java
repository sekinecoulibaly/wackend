package com.yopyop.wackend.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "erl")
// Serializable pour que le ID du JPAREPOSITORY se plaigne pas dans AllowedPairingsRepository
public class Erl implements Serializable {

	private static final long serialVersionUID = 4021196907894575251L;

	@Id
    @SequenceGenerator(name="erl_seq_gen", sequenceName="erl_id_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="erl_seq_gen")
    private Integer id;

	@Column(unique=true)
    private String cid;

	@Column(unique=true)
    private String sn;
    
    public Erl() {	
    }
    
    public Erl( String cid, String sn) {
        this.cid = cid;
        this.sn = sn;
    }
    
    public Erl(Integer id, String cid, String sn) {
        this.id = id;
        this.cid = cid;
        this.sn = sn;
    }

    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
    	this.id = id;
    }

    public String getCid() {
        return cid;
    }
    
    public void setCid(String cid) {
    	this.cid = cid;
    }
    
    public String getSn() {
        return sn;
    }
    
    public void setSn(String sn) {
    	this.sn = sn;
    }
}