package com.fernando.basic.modules.users.models.enttites;

import com.fernando.basic.modules.users.models.converters.PersonNameConverter;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Person {

    @Id
    private Integer id;
    @Convert(converter = PersonNameConverter.class)
    private PersonName personName;
}
