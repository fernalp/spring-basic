package com.fernando.basic.modules.users.repositories;

import com.fernando.basic.modules.users.models.enttites.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
