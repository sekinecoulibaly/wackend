package com.yopyop.wackend.dto;

public class ErlDTO {

    private Integer id;
    private String cid;
    private String sn;

    public ErlDTO() {

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
    
    @Override
    public String toString() {
        return cid.toString();
    }
}