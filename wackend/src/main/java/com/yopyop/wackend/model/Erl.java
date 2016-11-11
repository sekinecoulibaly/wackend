package com.yopyop.wackend.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.transaction.Transactional;

@Entity
@Table(name = "erl")
// Serializable pour que le ID du JPAREPOSITORY se plaigne pas dans AllowedPairingsRepository
public class Erl implements Serializable {


	@GeneratedValue(strategy=GenerationType.AUTO, generator = "erl_seq_gen")
	@SequenceGenerator(name = "erl_seq_gen", sequenceName = "erl_id_seq")
    private Integer id;
	
	@Id
    private String cid;

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