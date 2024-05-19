package ru.fattakhov.intensive.jdbc.models.entity;

import lombok.Data;

@Data
public class Role {
    private Long id;
    private String roleName;
    private int salary;
}
