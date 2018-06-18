package com.github.hoodcat.service;

import org.springframework.stereotype.Service;

import com.github.hoodcat.repository.BoardRepository;
import com.github.hoodcat.repository.CommentRepository;

@Service
public class BoardService {
    private BoardRepository boardRepository;
    private CommentRepository commentRepository;

}
