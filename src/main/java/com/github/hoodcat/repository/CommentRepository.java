package com.github.hoodcat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.hoodcat.domain.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
