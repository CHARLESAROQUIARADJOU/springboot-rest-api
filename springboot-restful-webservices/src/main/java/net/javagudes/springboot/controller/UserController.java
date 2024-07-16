package net.javagudes.springboot.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.javagudes.springboot.dto.UserDto;

import net.javagudes.springboot.exception.ErrorDetails;
import net.javagudes.springboot.exception.ResourceNotFoundException;
import net.javagudes.springboot.service.UserService;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody @Valid UserDto users){
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
public ResponseEntity<UserDto> updateUser(@PathVariable Long id,@RequestBody @Valid UserDto user){
        user.setId(id);
    UserDto savedUser= userService.updateUser(user);
    return new ResponseEntity<>(savedUser , HttpStatus.OK);
}

    @DeleteMapping("{id}")
public ResponseEntity<String> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return new ResponseEntity<>("successfully deleted" ,HttpStatus.OK);

}
//@ExceptionHandler(ResourceNotFoundException.class)
//public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest webRequest){
//        ErrorDetails errorDetails = new ErrorDetails(
//                LocalDateTime.now(),
//                exception.getMessage(),
//                webRequest.getDescription(false),
//                "USER_NOT_FOUND"
//        );
//        return  new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
//}
}
