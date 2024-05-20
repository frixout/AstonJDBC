package ru.fattakhov.intensive.jdbc.models;

import lombok.Data;

@Data
public class EmplRoleProfProj {
    private Employee employee;
    private Role role;
    private Profile profile;
    private Project project;
}
