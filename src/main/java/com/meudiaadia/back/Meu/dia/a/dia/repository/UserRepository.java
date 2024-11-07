package com.meudiaadia.back.Meu.dia.a.dia.repository;

import com.meudiaadia.back.Meu.dia.a.dia.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    User findByEmailAndPassword(String email, String password);

    User findByUsernameAndPassword(String username, String password);
}

