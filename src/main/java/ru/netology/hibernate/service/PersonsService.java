package ru.netology.hibernate.service;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.netology.hibernate.model.Persons;
import ru.netology.hibernate.repository.PersonsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PersonsService {
    private PersonsRepository personsRepository;

    public PersonsService(PersonsRepository personsRepository) {
        this.personsRepository = personsRepository;
    }

    public List<Persons> findByCity (String city) {
        return personsRepository.findByCityOfLiving(city);
    }

    public List<Persons>findByLessAge (int age) {
        return personsRepository.findByPersonInformation_AgeLessThan(age, Sort.by("PersonInformation_age"));
    }

    public Optional<Persons>findByNameAndSurname(String name, String surname) {
        return personsRepository.findByPersonInformation_NameAndPersonInformation_Surname(name, surname);
    }

    public Persons save (Persons persons) {
        return personsRepository.save(persons);
    }

    public Long count () {
        return personsRepository.count();
    }

    public void delete(Persons persons) {
        personsRepository.delete(persons);
    }

    public void deleteAll(List<Persons> persons) {
        personsRepository.deleteAll();
    }
}
