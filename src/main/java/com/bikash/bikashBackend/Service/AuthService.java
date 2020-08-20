package com.bikash.bikashBackend.Service;


import com.bikash.bikashBackend.View.Response;
import com.bikash.bikashBackend.dto.LoginDto;
import com.bikash.bikashBackend.dto.UserDto;
import org.springframework.validation.BindingResult;

import javax.servlet.http.HttpServletRequest;

public interface AuthService {
    Response login(LoginDto loginDto, HttpServletRequest request);
    Response create(UserDto userDto, BindingResult result,HttpServletRequest request);
}
