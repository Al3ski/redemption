package com.reboot.redemption.mvc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reboot.redemption.mvc.dto.UserInfoDto;
import com.reboot.redemption.mvc.entity.User;
import com.reboot.redemption.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.IOException;

@Controller
public class UserOperationsController {

    private final UserService userService;

    @Autowired
    public UserOperationsController(UserService userService) {
        this.userService = userService;
    }

    @ResponseBody
    @GetMapping("/generate/test-user")
    public String generateTestUser() throws IOException {
        UserInfoDto userInfoDto = new ObjectMapper()
                .readerFor(UserInfoDto.class)
                .readValue(
                        new File("src/test/resources/dto/user_info_dto_test.json"),
                        UserInfoDto.class
                );

        return userService.createUser(new User(userInfoDto)).toString();
    }
}
