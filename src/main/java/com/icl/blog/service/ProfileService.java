package com.icl.blog.service;

import com.icl.blog.model.Profile;
import com.icl.blog.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {

    private final ProfileRepository profileRepository;

    @Autowired
    public ProfileService(final ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }

    public Optional<Profile> getProfileById(Long id) {
        return profileRepository.findById(id);
    }

    public Profile createProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    public Profile updateProfile(Long id, Profile profileDetails) {
        Profile profile = profileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profile not found with id " + id));
        profile.setName(profileDetails.getName());
        profile.setBio(profileDetails.getBio());
        profile.setImageURL(profileDetails.getImageURL());
        return profileRepository.save(profile);
    }

    public void deleteProfile(Long id) {
        profileRepository.deleteById(id);
    }
}
