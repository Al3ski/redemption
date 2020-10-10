package com.reboot.redemption.mvc.entity;

import com.reboot.redemption.mvc.dto.UserInfoDto;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity(name = "USERS")
@Table(name = "USERS")
@Data
public class User {

    public User(UserInfoDto userInfoDto) {
        this.name = userInfoDto.getInitialName();
        this.surname = userInfoDto.getInitialSurname();
        this.birthday = userInfoDto.getBirthday();
        this.email = userInfoDto.getInitialEmail();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", columnDefinition = "UUID", nullable = false, unique = true)
    private UUID id;

    @NonNull
    @Column(name = "name", nullable = false)
    private String name;

    @NonNull
    @Column(name = "surname", nullable = false)
    private String surname;

    @NonNull
    @Column(name = "birthday", columnDefinition = "DATE", nullable = false)
    private LocalDate birthday;

    @Column(name = "email")
    private String email;
}
