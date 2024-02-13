package com.example.demo.User.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.User.exception.ResourceNotFoundException;
import com.example.demo.User.model.User;
import com.example.demo.User.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class UserServiceImpl implements UserService{

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    /** The user repository. */
    @Autowired
    private UserRepository userRepository;

    /**
     * Gets the all users.
     *
     * @return the all users
     */
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Gets the user by id.
     *
     * @return the user by id
     */
    @Override
    public User getUserById(Long userId) {
        User user = new User();
        try {
            user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));
        } catch (ResourceNotFoundException e) {
            LOGGER.error("Error al obtener el usuario",e);
        }
        return user;
    }


    /**
     * Save user.
     *
     * @param user the user
     * @return the user
     */
    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    /**
     * Update user.
     *
     * @param userId the user id
     * @param userDet the user det
     * @return the user
     */
    @Override
    public User updateUser(Long userId, User userDet) {
        User updatedUser = new User();
        try {
            User user = new User();
            user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));
            user.setEmail(userDet.getEmail());
            user.setLastName(userDet.getLastName());
            user.setFirstName(userDet.getFirstName());
            user.setUpdatedAt(new Date());
            updatedUser = userRepository.save(user);
        } catch (ResourceNotFoundException e) {
            LOGGER.error("Error al actualizar el usuario ", e);
        }
        return updatedUser;
    }

    /**
     * Delete user.
     *
     * @param userId the user id
     * @return the user
     */
    @Override
    public Map<String, Boolean> deleteUser(Long userId) {
        Map<String, Boolean> response = new HashMap<String, Boolean>();
        try {
            User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));
            userRepository.delete(user);
            response.put("deleted", Boolean.TRUE);
        } catch (ResourceNotFoundException e) {
            response.put("deleted", Boolean.FALSE);
            LOGGER.error("Error al eliminar el usuario ", e);
        }
        return response;
    }
}
