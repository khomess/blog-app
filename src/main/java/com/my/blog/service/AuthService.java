package com.my.blog.service;

import com.my.blog.dto.user.LoginDto;
import com.my.blog.dto.user.RegisterDto;

public interface AuthService {
    String login(LoginDto loginDto);

    String register(RegisterDto registerDto);
}
