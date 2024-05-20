package ru.fattakhov.intensive.jdbc.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.fattakhov.intensive.jdbc.models.Project;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProjectRowMapper implements RowMapper<Project> {
    @Override
    public Project mapRow(ResultSet rs, int rowNum) throws SQLException {
        Project project = new Project();
        project.setId(rs.getLong("projectid"));
        project.setProjectName(rs.getString("projectname"));
        return project;
    }
}
