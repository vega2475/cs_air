package com.cs.air.util;

import com.cs.air.models.Person;
import com.cs.air.services.PersonService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PeopleValidator implements Validator {

    private final PersonService personService;

    public PeopleValidator(PersonService personService) {
        this.personService = personService;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;

        if(personService.findByUsername(person.getUsername()).isPresent()){
            errors.rejectValue("username", "", "User already exist");
        }
    }
}
