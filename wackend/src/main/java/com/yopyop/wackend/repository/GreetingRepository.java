package com.yopyop.wackend.repository;

import com.yopyop.wackend.model.Greeting;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface GreetingRepository extends JpaRepository<Greeting, Integer> {

    /**
     * Find persons by last name.
     */
    public List<Greeting> findById(Integer id);

}
