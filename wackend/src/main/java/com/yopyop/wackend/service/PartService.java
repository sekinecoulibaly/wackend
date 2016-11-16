package com.yopyop.wackend.service;

import com.yopyop.wackend.dto.PartDTO;

import java.util.List;

public interface PartService {

    public PartDTO add(PartDTO added);
    public PartDTO deleteById(Integer id) throws NotFoundException;
    public List<PartDTO> findAll();
    public PartDTO findById(Integer id) throws NotFoundException;
    public PartDTO update(PartDTO updated) throws NotFoundException;
}