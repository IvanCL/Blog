package com.icl.blog.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String institution;
    private String period;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;

    public Education() {
    }

    public Education(final Long id, final String title, final String institution, final String period) {
        this.id = id;
        this.title = title;
        this.institution = institution;
        this.period = period;
    }

}
