package ru.netology.hibernate.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.netology.hibernate.model.PersonInformation;
import ru.netology.hibernate.model.Persons;

import java.util.List;
import java.util.Optional;

public interface PersonsRepository extends JpaRepository<Persons, PersonInformation> {
    List<Persons> findByCityOfLiving(String city);

    List<Persons> findByPersonInformation_AgeLessThan(int age, Sort sort);

    Optional<Persons> findByPersonInformation_NameAndPersonInformation_Surname(String name, String surname);
}
