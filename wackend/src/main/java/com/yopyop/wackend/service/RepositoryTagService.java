package com.yopyop.wackend.service;

import com.yopyop.wackend.dto.DTOMapper;
import com.yopyop.wackend.dto.SubscriptionDTO;
import com.yopyop.wackend.dto.TagDTO;
import com.yopyop.wackend.model.Subscription;
import com.yopyop.wackend.model.Tag;
import com.yopyop.wackend.repository.SubscriptionRepository;
import com.yopyop.wackend.repository.TagRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.util.List;
import java.util.stream.Collectors;

import com.yopyop.wackend.service.NotFoundException;

@Service
public class RepositoryTagService implements TagService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RepositoryTagService.class);

    @Resource
    private TagRepository repository;

    @Transactional
    public TagDTO add(TagDTO added) {
        LOGGER.debug("Adding new tag with name: {}", added.getName());

        //Creates an instance of a Contact by using the builder pattern
        Tag t = new Tag();
        LOGGER.debug("Adding new t with id: {}", added.getId());
        Tag tag = repository.save(t);
        if (tag == null) {
        	return null;
        }

        TagDTO sdto = DTOMapper.toTagDTO(tag);

        return null;
    }

    @Transactional(rollbackFor = NotFoundException.class)
    public TagDTO deleteById(Integer id) throws NotFoundException {
        LOGGER.debug("Deleting tag by id: {}", id);

        Tag deleted = repository.findOne(id);
        if (deleted == null) {
            LOGGER.debug("No tag found with id: {}", id);
            throw new NotFoundException("deleteById() No tag found with id: " + id);
        }
        
        repository.delete(deleted);

        LOGGER.debug("Deleted Tag: {}", id);

        return null;
    }

    @Transactional(readOnly = true)
    public List<TagDTO> findAll() {
    	List<Tag> tags = repository.findAll();
        LOGGER.debug("Finding all Subscription");
        
        List<TagDTO> tagsDTO = 
        		tags.stream()
                .map(tag -> DTOMapper.toTagDTO(tag))
                .collect(Collectors.toList());

        return tagsDTO;
    }

    @Transactional(readOnly = true)
    public TagDTO findById(Integer id) throws NotFoundException {
        LOGGER.debug("Finding tag by id: {}", id);

        Tag found = repository.findOne(id);

        if (found == null) {
            LOGGER.debug("No tag found with id: {}", id);
            throw new NotFoundException("findById() No tag found with id: " + id);
        }

        LOGGER.debug("Found contact: {}", found);

        return DTOMapper.toTagDTO(found);
    }

    @Transactional(rollbackFor = NotFoundException.class)
    public TagDTO update(TagDTO updated) throws NotFoundException {
        LOGGER.debug("Updating tag with information: {}", updated);

        TagDTO found = findById(updated.getId());

        //Update the contact information
       // TODO found.update(updated.getId(), updated.getContent());


        return found;
    }

	@Override
	public TagDTO deleteByName(String name) throws NotFoundException {
        LOGGER.debug("Deleting tag by name: {}", name);

        Tag deleted = repository.findByName(name);
        if (deleted == null) {
            LOGGER.debug("No tag found with id: {}", name);
            throw new NotFoundException("deleteByName() No tag found with name: " + name);
        }
        
        repository.delete(deleted);

        LOGGER.debug("Deleted Tag: {}", name);

        return null;
	}

	@Override
	public TagDTO findByName(String name) throws NotFoundException {
        LOGGER.debug("Finding tag by name: {}", name);

        Tag found = repository.findByName(name);

        if (found == null) {
            LOGGER.debug("No tag found with id: {}", name);
            throw new NotFoundException("findByName() No tag found with name: " + name);
        }

        LOGGER.debug("Found contact: {}", found);

        return DTOMapper.toTagDTO(found);
	}

}