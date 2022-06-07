package com.example.nhnboardspringboot.service;

import static java.util.Objects.nonNull;

import com.example.nhnboardspringboot.domain.user.UserDto;
import com.example.nhnboardspringboot.repository.UserRepository;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public boolean doLogin(String username, String password, HttpServletRequest request) {
        UserDto user = userRepository.findByUsername(username);

        if (Objects.isNull(user)) {
            return false;
        }

        if (!isValidAccount(user, password)) {
            return false;
        }

        HttpSession session = request.getSession(true);
        session.setAttribute("username", username);

        return true;

    }

    private boolean isValidAccount(UserDto user, String password) {
        return nonNull(user) && Objects.equals(user.getPassword(), password);
    }
}
