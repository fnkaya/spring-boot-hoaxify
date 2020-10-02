package com.hoaxify.ws.user;

import com.hoaxify.ws.mapper.UserMapper;
import com.hoaxify.ws.viewModel.UserVM;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public void save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public Page<UserVM> findAll(Pageable page, User user){
        if (user != null)
            return userRepository.findByUsernameNot(user.getUsername(), page).map(userMapper::mapToVM);
        return userRepository.findAll(page).map(userMapper::mapToVM);
    }
}
