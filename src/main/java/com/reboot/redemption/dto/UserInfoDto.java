package com.reboot.redemption.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@Getter
@ToString
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserInfoDto {
    private String initialName;
    private String initialSurname;
    private String initialEmail;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy", timezone = "UTC")
    private Date birthday;

    @JsonCreator
    public UserInfoDto(
            @JsonProperty("name") String name,
            @JsonProperty("surname") String surname,
            @JsonProperty("email") String email
    ) {
        this.initialName = name;
        this.initialSurname = surname;
        this.initialEmail = email;
    }
}
