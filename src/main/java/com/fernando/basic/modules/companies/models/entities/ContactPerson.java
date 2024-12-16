package com.fernando.basic.modules.companies.models.entities;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class ContactPerson {

    private String firstname;

    private String lastname;

    private String phone;
}