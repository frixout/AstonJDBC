package ru.fattakhov.intensive.jdbc.models;

import lombok.Data;

@Data
public class Employee {
    private Long id;
    private String firstName;
    private String lastName;
    private Long roleId;
    private Long profileId;
}
