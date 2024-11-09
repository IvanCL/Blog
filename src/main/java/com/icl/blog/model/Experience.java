package com.icl.blog.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String company;
    private String role;
    private String period;
    private String description;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;

    public Experience() {}

    public Experience(final Long id, final String company, final String role, final String period, final String description) {
        this.id = id;
        this.company = company;
        this.role = role;
        this.period = period;
        this.description = description;
    }

}
