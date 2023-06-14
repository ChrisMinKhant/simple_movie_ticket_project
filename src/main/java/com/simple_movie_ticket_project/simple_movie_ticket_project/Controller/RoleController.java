package com.simple_movie_ticket_project.simple_movie_ticket_project.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simple_movie_ticket_project.simple_movie_ticket_project.DTO.RequestDTO.RoleRequestDTO;
import com.simple_movie_ticket_project.simple_movie_ticket_project.Service.Interfaces.RoleServiceInterface;
import com.simple_movie_ticket_project.simple_movie_ticket_project.Service.Interfaces.UserServiceInterface;
import com.simple_movie_ticket_project.simple_movie_ticket_project.entity.Role;
import com.simple_movie_ticket_project.simple_movie_ticket_project.entity.User;

@RestController
@RequestMapping("/api")
public class RoleController {
    // For Dependency Injection.
    private RoleServiceInterface roleService;

    // Counstructor Injection.
    @Autowired
    RoleController(RoleServiceInterface roleService) {
        this.roleService = roleService;
    }

    // Method for GET::"/roles" endpoint.
    // get all the roles from the roles table.
    @GetMapping("/roles")
    public List<Role> getAllRoles() {

        // Create empty Role List object.
        List<Role> role = new ArrayList<Role>();

        role = roleService.findAll();

        return role;
    }

    // Method for GET::"/roles" endpoint.
    // get one specific role from the roles table.
    @GetMapping("/roles/{id}")
    public Role getRoleById(@PathVariable int id) {

        // Create empty Role object.
        Role role = new Role();

        role = roleService.findById(id);

        return role;
    }

    // Method for POST::"/roles" endpoint.
    // save new role to the roles table.
    @PostMapping("/roles")
    public String saveNewRole(@RequestBody RoleRequestDTO roleRequestDTO) {

        return roleService.save(roleRequestDTO);

    }

    // Method for DELETE::"/roles/{email}" endpoint.
    // delete existing role to the roles table.
    @DeleteMapping("/roles/{email}")
    public void deleteRole(@PathVariable String email) {

        roleService.delete(email);

    }
}
