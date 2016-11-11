package com.yopyop.wackend.repository;

import com.yopyop.wackend.model.Subscription;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface SubscriptionRepository extends JpaRepository<Subscription, Integer> {

    public List<Subscription> findById(Integer id);

}
