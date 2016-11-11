package com.yopyop.wackend.repository;

import com.yopyop.wackend.model.Erl;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ErlRepository extends JpaRepository<Erl, String> {

    public List<Erl> findByCid(String cid);

}
