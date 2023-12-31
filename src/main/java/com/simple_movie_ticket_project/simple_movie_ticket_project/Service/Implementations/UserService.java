package com.simple_movie_ticket_project.simple_movie_ticket_project.Service.Implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.simple_movie_ticket_project.simple_movie_ticket_project.DTO.RequestDTO.UserCreateRequestDTO;
import com.simple_movie_ticket_project.simple_movie_ticket_project.DTO.RequestDTO.UserUpdateRequestDTO;
import com.simple_movie_ticket_project.simple_movie_ticket_project.DTO.ResponseDTO.UserResponseDTO;
import com.simple_movie_ticket_project.simple_movie_ticket_project.JPA.RoleRepository;
import com.simple_movie_ticket_project.simple_movie_ticket_project.JPA.UserRepository;
import com.simple_movie_ticket_project.simple_movie_ticket_project.Service.Interfaces.UserServiceInterface;
import com.simple_movie_ticket_project.simple_movie_ticket_project.entity.Role;
import com.simple_movie_ticket_project.simple_movie_ticket_project.entity.User;

import jakarta.persistence.EntityManager;

@Service
public class UserService implements UserServiceInterface {

    // For Dependency Injection.
    private UserRepository userRepo;
    private EntityManager entityManager;
    private RoleRepository roleRepo;

    // Constructor Injection
    @Autowired
    UserService(UserRepository userRepo, EntityManager entityManager, RoleRepository roleRepo) {
        this.userRepo = userRepo;
        this.entityManager = entityManager;
        this.roleRepo = roleRepo;
    }

    // Find all users.
    @Override
    public List<UserResponseDTO> findAll() {
        // Create empty User List object.
        List<User> userList = new ArrayList<User>();
        List<UserResponseDTO> userDtoList = new ArrayList<UserResponseDTO>();

        userList = userRepo.findAll();

        for (User user : userList) {
            UserResponseDTO temporaryUserDto = new UserResponseDTO();

            temporaryUserDto.setName(user.getName());
            temporaryUserDto.setAge(user.getAge());
            temporaryUserDto.setEmail(user.getEmail());
            temporaryUserDto.setPhone(user.getPhone());
            temporaryUserDto.setAddress(user.getAddress());

            userDtoList.add(temporaryUserDto);
        }

        return userDtoList;
    }

    // Find user by email.
    @Override
    public UserResponseDTO findByEmail(String email) {
        // Create empty User and UserResponseDTO Object.
        User user = new User();
        UserResponseDTO userResponseDTO = new UserResponseDTO();

        // Retrive user record by its' email.
        user = (User) entityManager.createQuery("FROM User WHERE email LIKE :email")
                .setParameter("email", email)
                .getSingleResult();

        // Set user necessary user data to UserResponseDTO by using setter method.
        userResponseDTO.setName(user.getName());
        userResponseDTO.setAge(user.getAge());
        userResponseDTO.setPhone(user.getPhone());
        userResponseDTO.setEmail(user.getEmail());
        userResponseDTO.setAddress(user.getAddress());

        // Return UserResponseDTO.
        return userResponseDTO;
    }

    // Create new user.
    @Override
    public void save(UserCreateRequestDTO userCreateRequestDTO) {

        // Create empty Role and User object.
        Role role = new Role();
        User user = new User();

        // Set User data from New UserCreateRequestDTO through setter method.
        user.setName(userCreateRequestDTO.getName());
        user.setAge(userCreateRequestDTO.getAge());
        user.setPhone(userCreateRequestDTO.getPhone());
        user.setEmail(userCreateRequestDTO.getEmail());
        user.setPassword("{noop}" + userCreateRequestDTO.getPassword());
        user.setAddress(userCreateRequestDTO.getAddress());

        // Persist the User.
        userRepo.save(user);

        // Set the associate role for the user.
        role.setUser(user);
        role.setRole("ROLE_NORMALUSER");

        // Persist the role.
        roleRepo.save(role);
    }

    // Update existing user record.
    @Override
    public void update(UserUpdateRequestDTO userUpdateRequestDTO) {

        // Create empty User object.
        User user = new User();

        // Retrive user record by its' email.
        user = (User) entityManager.createQuery("FROM User WHERE email LIKE :email")
                .setParameter("email", userUpdateRequestDTO.getEmail()).getSingleResult();

        // Set new User data from UserUpdateRequestDTO through User's setter method.
        user.setName(userUpdateRequestDTO.getName());
        user.setAge(userUpdateRequestDTO.getAge());
        user.setPhone(userUpdateRequestDTO.getPhone());
        user.setAddress(userUpdateRequestDTO.getAddress());

        // Persist the User.
        userRepo.save(user);
    }

    // Delete user data.
    @Override
    public void delete(String email) {

        // Create a query to get specific user record and type cast it to User.
        User user = (User) entityManager.createQuery("FROM User WHERE email LIKE :email")
                .setParameter("email", email).getSingleResult();

        // Delete specific user record.
        userRepo.delete(user);
    }
}
