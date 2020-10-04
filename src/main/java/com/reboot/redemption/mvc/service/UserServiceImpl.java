package com.reboot.redemption.mvc.service;

import com.reboot.redemption.mvc.entity.User;
import com.reboot.redemption.mvc.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Optional;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public BigInteger createUser(User user) {
        Optional<User> createdUser = Optional.of(userRepository.save(user));

        logger.debug("New user created, id : {}", createdUser.get().getId());

        return createdUser.get().getId();
    }
}
