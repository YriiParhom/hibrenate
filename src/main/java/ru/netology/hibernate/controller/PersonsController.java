package ru.netology.hibernate.controller;

import org.springframework.web.bind.annotation.*;
import ru.netology.hibernate.model.Persons;
import ru.netology.hibernate.service.PersonsService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class PersonsController {
    PersonsService personsService;

    public PersonsController(PersonsService personsService) {
        this.personsService = personsService;
    }

    @GetMapping("/by-city")
    public List<Persons> findPersonByCity (@RequestParam String city) {
        return personsService.findByCity(city);
    }

    @GetMapping("/by-age")
    public List<Persons> findPersonByAge (@RequestParam int age) {
        return personsService.findByLessAge(age);
    }

    @GetMapping("/by-name-surname")
    public Optional<Persons> findByNameAndSurname (@RequestParam String name, @RequestParam String surname) {
        return personsService.findByNameAndSurname(name, surname);
    }

    @PostMapping("/save")
    public Persons save(@RequestBody Persons persons) {
        return personsService.save(persons);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody Persons persons) {
        personsService.delete(persons);
    }

    @PostMapping("/delete-all")
    public void deleteAll(List<Persons> persons) {
        personsService.deleteAll(persons);
    }

    @GetMapping("/count")
    public Long count() {
        return personsService.count();
    }
}
