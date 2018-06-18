package com.github.hoodcat.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity(name = "comment")
@Table(name = "comment")
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long   no;
    @Column(name = "content")
    private String content;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "reg_date")
    private Date   regDate;
    @ManyToOne
    @JoinColumn(name = "user_no")
    private User   user;
    @ManyToOne
    @JoinColumn(name = "board_no")
    private Board  board;

    public Comment() {
    }

    public Comment(Long no, String content, Date regDate, User user, Board board) {
        this.no = no;
        this.content = content;
        this.regDate = regDate;
        this.user = user;
        this.board = board;
    }

}
