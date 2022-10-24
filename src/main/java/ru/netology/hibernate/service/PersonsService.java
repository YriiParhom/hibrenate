package ru.netology.hibernate.service;

import org.springframework.stereotype.Service;
import ru.netology.hibernate.model.Persons;
import ru.netology.hibernate.repository.PersonsRepository;

import java.util.List;

@Service
public class PersonsService {
    private PersonsRepository personsRepo;

    public PersonsService(PersonsRepository personsRepo) {
        this.personsRepo = personsRepo;
    }

    public List<Persons> getPersonByCity(String city) {
        return personsRepo.getPersonByCity(city);
    }
}
