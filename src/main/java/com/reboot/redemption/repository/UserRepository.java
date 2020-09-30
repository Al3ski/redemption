package com.reboot.redemption.repository;

import com.reboot.redemption.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface UserRepository extends CrudRepository<User, BigInteger> {
}
