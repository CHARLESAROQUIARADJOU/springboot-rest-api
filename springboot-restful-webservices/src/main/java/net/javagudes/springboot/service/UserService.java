package net.javagudes.springboot.service;

import net.javagudes.springboot.dto.UserDto;
import net.javagudes.springboot.entity.User;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto user);

    UserDto getUserById(Long user);

    List<UserDto> getAllUsers();

    UserDto updateUser(UserDto user);

    void deleteUser(Long userid);
}
