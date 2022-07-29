package com.dilshan.rentcloud.repository;

import com.dilshan.rentcloud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import javax.jws.soap.SOAPBinding;

public interface UserDetailsRepository extends JpaRepository<User,Integer> {

    Optional<User> findByUserName(String name);

}
