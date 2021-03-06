package com.codecool.projectegrandebackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class EV {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer evId;
    private String address;
    private String town;
    private double latitude;
    private double longitude;
    private String title;
    private int likedNumber;

    @Transient
    private boolean favorite;

    @Singular
    @ManyToMany(mappedBy = "evs", cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    private Set<AppUser> appUsers = new HashSet<>();

}





