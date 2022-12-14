package com.app.conditionnal.controller;
import com.app.conditionnal.model.SystemProfile;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/")
public class ProfileController {
    private final SystemProfile profile;
    public ProfileController(SystemProfile profile) {
        this.profile = profile;
    }

    @GetMapping("/profile")
    public String getProfile() {
        return profile.getProfile();
    }
}
