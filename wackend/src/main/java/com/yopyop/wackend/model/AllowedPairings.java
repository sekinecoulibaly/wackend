package com.yopyop.wackend.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "allowed_pairings")
public class AllowedPairings implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column (name = "erl_cid")
    private String erlCid;
	
    @Column (name = "subscription_id")
    private Integer subscriptionId;
    
    public AllowedPairings() {	
    }
       
    public AllowedPairings(String erlCid,  Integer subscriptionId) {
        this.erlCid = erlCid;
        this.subscriptionId = subscriptionId;
    }

    public String getErlCid() {
        return erlCid;
    }
    
    public void setErlCid(String erlCid) {
    	this.erlCid = erlCid;
    }
    
    public Integer getSubscriptionId() {
        return subscriptionId;
    }
    
    public void setSubscriptionId(Integer subscriptionId) {
    	this.subscriptionId = subscriptionId;
    }
}