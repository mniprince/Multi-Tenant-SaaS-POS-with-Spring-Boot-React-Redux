package com.mniprince.service.repository;

import com.mniprince.modal.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,  Long> {
    User findByEmail(String email);
}
