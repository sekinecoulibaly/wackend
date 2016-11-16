package com.yopyop.wackend.service;

import com.yopyop.wackend.dto.ErlDTO;

import java.util.List;

public interface ErlService {

    public ErlDTO add(ErlDTO added);
    public ErlDTO deleteByCid(String cid) throws NotFoundException;
    public List<ErlDTO> findAll();
    public ErlDTO findByCid(String cid) throws NotFoundException;
    public ErlDTO update(ErlDTO updated) throws NotFoundException;
}