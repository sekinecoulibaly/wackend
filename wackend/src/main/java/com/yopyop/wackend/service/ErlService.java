package com.yopyop.wackend.service;

import com.yopyop.wackend.dto.ErlDTO;
import com.yopyop.wackend.model.Erl;

import java.util.List;

import javax.transaction.Transactional;

public interface ErlService {

    public Erl add(ErlDTO added);
    public Erl deleteById(Integer id) throws NotFoundException;
    public List<Erl> findAll();
    public Erl findByCid(String cid) throws NotFoundException;
    public Erl update(ErlDTO updated) throws NotFoundException;
}