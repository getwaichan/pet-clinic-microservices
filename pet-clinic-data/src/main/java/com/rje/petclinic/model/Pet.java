package com.rje.petclinic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pets")
public class Pet extends BaseEntity {

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private PetType petType;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "pet")
    private Set<Visit> visits = new HashSet<>();

    public Pet(Long id, String name, PetType petType, Owner owner, LocalDate birthDate, Set<Visit> visits) {
        super(id);
        this.name = name;
        this.petType = petType;
        this.owner = owner;
        this.birthDate = birthDate;
        this.visits = visits;
    }

}