package ru.fattakhov.intensive.jdbc.models.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.fattakhov.intensive.jdbc.models.entity.Employee;
import ru.fattakhov.intensive.jdbc.models.entity.Project;

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
