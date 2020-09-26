package com.reboot.redemption.entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "USER")
@Data
public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_id", nullable = false, unique = true)
    private Long id;

    @NonNull
    @Column(name = "name", nullable = false)
    private String name;

    @NonNull
    @Column(name = "surname", nullable = false)
    private String surname;

    @NonNull
    @Temporal(TemporalType.DATE)
    @Column(name = "birthday", nullable = false)
    private Date birthday;

    @Column(name = "email")
    private String email;
}
