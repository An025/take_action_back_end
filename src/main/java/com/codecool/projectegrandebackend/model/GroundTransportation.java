package com.codecool.projectegrandebackend.model;

import com.codecool.projectegrandebackend.model.generated.transport.vehicle.FuelType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class GroundTransportation extends Transportation{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transport_generator")
    @SequenceGenerator(name="transport_generator", sequenceName = "transport_seq")
    private Long id;

    private double distance;

    private double fuelEfficiency;

    @Enumerated(EnumType.STRING)
    private FuelType fuelType;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    private AppUser user;

}

