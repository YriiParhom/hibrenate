package ru.netology.hibernate.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.netology.hibernate.model.PersonInformation;
import ru.netology.hibernate.model.Persons;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@Component
@RequiredArgsConstructor
public class CreateTableRepository implements CommandLineRunner {

    private final PersonsRepository personsRepository;
    @Override
    @Transactional
    public void run(String... args) throws Exception {
        List<String> names = List.of("Алексей", "Дмитрий", "Станислав", "Евгений", "Сергей", "Владимир");
        List<String> surname = List.of("Иванов", "Петров", "Сидоров", "Смирнов", "Смольный", "Бывалый");
        List<String> cities = List.of("Москва", "Вологда", "Калуга", "Брянск", "Санкт-Петербург", "Казань");

        Random random = new Random();

        IntStream.range(0, 20).forEach(
                i-> {
                    Persons persons = Persons.builder()
                            .personInformation(PersonInformation.builder()
                                    .name(names.get(random.nextInt(names.size())))
                                    .surname(surname.get(random.nextInt(surname.size())))
                                    .age(random.nextInt(18,85)).build())
                            .phoneNumber("8123456789")
                            .cityOfLiving(cities.get(random.nextInt(cities.size())))
                            .build();
                    personsRepository.save(persons);
                }
        );
    }
}

