package com.yopyop.wackend.service;

import com.yopyop.wackend.dto.DTOMapper;
import com.yopyop.wackend.dto.SubscriptionDTO;
import com.yopyop.wackend.model.Subscription;
import com.yopyop.wackend.repository.SubscriptionRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.util.List;
import java.util.stream.Collectors;

import com.yopyop.wackend.service.NotFoundException;

@Service
public class RepositorySubscriptionService implements SubscriptionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RepositorySubscriptionService.class);

    @Resource
    private SubscriptionRepository repository;

    @Transactional
    public SubscriptionDTO add(SubscriptionDTO added) {
        LOGGER.debug("Adding new Subscription with PRM: {}", added.getPrm());

        //Creates an instance of a Contact by using the builder pattern
        Subscription s = new Subscription(added.getPrm());
        LOGGER.debug("Adding new Subscription with id: {}", added.getId());
        Subscription subscription = repository.save(s);
        if ( subscription==null) {
        	return null;
        }

        SubscriptionDTO sdto = DTOMapper.toSubscriptionDTO(subscription);

        return null;
    }

    @Transactional(rollbackFor = NotFoundException.class)
    public SubscriptionDTO deleteById(Integer id) throws NotFoundException {
        LOGGER.debug("Deleting Subscription by id: {}", id);

        Subscription deleted = repository.findOne(id);
        repository.delete(deleted);

        LOGGER.debug("Deleted Subscription: {}", deleted);

        return DTOMapper.toSubscriptionDTO(deleted);
    }

    @Transactional(readOnly = true)
    public List<SubscriptionDTO> findAll() {
    	List<Subscription> subscriptions = repository.findAll();
        LOGGER.debug("Finding all Subscription");
        
        List<SubscriptionDTO> subscriptionsDTO = 
        		subscriptions.stream()
                .map(subscription -> DTOMapper.toSubscriptionDTO(subscription))
                .collect(Collectors.toList());

        return subscriptionsDTO;
    }

    @Transactional(readOnly = true)
    public SubscriptionDTO findById(Integer id) throws NotFoundException {
        LOGGER.debug("Finding Subscription by id: {}", id);

        Subscription found = repository.findOne(id);

        if (found == null) {
            LOGGER.debug("No Subscription found with id: {}", id);
            throw new NotFoundException("findById() No Subscription found with id: " + id);
        }

        LOGGER.debug("Found contact: {}", found);

        return DTOMapper.toSubscriptionDTO(found);
    }

    @Transactional(rollbackFor = NotFoundException.class)
    public SubscriptionDTO update(SubscriptionDTO updated) throws NotFoundException {
        LOGGER.debug("Updating Subscription with information: {}", updated);

        SubscriptionDTO found = findById(updated.getId());

        //Update the contact information
       // TODO found.update(updated.getId(), updated.getContent());


        return found;
    }
}