package com.fernando.basic.modules.companies.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_companies")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String name;

    private String address;

    private String phone;

    @Enumerated(EnumType.STRING)
    private StateCompany stateCompany;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "firstname", column = @Column(name = "contact_firstname")),
            @AttributeOverride(name = "lastname", column = @Column(name = "contact_lastname")),
            @AttributeOverride(name = "phone", column = @Column(name = "contact_phone")),
    })
    private ContactPerson contactPerson;


}