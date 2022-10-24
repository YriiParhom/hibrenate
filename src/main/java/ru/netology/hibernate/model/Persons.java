package ru.netology.hibernate.model;

import lombok.*;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;


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
