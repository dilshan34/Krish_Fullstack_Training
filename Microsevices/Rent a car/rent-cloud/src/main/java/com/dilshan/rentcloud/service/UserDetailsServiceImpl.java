package com.dilshan.rentcloud.service;

import com.dilshan.rentcloud.model.AuthUserDetails;
import com.dilshan.rentcloud.model.User;
import com.dilshan.rentcloud.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
  private   UserDetailsRepository userDetailsRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

        Optional<User> optionalUser = userDetailsRepository.findByUserName(name);

        optionalUser.orElseThrow(()-> new UsernameNotFoundException("User name or password wrong"));

        UserDetails userDetails= new AuthUserDetails(optionalUser.get());

        new AccountStatusUserDetailsChecker().check(userDetails);
        return userDetails;

    }
}
