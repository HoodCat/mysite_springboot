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

@Entity(name = "user")
@Table(name = "user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long   no;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "gender")
    private Gender gender;
    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "joinDate")
    private Date   joinDate;

    public User() {
    }

    public User(Long no, String name, String email, String password, Gender gender, Date joinDate) {
        this.no = no;
        this.name = name;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.joinDate = joinDate;
    }

}
