package ru.netology.hibernate.model;

import lombok.*;

import javax.persistence.*;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Persons {
    @EmbeddedId
    private PersonInformation personInformation;
    private String phoneNumber;
    private String cityOfLiving;
}
