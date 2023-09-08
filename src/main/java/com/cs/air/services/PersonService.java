package com.cs.air.services;

import com.cs.air.models.Item;
import com.cs.air.models.Person;
import com.cs.air.repositories.PeopleRepository;
import com.cs.air.util.exception.PersonNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@Component
public class PersonService {
    private final PeopleRepository peopleRepository;

    @Autowired
    public PersonService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public List<Person> findAllPeople(){
        return peopleRepository.findAll();
    }

    public Person findOne(int id){
        return peopleRepository.findById(id).orElseThrow(() -> new PersonNotFoundException("Person not found!"));
    }

    @Transactional
    public void save(Person person){
        peopleRepository.save(person);
    }

    public Optional<Person> findByUsername(String username){
        return peopleRepository.findByUsername(username).stream().findFirst();
    }

    public List<Item> findItems(Person person){
        return person.getItems();
    }
}
