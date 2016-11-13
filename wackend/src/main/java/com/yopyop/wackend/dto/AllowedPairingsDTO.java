package com.yopyop.wackend.dto;

public class AllowedPairingsDTO {

    private String erl_cid;

    private Integer subscription_id;
    
    public AllowedPairingsDTO() {	
    }
    
    public AllowedPairingsDTO(String erl_cid, Integer subscription_id) {
        this.erl_cid = erl_cid;
        this.subscription_id = subscription_id;
    }

    public String getErlCid() {
        return erl_cid;
    }
    
    public void setErlCid(String erl_cid) {
    	this.erl_cid = erl_cid;
    }
    
    public Integer getSubscriptionId() {
        return subscription_id;
    }
    
    public void setSubscriptionId(Integer subscription_id) {
    	this.subscription_id = subscription_id;
    }
}