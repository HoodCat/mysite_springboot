package com.github.hoodcat.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity(name = "guestbook")
@Table(name = "guestbook")
@Data
public class Guestbook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long   no;
    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private String password;
    @Column(name = "content")
    private String content;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "reg_date")
    private Date   regDate;

    public Guestbook() {
    }

    public Guestbook(Long no, String name, String password, String content, Date regDate) {
        this.no = no;
        this.name = name;
        this.password = password;
        this.content = content;
        this.regDate = regDate;
    }
}
