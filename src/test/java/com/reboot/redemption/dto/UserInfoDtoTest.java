package com.reboot.redemption.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reboot.redemption.mvc.dto.UserInfoDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class UserInfoDtoTest {

    @Test
    public void testUserInfoDtoJsonSerializationWorks() throws IOException, ParseException {
        UserInfoDto userInfoDto = new ObjectMapper()
                .readerFor(UserInfoDto.class)
                .readValue(
                        new File("src/test/resources/dto/user_info_dto_test.json")
                );

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

        Assertions.assertEquals(userInfoDto.getInitialName(), "test_user#1");
        Assertions.assertEquals(userInfoDto.getInitialSurname(), "test_surname#1");
        Assertions.assertEquals(userInfoDto.getInitialEmail(), "test_email@test.test");
        Assertions.assertEquals(userInfoDto.getBirthday(), dateFormat.parse("09.05.1990"));
    }
}
