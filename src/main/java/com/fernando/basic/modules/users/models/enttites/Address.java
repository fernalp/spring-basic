package com.fernando.basic.modules.users.models.enttites;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Address implements Serializable {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE
    )
    private Long id;
    private String street;
    private String city;
    // First
    @OneToOne(mappedBy = "address")
    /* Second
    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
     */
    /* Third
    @OneToOne(mappedBy = "address")
     */
    private User user;

}
