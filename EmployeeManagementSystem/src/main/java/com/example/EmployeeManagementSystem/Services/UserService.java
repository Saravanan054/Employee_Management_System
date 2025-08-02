package com.example.EmployeeManagementSystem.Services;

import com.example.EmployeeManagementSystem.Dto.UserDto;
import com.example.EmployeeManagementSystem.Entity.User;
import com.example.EmployeeManagementSystem.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {

        // Validate user data (e.g., check if username already exists)
        if (user.getUsername() == null || user.getPassword() == null || user.getRole() == null) {
            throw new IllegalArgumentException("Username, password, and role cannot be null");
        }
        if (!user.getRole().equals("admin") && !user.getRole().equals("employee")) {
            throw new IllegalArgumentException("Role must be either 'admin' or 'employee'");
        }
        // Save the user to the repository
        user = userRepository.save(user);
        return user;
    }

    public User getUserById(int userId) {
        // Fetch user by ID from the repository
        return userRepository.findById(userId).orElse(null); // Assuming findById returns an Optional
    }

    public List<User> getAllUsers() {
    // Fetch all users from the repository
        return userRepository.findAll(); // Assuming findAll() returns a single user for simplicity
    }

    public User updateUser(int userId, UserDto userDetails) {
        // Fetch the existing user
        User existingUser = getUserById(userId);
        if (existingUser == null) {
            return null; // User not found
        }

        // Update the user details
        existingUser.setUsername(userDetails.getUsername());
        existingUser.setPassword(userDetails.getPassword());
        existingUser.setRole(userDetails.getRole());

        // Save the updated user
        return userRepository.save(existingUser);
    }
    public void deleteUser(int userId) {
        // Delete the user by ID
        userRepository.deleteById(userId);
    }
}
