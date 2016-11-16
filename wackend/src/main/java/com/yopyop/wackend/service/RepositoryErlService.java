package com.yopyop.wackend.service;

import com.yopyop.wackend.dto.DTOMapper;
import com.yopyop.wackend.dto.ErlDTO;
import com.yopyop.wackend.dto.SubscriptionDTO;
import com.yopyop.wackend.model.Erl;
import com.yopyop.wackend.model.Subscription;
import com.yopyop.wackend.repository.ErlRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

import com.yopyop.wackend.service.NotFoundException;

@Service
public class RepositoryErlService implements ErlService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RepositoryErlService.class);

    @Resource
    private ErlRepository repository;

    @Transactional
    public ErlDTO add(ErlDTO added) {
        LOGGER.debug("Adding new ERL with information: {}", added);

        //Creates an instance of a Contact by using the builder pattern
        Erl e = new Erl ( added.getCid(), added.getSn());

        Erl erl = repository.save(e);
        if ( erl==null) {
        	return null;
        }

        return DTOMapper.toErlDTO(erl);
    }

    @Transactional(rollbackFor = NotFoundException.class)
    public ErlDTO deleteByCid(String cid) throws NotFoundException {
        LOGGER.debug("Deleting ERL by id: {}", cid);

        Erl deleted = repository.findByCid(cid);
        repository.delete(deleted);

        LOGGER.debug("Deleted ERL: {}", deleted);

        return DTOMapper.toErlDTO(deleted);
    }

    @Transactional(readOnly = true)
    public List<ErlDTO> findAll() {
        LOGGER.debug("Finding all contacts");
        List<Erl> erls = repository.findAll();
        
        
        List<ErlDTO> erlsDTO = 
        		erls.stream()
                .map(erl -> DTOMapper.toErlDTO(erl))
                .collect(Collectors.toList());

        return erlsDTO;
    }

    @Transactional(readOnly = true)
    public ErlDTO findByCid(String cid) throws NotFoundException {
        LOGGER.debug("Finding ERL by id: {}", cid);

        Erl found = repository.findOne(cid);

        if (found == null) {
            LOGGER.debug("No Erl found with id: {}", cid);
            throw new NotFoundException("findById() No Erl found with id: " + cid);
        }

        LOGGER.debug("Found Erl: {}", found);

        return DTOMapper.toErlDTO(found);
    }

    @Transactional(rollbackFor = NotFoundException.class)
    public ErlDTO update(ErlDTO updated) throws NotFoundException {
        LOGGER.debug("Updating greeting with information: {}", updated);

        ErlDTO found = findByCid(updated.getCid());

        //Update the contact information
       // TODO found.update(updated.getId(), updated.getContent());


        return found;
    }
}