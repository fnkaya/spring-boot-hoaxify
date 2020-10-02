package com.hoaxify.ws.authentication;

import com.hoaxify.ws.mapper.UserMapper;
import com.hoaxify.ws.user.User;
import com.hoaxify.ws.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/1.0")
@RequiredArgsConstructor
public class AuthenticationController {

    private static final Logger log = LoggerFactory.getLogger(AuthenticationController.class);

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @PostMapping("/auth")
    public ResponseEntity<?> handleAuthentication(@CurrentUser User user){
        return ResponseEntity.ok(userMapper.mapToVM(user));
    }
}
