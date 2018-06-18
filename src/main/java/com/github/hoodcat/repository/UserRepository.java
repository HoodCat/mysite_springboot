package com.github.hoodcat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.hoodcat.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
