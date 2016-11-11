package com.yopyop.wackend.service;

import com.yopyop.wackend.dto.AllowedPairingsDTO;
import com.yopyop.wackend.dto.SubscriptionDTO;
import com.yopyop.wackend.model.AllowedPairings;
import com.yopyop.wackend.model.Erl;
import com.yopyop.wackend.model.Subscription;
import com.yopyop.wackend.repository.AllowedPairingsRepository;
import com.yopyop.wackend.repository.SubscriptionRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import com.yopyop.wackend.service.NotFoundException;

@Service
public class RepositoryAllowedPairingsService implements AllowedPairingsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RepositorySubscriptionService.class);

    @Resource
    private AllowedPairingsRepository repository;

    @Transactional
    public AllowedPairings add(AllowedPairingsDTO added) {
        LOGGER.debug("Adding new AllowedPairings with information: {}", added);

        //Creates an instance of a Contact by using the builder pattern
        AllowedPairings allowedPairings = new AllowedPairings ( added.getErlCid(), added.getSubscriptionId());

        return repository.save(allowedPairings);
    }

    @Transactional(rollbackFor = NotFoundException.class)
    public AllowedPairings deleteByErlCid(String erl_cid) throws NotFoundException {
        LOGGER.debug("Deleting AllowedPairings by erl: {}", erl_cid);

        AllowedPairings deleted = findByErlCid(erl_cid);
        repository.delete(deleted);

        LOGGER.debug("Deleted AllowedPairings: {}", deleted);

        return deleted;
    }

    @Transactional(readOnly = true)
    public List<AllowedPairings> findAll() {
        LOGGER.debug("Finding all AllowedPairings");
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public AllowedPairings findByErlCid(String erl_cid) throws NotFoundException {
        LOGGER.debug("Finding AllowedPairings by erl: {}", erl_cid);

        AllowedPairings found = repository.findOne(erl_cid);

        if (found == null) {
            LOGGER.debug("No AllowedPairings found with id: {}", erl_cid);
            throw new NotFoundException("findById() No AllowedPairings found with erl: " + erl_cid);
        }

        LOGGER.debug("Found AllowedPairings: {}", found);

        return found;
    }

    @Transactional(rollbackFor = NotFoundException.class)
    public AllowedPairings update(AllowedPairingsDTO updated) throws NotFoundException {
        LOGGER.debug("Updating Subscription with information: {}", updated);

        AllowedPairings found = findByErlCid(updated.getErlCid());

        //Update the contact information
       // TODO found.update(updated.getId(), updated.getContent());


        return found;
    }

}