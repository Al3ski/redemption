package com.reboot.redemption.mvc.entity;

import com.reboot.redemption.mvc.dto.UserInfoDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDate;

@Entity
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", nullable = false, unique = true)
    private BigInteger id;

    @NonNull
    @Column(name = "name", nullable = false)
    private String name;

    @NonNull
    @Column(name = "surname", nullable = false)
    private String surname;

    @NonNull
    @Temporal(TemporalType.DATE)
    @Column(name = "birthday", nullable = false)
    private LocalDate birthday;

    @Column(name = "email")
    private String email;
}
