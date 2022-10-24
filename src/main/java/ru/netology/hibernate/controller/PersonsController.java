package ru.netology.hibernate.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.hibernate.model.Persons;
import ru.netology.hibernate.service.PersonsService;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonsController {
    private PersonsService personsService;

    public PersonsController(PersonsService personsService) {
        this.personsService = personsService;
    }

    @GetMapping("/by-city")
    public List<Persons> getPersonByCity (@RequestParam String city) {
        return personsService.getPersonByCity(city);
    }
}
