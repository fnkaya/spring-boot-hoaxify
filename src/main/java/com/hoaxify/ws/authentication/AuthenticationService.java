package com.hoaxify.ws.authentication;

import com.hoaxify.ws.user.User;
import com.hoaxify.ws.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userDB = userRepository.findByUsername(username);
        if (userDB == null)
            throw new UsernameNotFoundException("User not found");
        return userDB;
    }
}
