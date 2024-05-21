package ru.fattakhov.intensive.jdbc.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.fattakhov.intensive.jdbc.models.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeRowMapper implements RowMapper<Employee> {
    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        Employee employee = new Employee();
        employee.setId(rs.getLong("employeeid"));
        employee.setFirstName(rs.getString("firstname"));
        employee.setLastName(rs.getString("lastname"));
        employee.setAddress(rs.getString("address"));
        employee.setRoleName(rs.getString("rolename"));
        employee.setSalary(rs.getInt("salary"));
        employee.setAddress(rs.getString("address"));
        employee.setPhoneNumber(rs.getString("phonenumber"));
        return employee;
    }
}
