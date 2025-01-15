package com.example.demoM.service.user;

import com.example.demoM.dto.UserDto;
import com.example.demoM.model.RegistrationRequest;
import com.example.demoM.model.User;

import java.util.List;

public interface UserService {

    boolean checkEmail(String email);

    UserDto registerUser(RegistrationRequest registrationRequest);

    UserDto getLoginUser();

    UserDto getUserById(Integer id);

    List<UserDto> getAllUsers();

    UserDto createUser(User user);

    UserDto updateUser(User user);

    void deleteUser(User user);
}
