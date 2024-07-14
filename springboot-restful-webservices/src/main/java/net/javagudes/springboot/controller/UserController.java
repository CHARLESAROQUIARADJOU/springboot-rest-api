package net.javagudes.springboot.controller;

import lombok.AllArgsConstructor;
import net.javagudes.springboot.dto.UserDto;

import net.javagudes.springboot.service.UserService;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto users){
       UserDto savedUser= userService.createUser(users);
       return new ResponseEntity<>(savedUser , HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id){
        UserDto getUser = userService.getUserById(id);
        return new ResponseEntity<>(getUser,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> user=userService.getAllUsers();
        return  new ResponseEntity<>(user,HttpStatus.OK);
    }

    @PutMapping("{id}")
public ResponseEntity<UserDto> updateUser(@PathVariable Long id,@RequestBody UserDto user){
        user.setId(id);
    UserDto savedUser= userService.updateUser(user);
    return new ResponseEntity<>(savedUser , HttpStatus.OK);
}

    @DeleteMapping("{id}")
public ResponseEntity<String> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return new ResponseEntity<>("successfully deleted" ,HttpStatus.OK);

}
}
