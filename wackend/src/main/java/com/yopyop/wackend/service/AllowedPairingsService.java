package com.yopyop.wackend.service;

import com.yopyop.wackend.dto.AllowedPairingsDTO;

import java.util.List;

public interface AllowedPairingsService {

    public AllowedPairingsDTO add(AllowedPairingsDTO added);
    public AllowedPairingsDTO deleteByErlCid(String erl_cid) throws NotFoundException;
    public List<AllowedPairingsDTO> findAll();
    public AllowedPairingsDTO findByErlCid(String erl_cid) throws NotFoundException;
    public AllowedPairingsDTO update(AllowedPairingsDTO updated) throws NotFoundException;
}