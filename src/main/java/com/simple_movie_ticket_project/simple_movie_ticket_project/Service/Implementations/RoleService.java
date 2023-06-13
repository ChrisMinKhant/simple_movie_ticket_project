package com.simple_movie_ticket_project.simple_movie_ticket_project.Service.Implementations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simple_movie_ticket_project.simple_movie_ticket_project.DTO.RequestDTO.RoleRequestDTO;
import com.simple_movie_ticket_project.simple_movie_ticket_project.DTO.ResponseDTO.UserResponseDTO;
import com.simple_movie_ticket_project.simple_movie_ticket_project.JPA.RoleRepository;
import com.simple_movie_ticket_project.simple_movie_ticket_project.Service.Interfaces.RoleServiceInterface;
import com.simple_movie_ticket_project.simple_movie_ticket_project.Service.Interfaces.UserServiceInterface;
import com.simple_movie_ticket_project.simple_movie_ticket_project.entity.Role;
import com.simple_movie_ticket_project.simple_movie_ticket_project.entity.User;

import jakarta.persistence.EntityManager;

@Service
public class RoleService implements RoleServiceInterface {
    // For Dependency Injection.
    private UserServiceInterface userService;
    private RoleRepository roleRepo;
    private EntityManager entityManager;

    // Constructor Injection
    @Autowired
    RoleService(RoleRepository roleRepo, EntityManager entityManager, UserServiceInterface userService) {
        this.userService = userService;
        this.roleRepo = roleRepo;
        this.entityManager = entityManager;
    }

    // Find all roles.
    @Override
    public List<Role> findAll() {
        // Create empty Role List object.
        List<Role> roleList = new ArrayList<Role>();

        roleList = roleRepo.findAll();

        return roleList;
    }

    // Find role by id.
    @Override
    public Role findById(int id) {
        // Create empty Role Object.
        Role role = new Role();

        role = (Role) entityManager.createQuery("FROM Role WHERE id LIKE :id")
                .setParameter("id", id)
                .getSingleResult();

        return role;
    }

    // Create new role.
    @Override
    public void save(RoleRequestDTO roleRequestDTO) {

        // Create empty User and Role object.
        User user = new User();
        Role role = new Role();

        // Retrive user record according user email.
        user = (User) entityManager.createQuery("FROM User WHERE email LIKE :email")
                .setParameter("email", roleRequestDTO.getUserEmail())
                .getSingleResult();

        // Set role with necessary data.
        role.setUser(user);
        role.setRole(roleRequestDTO.getRole());

        // Persist the role.
        roleRepo.save(role);
    }

    // Delete role data.
    @Override
    public void delete(int id) {

        // Create a query to get specific role record and type cast it to Role.
        Role role = (Role) entityManager.createQuery("FROM Role WHERE id LIKE :id")
                .setParameter("id", id).getSingleResult();

        // Delete specific role record.
        roleRepo.delete(role);
    }
}
