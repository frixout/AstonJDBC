package ru.fattakhov.intensive.jdbc.DAO;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import ru.fattakhov.intensive.jdbc.mapper.RoleRowMapper;
import ru.fattakhov.intensive.jdbc.models.Employee;
import ru.fattakhov.intensive.jdbc.mapper.EmployeeRowMapper;

@Repository
public class EmployeeDAO {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public EmployeeDAO(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Long createEmployee(Employee employee) {
        String sql = "INSERT INTO employee (firstname, lastname, roleid, profileid) VALUES (:firstname, :lastname, :roleid, :profileid) RETURNING employeeid";
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("firstname", employee.getFirstName())
                .addValue("lastname", employee.getLastName())
                .addValue("roleid", employee.getRoleId())
                .addValue("profileid", employee.getProfileId());
        return jdbcTemplate.queryForObject(sql, params, Long.class);
    }

    public Employee getEmployeeById(Long employeeid) {
        String sql = "SELECT employeeid, firstname, lastname, roleid, profileid FROM employee WHERE employeeid = :employeeid";
                /*"role.rolename," +
                "role.salary," +
                "profile.address," +
                "profile.phonenumber, " +
                "project.projectname " +*/
                /*"LEFT JOIN role ON employee.roleid = role.roleid " +
                "LEFT JOIN profile ON employee.profileid = profile.profileid " +
                "LEFT JOIN project_employee ON employee.employeeid = project_employee.employeeid " +
                "LEFT JOIN project ON project_employee.projectid = project.projectid " +*/
        SqlParameterSource params = new MapSqlParameterSource("employeeid", employeeid);
        return jdbcTemplate.queryForObject(sql, params, new EmployeeRowMapper());
    }

    public void updateEmployee(Employee employee) {
        String sql = "UPDATE employee SET firstname = :firstname, lastname = :lastname WHERE employeeid = :employeeid";
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("employeeid", employee.getId())
                .addValue("firstname", employee.getFirstName())
                .addValue("lastname", employee.getLastName());
        jdbcTemplate.update(sql, params);
    }

    public void deleteEmployee(Long employeeid) {
        String sql = "DELETE FROM employee WHERE employeeid = :employeeid";
        SqlParameterSource params = new MapSqlParameterSource("employeeid", employeeid);
        jdbcTemplate.update(sql, params);
    }

}
