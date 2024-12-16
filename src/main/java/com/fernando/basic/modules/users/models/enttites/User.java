package com.fernando.basic.modules.users.models.enttites;

import com.fernando.basic.core.helpers.AgeCalculator;
import jakarta.persistence.*;
import lombok.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_users")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private static final Logger logger = LoggerFactory.getLogger(User.class);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY
    )
    private Long id;
    @Column(
            nullable = false,
            length = 50
    )
    private String firstname;

    @Column(
            nullable = false,
            length = 50
    )
    private String lastname;
    @Transient
    private String fullname;
    @Column(
            unique = true,
            length = 150
    )
    private String email;
    private String password;
    private Boolean isActive;
    @Transient
    private Integer age;
    @Column(updatable = false)
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDate birthdate;
    @Transient
    private Set<Role> roles;
    //First
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    /* Second
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
     */
    /* Third
    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "tb_users_address",
      joinColumns =
        { @JoinColumn(name = "user_id", referencedColumnName = "id") },
      inverseJoinColumns =
        { @JoinColumn(name = "address_id", referencedColumnName = "id") })
     */
    private Address address;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email);
    }

    @PrePersist
    public void logNewUserAttempt() {
        createdAt = LocalDateTime.now();
        updatedAt = createdAt;
        logger.info("Attempting to add new user with username: {}", email);
    }

    @PostPersist
    public void logNewUserAdded() {
        logger.info("Added user '{}' with ID: {}", email, id);
    }

    @PreRemove
    public void logUserRemovalAttempt() {
        logger.info("Attempting to delete user: {}", email);
    }

    @PostRemove
    public void logUserRemoval() {
        logger.info("Deleted user: {}", email);
    }

    @PreUpdate
    public void logUserUpdateAttempt() {
        updatedAt = LocalDateTime.now();
        logger.info("Attempting to update user: {}", email);
    }

    @PostUpdate
    public void logUserUpdate() {
        logger.info("Updated user: {}", email);
    }

    @PostLoad
    public void logUserLoad() {
        fullname = firstname + " " + lastname;
        age = AgeCalculator.calculateAge(birthdate);
        logger.info(toString());
    }

}
