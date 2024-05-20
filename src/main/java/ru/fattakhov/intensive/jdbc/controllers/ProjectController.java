package ru.fattakhov.intensive.jdbc.controllers;

import org.springframework.web.bind.annotation.*;
import ru.fattakhov.intensive.jdbc.DAO.ProjectDAO;
import ru.fattakhov.intensive.jdbc.models.Project;

@RestController
public class ProjectController {
    private final ProjectDAO projectDAO;

    public ProjectController(ProjectDAO projectDAO) {
        this.projectDAO = projectDAO;
    }


    @PostMapping("/project")
    public Long createProject(@RequestBody Project project)  {
        return projectDAO.createProject(project);
    }

    @GetMapping("/project")
    public Project getProjectById(@RequestParam Long id) {
        return projectDAO.getProjectById(id);
    }

    @PutMapping("/project")
    public void editEmployee(@RequestBody Project project){
        projectDAO.updateProject(project);
    }

    @DeleteMapping("/project")
    public void deleteProject(@RequestParam Long id){
        projectDAO.deleteProject(id);
    }
}
