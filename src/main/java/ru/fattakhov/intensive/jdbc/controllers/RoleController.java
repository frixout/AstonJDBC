package ru.fattakhov.intensive.jdbc.controllers;

import org.springframework.web.bind.annotation.*;
import ru.fattakhov.intensive.jdbc.DAO.RoleDAO;
import ru.fattakhov.intensive.jdbc.models.Role;

@RestController
public class RoleController {

    private final RoleDAO roleDAO;

    public RoleController(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    @PostMapping("/role")
    public Long createRole(@RequestBody Role role) {
        return roleDAO.createRole(role);
    }

    @GetMapping("/role")
    public Role getRoleById(@RequestParam Long id) {
        return roleDAO.getRoleById(id);
    }

    @PutMapping("/role")
    public void editRole(@RequestBody Role role) {
        roleDAO.updateRole(role);
    }

    @DeleteMapping("/role")
    public void deleteRole(@RequestParam Long id) {
        roleDAO.deleteRole(id);
    }
}
