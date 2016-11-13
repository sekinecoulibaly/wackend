package com.yopyop.wackend.repository;

import com.yopyop.wackend.dto.AllowedPairingsDTO;
import com.yopyop.wackend.model.AllowedPairings;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface AllowedPairingsRepository extends JpaRepository<AllowedPairings, String> {

    public List<AllowedPairingsDTO> findByErlCid(String erl_cid);
    public void deleteByErlCid(String erl_cid);
}
