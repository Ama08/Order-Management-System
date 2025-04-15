package com.project.oms.controller;

import com.project.oms.dto.CreateUserRequest;
import com.project.oms.dto.UpdateUserRequest;
import com.project.oms.dto.UserDTO;
import com.project.oms.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDTO> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @PostMapping
    public UserDTO CreateUser(@RequestBody CreateUserRequest request){
        return userService.createUser(request);
    }

    @PutMapping("/{id}")
    public UserDTO UpdateUser(@PathVariable Long id, @RequestBody UpdateUserRequest request){
        return userService.updateUser(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

}
