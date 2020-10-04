package com.reboot.redemption.mvc.service;

import com.reboot.redemption.mvc.entity.User;

import java.math.BigInteger;

public interface UserService {

    BigInteger createUser(User user);
}
