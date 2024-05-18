package com.example.oauth_2.service;

import com.example.oauth_2.dto.UserProfile;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    public UserProfile getUserProfileByUsername(String username) {
        UserProfile userProfile = new UserProfile();
        userProfile.setUsername(username);
        userProfile.setEmail("example@example.com");
        return userProfile;
    }
}