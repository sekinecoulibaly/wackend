package com.yopyop.wackend.service;

import com.yopyop.wackend.dto.GreetingDTO;
import com.yopyop.wackend.model.Greeting;
import com.yopyop.wackend.repository.GreetingRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import com.yopyop.wackend.service.NotFoundException;

/**
 * This implementation communicates with the data storage by using Spring Data JPA.
 * @author Petri Kainulainen
 */
@Service
public class RepositoryGreetingService implements GreetingService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RepositoryGreetingService.class);

    @Resource
    private GreetingRepository repository;

    @Transactional
    public Greeting add(GreetingDTO added) {
        LOGGER.debug("Adding new contact with information: {}", added);

        //Creates an instance of a Contact by using the builder pattern
        Greeting greeting = new Greeting ( added.getId(), added.getContent());

        return repository.save(greeting);
    }

    @Transactional(rollbackFor = NotFoundException.class)
    public Greeting deleteById(Integer id) throws NotFoundException {
        LOGGER.debug("Deleting greeting by id: {}", id);

        Greeting deleted = findById(id);
        repository.delete(deleted);

        LOGGER.debug("Deleted contact: {}", deleted);

        return deleted;
    }

    @Transactional(readOnly = true)
    public List<Greeting> findAll() {
        LOGGER.debug("Finding all contacts");
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Greeting findById(Integer id) throws NotFoundException {
        LOGGER.debug("Finding greeting by id: {}", id);

        Greeting found = repository.findOne(id);

        if (found == null) {
            LOGGER.debug("No greeting found with id: {}", id);
            throw new NotFoundException("No greeting found with id: " + id);
        }

        LOGGER.debug("Found contact: {}", found);

        return found;
    }

    @Transactional(rollbackFor = NotFoundException.class)
    public Greeting update(GreetingDTO updated) throws NotFoundException {
        LOGGER.debug("Updating greeting with information: {}", updated);

        Greeting found = findById(updated.getId());

        //Update the contact information
       // TODO found.update(updated.getId(), updated.getContent());


        return found;
    }
}