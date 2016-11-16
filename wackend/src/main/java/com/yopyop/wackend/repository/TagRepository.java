package com.yopyop.wackend.repository;

import com.yopyop.wackend.model.Tag;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface TagRepository extends JpaRepository<Tag, Integer> {

    public Tag findById(Integer id);
    public Tag findByName(String name);
    
}
