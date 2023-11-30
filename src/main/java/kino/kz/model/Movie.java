package kino.kz.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "movies")
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "production_country")
    private String productionCountry;

    @Column(name = "production_year")
    private String productionYear;

    @Column(name = "director")
    private String director;

    @Column(name = "duration")
    private int duration;

    @Column(name = "age_ration")
    private int ageRation;

    @Column(name = "premiere")
    private LocalDate premiere;

    @OneToMany
    private List<Actor> actors = new ArrayList<>();



}
