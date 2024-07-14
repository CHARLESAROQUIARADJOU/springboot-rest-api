package net.javagudes.springboot.service.impl;

import lombok.AllArgsConstructor;
import net.javagudes.springboot.dto.UserDto;
import net.javagudes.springboot.entity.User;
import net.javagudes.springboot.repository.UserRepository;
import net.javagudes.springboot.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = modelMapper.map(userDto,User.class);
//        User user =new User(userDto.getId(),userDto.getFirstName(),userDto.getLastName(),userDto.getEmail());
        User savedUser= userRepository.save(user);

        return modelMapper.map(savedUser,UserDto.class);

    }

    @Override
    public UserDto getUserById(Long userid) {
        Optional<User> users = userRepository.findById(userid);
        return modelMapper.map(users.get(),UserDto.class);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map((user)->modelMapper.map(user,UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto user) {
        User existinguser=userRepository.findById(user.getId()).get();
        existinguser.setFirstName(user.getFirstName());
        existinguser.setLastName(user.getLastName());
        existinguser.setEmail(user.getEmail());
        userRepository.save(existinguser);
        return modelMapper.map(existinguser,UserDto.class);
    }

    @Override
    public void deleteUser(Long userid) {
userRepository.deleteById(userid);
    }

}
