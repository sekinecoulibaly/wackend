package com.yopyop.wackend.repository;

import com.yopyop.wackend.model.Erl;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ErlRepository extends JpaRepository<Erl, String> {
	
    public Erl findById(Integer id);
    public Erl findByCid(String cid);
}
