package com.example.demo.User.service;

import com.example.demo.User.model.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    /**
     * Gets the all users.
     *
     * @return the all users
     */
    List<User> getAllUsers();

    /**
     * Gets the user by id.
     *
     * @param userId the user id
     * @return the user by id
     */
    User getUserById(Long userId);

    /**
     * Save user.
     *
     * @param user the user
     * @return the user
     */
    User saveUser(User user);

    /**
     * Update user.
     *
     * @param userId the user id
     * @param user the user
     * @return the user
     */
    User updateUser(Long userId, User user);

    /**
     * Delete user.
     *
     * @param userId the user id
     * @return the user
     */
    Map<String, Boolean> deleteUser(Long userId);
}
