package ru.fattakhov.intensive.jdbc.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.fattakhov.intensive.jdbc.models.Role;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleRowMapper implements RowMapper<Role> {
    @Override
    public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
        Role role = new Role();
        role.setId(rs.getLong("roleid"));
        role.setRoleName(rs.getString("rolename"));
        role.setSalary(rs.getInt("salary"));
        return role;
    }
}
