package com.yopyop.wackend.service;

import com.yopyop.wackend.dto.SubscriptionDTO;
import com.yopyop.wackend.model.Subscription;

import java.util.List;

import javax.transaction.Transactional;

public interface SubscriptionService {

    public SubscriptionDTO add(SubscriptionDTO added);

    public SubscriptionDTO deleteById(Integer id) throws NotFoundException;
    
    public List<SubscriptionDTO> findAll();

    public SubscriptionDTO findById(Integer id) throws NotFoundException;

    public SubscriptionDTO update(SubscriptionDTO updated) throws NotFoundException;
}