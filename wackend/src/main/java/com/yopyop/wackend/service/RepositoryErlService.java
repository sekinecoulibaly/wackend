package com.yopyop.wackend.service;

import com.yopyop.wackend.dto.ErlDTO;
import com.yopyop.wackend.model.Erl;
import com.yopyop.wackend.repository.ErlRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import com.yopyop.wackend.service.NotFoundException;

@Service
public class RepositoryErlService implements ErlService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RepositoryErlService.class);

    @Resource
    private ErlRepository repository;

    @Transactional
    public Erl add(ErlDTO added) {
        LOGGER.debug("Adding new ERL with information: {}", added);

        //Creates an instance of a Contact by using the builder pattern
        Erl erl = new Erl ( added.getCid(), added.getSn());

        return repository.save(erl);
    }

    @Transactional(rollbackFor = NotFoundException.class)
    public Erl deleteById(Integer id) throws NotFoundException {
        LOGGER.debug("Deleting ERL by id: {} NOT IMPLEMENTED", id);
/*
        Erl deleted = findByCid(cid);
        repository.delete(deleted);

        LOGGER.debug("Deleted ERL: {}", deleted);

        return deleted;*/
        return null;
    }

    @Transactional(readOnly = true)
    public List<Erl> findAll() {
        LOGGER.debug("Finding all contacts");
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Erl findByCid(String cid) throws NotFoundException {
        LOGGER.debug("Finding ERL by id: {}", cid);

        Erl found = repository.findOne(cid);

        if (found == null) {
            LOGGER.debug("No Erl found with id: {}", cid);
            throw new NotFoundException("findById() No Erl found with id: " + cid);
        }

        LOGGER.debug("Found Erl: {}", found);

        return found;
    }

    @Transactional(rollbackFor = NotFoundException.class)
    public Erl update(ErlDTO updated) throws NotFoundException {
        LOGGER.debug("Updating greeting with information: {}", updated);

        Erl found = findByCid(updated.getCid());

        //Update the contact information
       // TODO found.update(updated.getId(), updated.getContent());


        return found;
    }
}