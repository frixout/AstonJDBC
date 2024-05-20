package ru.fattakhov.intensive.jdbc.DAO;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import ru.fattakhov.intensive.jdbc.models.Project;
import ru.fattakhov.intensive.jdbc.mapper.ProjectRowMapper;

@Repository
public class ProjectDAO {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public ProjectDAO(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Long createProject(Project project) {
        String sql = "INSERT INTO project (projectname) VALUES (:projectname) RETURNING projectid";
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("projectname", project.getProjectName());
        return jdbcTemplate.queryForObject(sql, params, Long.class);
    }

    public Project getProjectById(Long projectid) {
        String sql = "SELECT * FROM project WHERE projectid = :projectid";
        SqlParameterSource params = new MapSqlParameterSource("projectid", projectid);
        return jdbcTemplate.queryForObject(sql, params, new ProjectRowMapper());
    }

    public void updateProject(Project project) {
        String sql = "UPDATE project SET projectname = :projectname WHERE projectid = :projectid";
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("projectid", project.getId())
                .addValue("projectname", project.getProjectName());
        jdbcTemplate.update(sql, params);
    }

    public void deleteProject(Long projectid) {
        String sql = "DELETE FROM project WHERE projectid = :projectid";
        SqlParameterSource params = new MapSqlParameterSource("projectid", projectid);
        jdbcTemplate.update(sql, params);
    }
}
