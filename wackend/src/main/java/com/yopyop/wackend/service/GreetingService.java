package com.yopyop.wackend.service;

import com.yopyop.wackend.dto.GreetingDTO;
import com.yopyop.wackend.model.Greeting;

import java.util.List;

//import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

/**
 * Specifies the service methods for contracts.
 * @author Petri Kainulainen
 */
public interface GreetingService {

    /**
     * Adds a new contact.
     * @param added The information of the added contact.
     * @return  The added contact.
     */
    public Greeting add(GreetingDTO added);

    /**
     * Deletes a contact.
     * @param id    The id of the deleted contact.
     * @return  The deleted contact.
     * @throws NotFoundException    if a contact is not found with the given id.
     */
    public Greeting deleteById(Integer id) throws NotFoundException;

    /**
     * Finds all contacts.
     * @return  A list of contacts. If no contacts is found this method returns an empty list.
     */
    public List<Greeting> findAll();

    /**
     * Finds a contact.
     * @param id    The id of the wanted contact.
     * @return  The found contact.
     * @throws NotFoundException    if no contact is found with the given id.
     */
    public Greeting findById(Integer id) throws NotFoundException;

    /**
     * Updates the information of a contact.
     * @param updated   The new information of a contact.
     * @return  The updated contact.
     * @throws NotFoundException    if no contact is found with the provided id.
     */
    public Greeting update(GreetingDTO updated) throws NotFoundException;
}