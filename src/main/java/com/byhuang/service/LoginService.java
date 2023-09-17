package com.byhuang.service;

import com.byhuang.LoginDTO;
import com.byhuang.pojo.entity.User;
import com.byhuang.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    public AuthenticationManager authenticationManager;

    public String login(User user) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(user.getName(), user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        LoginDTO loginDTO = (LoginDTO) authenticate.getPrincipal();
        String token = JWTUtils.generateToken(loginDTO);
        return token;
    }
}
