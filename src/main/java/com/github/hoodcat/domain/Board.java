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

@Entity(name = "board")
@Table(name = "board")
@Data
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long   no;
    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private String content;
    @Column(name = "group_no")
    private Long   groupNo;
    @Column(name = "order_no")
    private Long   orderNo;
    @Column(name = "depth")
    private Long   depth;
    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "reg_date")
    private Date   regDate;
    @Column(name = "views")
    private Long   views;
    @ManyToOne
    @JoinColumn(name = "user_no")
    private User   user;

    public Board() {
    }

    public Board(Long no, String title, String content, Long groupNo, Long orderNo, Long depth, Date regDate,
            Long views, User user) {
        this.no = no;
        this.title = title;
        this.content = content;
        this.groupNo = groupNo;
        this.orderNo = orderNo;
        this.depth = depth;
        this.regDate = regDate;
        this.views = views;
        this.user = user;
    }

}
