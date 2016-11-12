package com.yopyop.wackend.service;

import com.yopyop.wackend.dto.SubscriptionDTO;
import com.yopyop.wackend.model.Subscription;

import java.util.List;

import javax.transaction.Transactional;

public interface SubscriptionService {

    public Subscription add(SubscriptionDTO added);

    public Subscription deleteById(Integer id) throws NotFoundException;
    
    public List<SubscriptionDTO> findAll();

    public Subscription findById(Integer id) throws NotFoundException;

    public Subscription update(SubscriptionDTO updated) throws NotFoundException;
}