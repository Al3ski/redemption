package com.reboot.redemption.service;

import com.reboot.redemption.dto.UserInfoDto;
import com.reboot.redemption.entity.User;
import com.reboot.redemption.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Optional;

@Slf4j
@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public BigInteger createUser(UserInfoDto userInfoDto) {
        User user = new User(
                userInfoDto.getInitialName(),
                userInfoDto.getInitialSurname(),
                userInfoDto.getBirthday()
        );

        Optional<User> createdUser = Optional.of(userRepository.save(user));

        logger.debug("New user created, id : {}", createdUser.get().getId());

        return createdUser.get().getId();
    }
}
