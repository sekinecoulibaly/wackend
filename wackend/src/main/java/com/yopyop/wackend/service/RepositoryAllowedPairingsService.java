package com.yopyop.wackend.service;

import com.yopyop.wackend.dto.AllowedPairingsDTO;
import com.yopyop.wackend.dto.DTOMapper;
import com.yopyop.wackend.model.AllowedPairings;
import com.yopyop.wackend.repository.AllowedPairingsRepository;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

import com.yopyop.wackend.service.NotFoundException;

@Service
public class RepositoryAllowedPairingsService implements AllowedPairingsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RepositorySubscriptionService.class);

    @Resource
    private AllowedPairingsRepository repository;

    @Transactional
    public AllowedPairingsDTO add(AllowedPairingsDTO added) {
        LOGGER.debug("Adding new AllowedPairings with information: {}", added);

        //Creates an instance of a Contact by using the builder pattern
        AllowedPairings a = new AllowedPairings ( added.getErlCid(), added.getSubscriptionId());

        AllowedPairings allowedPairings = repository.save(a);
        if ( allowedPairings==null) {
        	return null;
        }

        AllowedPairingsDTO sdto = DTOMapper.toAllowedPairingsDTO(allowedPairings);

        return sdto;
    }

    @Transactional(rollbackFor = NotFoundException.class)
    public AllowedPairingsDTO deleteByErlCid(String erl_cid) throws NotFoundException {
        LOGGER.debug("Deleting AllowedPairings by erl: {}", erl_cid);


        repository.deleteByErlCid(erl_cid);

        LOGGER.debug("Deleted AllowedPairings: {}", erl_cid);

        return null;
    }

    @Transactional(readOnly = true)
    public List<AllowedPairingsDTO> findAll() {
    	List<AllowedPairings> allowedPairings = repository.findAll();
        LOGGER.debug("Finding all AllowedPairings");
        
        List<AllowedPairingsDTO> allowedPairingsDTO = 
        		allowedPairings.stream()
                .map(allowedPairing -> DTOMapper.toAllowedPairingsDTO(allowedPairing))
                .collect(Collectors.toList());

        return allowedPairingsDTO;
    }

    @Transactional(readOnly = true)
    public AllowedPairingsDTO findByErlCid(String erl_cid) throws NotFoundException {
        LOGGER.debug("Finding AllowedPairings by erl: {}", erl_cid);

        AllowedPairings found = repository.findOne(erl_cid);

        if (found == null) {
            LOGGER.debug("No AllowedPairings found with id: {}", erl_cid);
            throw new NotFoundException("findById() No AllowedPairings found with erl: " + erl_cid);
        }

        LOGGER.debug("Found AllowedPairings: {}", found);

        return DTOMapper.toAllowedPairingsDTO(found);
    }

    @Transactional(rollbackFor = NotFoundException.class)
    public AllowedPairingsDTO update(AllowedPairingsDTO updated) throws NotFoundException {
        LOGGER.debug("Updating Subscription with information: {}", updated);

        AllowedPairingsDTO found = findByErlCid(updated.getErlCid());

        //Update the contact information
       // TODO found.update(updated.getId(), updated.getContent());

        return found;
    }

}