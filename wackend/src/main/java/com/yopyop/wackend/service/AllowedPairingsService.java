package com.yopyop.wackend.service;

import com.yopyop.wackend.dto.AllowedPairingsDTO;
import com.yopyop.wackend.model.AllowedPairings;
import com.yopyop.wackend.model.Erl;

import java.util.List;

public interface AllowedPairingsService {

    public AllowedPairings add(AllowedPairingsDTO added);
    public AllowedPairings deleteByErlCid(String erl_cid) throws NotFoundException;
    public List<AllowedPairings> findAll();
    public AllowedPairings findByErlCid(String erl_cid) throws NotFoundException;
    public AllowedPairings update(AllowedPairingsDTO updated) throws NotFoundException;
}