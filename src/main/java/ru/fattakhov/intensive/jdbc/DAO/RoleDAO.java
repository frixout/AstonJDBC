package ru.fattakhov.intensive.jdbc.DAO;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import ru.fattakhov.intensive.jdbc.models.Role;
import ru.fattakhov.intensive.jdbc.mapper.RoleRowMapper;

@Repository
public class RoleDAO {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public RoleDAO(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Long createRole(Role role) {
        String sql = "INSERT INTO role (rolename, salary) VALUES (:rolename, :salary) RETURNING roleid";
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("rolename", role.getRoleName())
                .addValue("salary", role.getSalary());
        return jdbcTemplate.queryForObject(sql, params, Long.class);
    }

    public Role getRoleById(Long roleid) {
        String sql = "SELECT * FROM role WHERE roleid = :roleid";
        SqlParameterSource params = new MapSqlParameterSource("roleid", roleid);
        return jdbcTemplate.queryForObject(sql, params, new RoleRowMapper());
    }

    public void updateRole(Role role) {
        String sql = "UPDATE role SET rolename = :rolename, salary = :salary WHERE roleid = :roleid";
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("roleid", role.getId())
                .addValue("rolename", role.getRoleName())
                .addValue("salary", role.getSalary());
        jdbcTemplate.update(sql, params);
    }

    public void deleteRole(Long roleid) {
        String sql = "DELETE FROM role WHERE roleid = :roleid";
        SqlParameterSource params = new MapSqlParameterSource("roleid", roleid);
        jdbcTemplate.update(sql, params);
    }
}
