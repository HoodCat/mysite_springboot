package com.github.hoodcat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.hoodcat.domain.Guestbook;

public interface GuestbookRepository extends JpaRepository<Guestbook, Long> {
}
