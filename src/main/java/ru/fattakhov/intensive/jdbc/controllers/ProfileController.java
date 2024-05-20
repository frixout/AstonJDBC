package ru.fattakhov.intensive.jdbc.controllers;

import org.springframework.web.bind.annotation.*;
import ru.fattakhov.intensive.jdbc.models.DAO.ProfileDAO;
import ru.fattakhov.intensive.jdbc.models.entity.Employee;
import ru.fattakhov.intensive.jdbc.models.entity.Profile;

@RestController
public class ProfileController {

    private final ProfileDAO profileDAO;

    public ProfileController(ProfileDAO profileDAO) {
        this.profileDAO = profileDAO;
    }

    @PostMapping("/profile")
    public Long createProfile(@RequestBody Profile profile) {
        return profileDAO.createProfile(profile);
    }

    @GetMapping("/profile")
    public Profile getProfileById(@RequestParam Long id) {
        return profileDAO.getProfileById(id);
    }

    @PutMapping("/profile")
    public void editProfile(@RequestBody Profile profile){
        profileDAO.updateProfile(profile);
    }

    @DeleteMapping("/profile")
    public void deleteProfile(@RequestParam Long id){
        profileDAO.deleteProfile(id);
    }
}
