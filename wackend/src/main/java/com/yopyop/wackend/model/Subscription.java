package com.yopyop.wackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "subscription")
public class Subscription {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator = "subscription_seq_gen")
	@SequenceGenerator(name = "subscription_seq_gen", sequenceName = "subscription_id_seq")
    private Integer id;
	
	@Column(unique=true)
    private String prm;

    @ManyToMany (fetch=FetchType.LAZY)
    @JoinTable(
      name = "allowed_pairings", 
      joinColumns = @JoinColumn(name = "subscription_id", referencedColumnName="id"), 
      inverseJoinColumns = @JoinColumn(name = "erl_cid", referencedColumnName="cid")
    )
    private List<Erl>	erls;
    
    public Subscription() {
        this.erls = new ArrayList<>();
    }
    
    public Subscription(Integer id, String prm) {
        this.id = id;
        this.prm = prm;
        this.erls = new ArrayList<>();
    }

    public Subscription(String prm) {
        this.prm = prm;
        this.erls = new ArrayList<>();
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
    	this.id = id;
    }

    public String getPrm() {
        return prm;
    }
    
    public void setPrm(String prm) {
    	this.prm = prm;
    }

    public List<Erl> getErls() {
        return erls;
    }
    
    public void setErls(List<Erl> erls) {
    	this.erls = erls;
    }
}