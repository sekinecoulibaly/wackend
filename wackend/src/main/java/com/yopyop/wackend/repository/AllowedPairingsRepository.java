package com.yopyop.wackend.repository;

import com.yopyop.wackend.model.AllowedPairings;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface AllowedPairingsRepository extends JpaRepository<AllowedPairings, String> {

    public List<AllowedPairings> findByErlCid(String erl_cid);

}
