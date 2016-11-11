package com.yopyop.wackend.dto;

public class SubscriptionDTO {

    private Integer id;
    private String prm;

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

    @Override
    public String toString() {
        return id.toString();
    }
}