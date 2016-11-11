package com.yopyop.wackend.service;

import com.yopyop.wackend.dto.SubscriptionDTO;
import com.yopyop.wackend.model.Subscription;
import com.yopyop.wackend.repository.SubscriptionRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import com.yopyop.wackend.service.NotFoundException;

@Service
public class RepositorySubscriptionService implements SubscriptionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RepositorySubscriptionService.class);

    @Resource
    private SubscriptionRepository repository;

    @Transactional
    public Subscription add(SubscriptionDTO added) {
        LOGGER.debug("Adding new Subscription with information: {}", added);

        //Creates an instance of a Contact by using the builder pattern
        Subscription subscription = new Subscription ( added.getId(), added.getPrm());

        return repository.save(subscription);
    }

    @Transactional(rollbackFor = NotFoundException.class)
    public Subscription deleteById(Integer id) throws NotFoundException {
        LOGGER.debug("Deleting Subscription by id: {}", id);

        Subscription deleted = findById(id);
        repository.delete(deleted);

        LOGGER.debug("Deleted Subscription: {}", deleted);

        return deleted;
    }

    @Transactional(readOnly = true)
    public List<Subscription> findAll() {
        LOGGER.debug("Finding all Subscription");
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Subscription findById(Integer id) throws NotFoundException {
        LOGGER.debug("Finding Subscription by id: {}", id);

        Subscription found = repository.findOne(id);

        if (found == null) {
            LOGGER.debug("No Subscription found with id: {}", id);
            throw new NotFoundException("findById() No Subscription found with id: " + id);
        }

        LOGGER.debug("Found contact: {}", found);

        return found;
    }

    @Transactional(rollbackFor = NotFoundException.class)
    public Subscription update(SubscriptionDTO updated) throws NotFoundException {
        LOGGER.debug("Updating Subscription with information: {}", updated);

        Subscription found = findById(updated.getId());

        //Update the contact information
       // TODO found.update(updated.getId(), updated.getContent());


        return found;
    }
}