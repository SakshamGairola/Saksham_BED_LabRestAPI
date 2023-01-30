package com.greatlearning.studentMgmt.security.serviceImpl;

import com.greatlearning.studentMgmt.entity.User;
import com.greatlearning.studentMgmt.repository.UserRepository;
import com.greatlearning.studentMgmt.security.SecurityUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getUserByUserName(username);
        if(user == null){
            throw new UsernameNotFoundException(username + " not found.");
        }
        return new SecurityUserDetails(user);
    }
}
