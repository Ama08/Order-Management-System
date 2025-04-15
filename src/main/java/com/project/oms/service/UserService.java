package com.project.oms.service;

import com.project.oms.dto.CreateUserRequest;
import com.project.oms.dto.UpdateUserRequest;
import com.project.oms.dto.UserDTO;
import com.project.oms.model.User;
import com.project.oms.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(user -> new UserDTO(user.getId(), user.getUserName(), user.getRole()))
                .collect(Collectors.toList());
    }

    public UserDTO getUserById(Long id) {
        return userRepository.findById(id)
                .map(User::toDTO)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public UserDTO createUser(CreateUserRequest request) {
        User user = User.builder()
                .username(request.getUserName())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .build();
        userRepository.save(user);
        return new UserDTO(user.getId(), user.getUserName(), user.getRole());
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public UserDTO updateUser(Long id, UpdateUserRequest request) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole());
        userRepository.save(user);
        return new UserDTO(user.getId(), user.getUserName(), user.getRole());
    }
}
