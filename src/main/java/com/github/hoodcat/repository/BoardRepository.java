package com.github.hoodcat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.hoodcat.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {

}
