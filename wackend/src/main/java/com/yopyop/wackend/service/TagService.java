package com.yopyop.wackend.service;

import com.yopyop.wackend.dto.TagDTO;

import java.util.List;

public interface TagService {

    public TagDTO add(TagDTO added);
    public TagDTO deleteByName(String name) throws NotFoundException;
    public List<TagDTO> findAll();
    public TagDTO findByName(String name) throws NotFoundException;
    public TagDTO update(TagDTO updated) throws NotFoundException;
}