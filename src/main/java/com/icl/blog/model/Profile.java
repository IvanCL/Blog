package com.icl.blog.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String bio;

    private String imageURL;

    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Experience> experiencias;

    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Education> formaciones;

    public Profile() {}

    public Profile(final String name, final String bio, final String imageURL) {
        this.name = name;
        this.bio = bio;
        this.imageURL = imageURL;
    }
}
