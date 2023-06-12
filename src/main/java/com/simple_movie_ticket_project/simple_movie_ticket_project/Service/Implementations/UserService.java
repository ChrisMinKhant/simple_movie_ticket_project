package com.simple_movie_ticket_project.simple_movie_ticket_project.Service.Implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.simple_movie_ticket_project.simple_movie_ticket_project.JPA.UserRepository;
import com.simple_movie_ticket_project.simple_movie_ticket_project.Service.Interfaces.UserServiceInterface;
import com.simple_movie_ticket_project.simple_movie_ticket_project.entity.User;

import jakarta.persistence.EntityManager;

@Service
public class UserService implements UserServiceInterface {

    // For Dependency Injection.
    private UserRepository userRepository;
    private EntityManager entityManager;

    UserService(UserRepository userRepository, EntityManager entityManager) {
        this.userRepository = userRepository;
        this.entityManager = entityManager;
    }

    // Find all users.
    @Override
    public List<User> findAll() {
        // Create empty User List object.
        List<User> userList = new ArrayList<User>();

        userList = userRepository.findAll();

        return userList;
    }

    // Find user by id.
    @Override
    public User findById(int id) {
        // Create empty User Object.
        User user = new User();

        user = (User) entityManager.createQuery("FROM User WHERE id LIKE :id")
                .setParameter("id", id)
                .getSingleResult();

        return user;
    }

    // Create new user.
    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    // Delete user data.
    @Override
    public void delete(int id) {

        // Create a query to get specific user record and type cast it to User.
        User user = (User) entityManager.createQuery("FROM User WHERE id LIKE :id")
                .setParameter("id", id).getSingleResult();

        // Delete specific user record.
        userRepository.delete(user);
    }
}
