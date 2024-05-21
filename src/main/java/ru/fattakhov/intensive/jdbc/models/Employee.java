package ru.fattakhov.intensive.jdbc.models;

import lombok.Data;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Data
public class Employee {
    private Long id;
    private String firstName;
    private String lastName;
    private Long profileId;
    private String address;
    private String phoneNumber;
    private Long roleId;
    private String roleName;
    private int salary;
    private ArrayList<String> projects;
}
