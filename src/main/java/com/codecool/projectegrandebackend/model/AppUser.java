package com.codecool.projectegrandebackend.model;

import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="users") // Cannot create table with "user", it is reserved. Have to change its name.
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    private String password;

    // roles of the user (ADMIN, USER,..)
    @ElementCollection(fetch = FetchType.EAGER)
    @Builder.Default
    private List<String> roles = new ArrayList<>();

    @Singular
    @ManyToMany(cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JoinTable(
            name = "users_evs",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "ev_id"))
    private Set<EV> evs = new HashSet<>();

    // For the food feature
    @Singular
    @ManyToMany(cascade = {
            CascadeType.ALL
    }, fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JoinTable(
            name = "users_meals",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "meal_id"))

    private Set<Meal> consumedMeals;
    // private Set<Meal> consumedMeals = new HashSet<>();

    @OneToMany(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JoinTable(
            name = "users_travels",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "travel_id"))
    private Set<Transportation> journeys = new HashSet<>();

    public void addJourney(Transportation journey) {
        journeys.add(journey);
    }
}
