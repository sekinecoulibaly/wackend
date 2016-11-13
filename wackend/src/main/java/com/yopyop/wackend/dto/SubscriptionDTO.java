package com.yopyop.wackend.dto;

import java.util.List;

import com.yopyop.wackend.dto.ErlDTO;

public class SubscriptionDTO {

    private Integer id;
    private String prm;
    private List<ErlDTO>	erls;
    
    public SubscriptionDTO() {

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

    public List<ErlDTO> getErls() {
        return erls;
    }
    
    public void setErls(List<ErlDTO> erls) {
    	this.erls = erls;
    }

}