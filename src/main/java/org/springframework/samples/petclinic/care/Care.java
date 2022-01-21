package org.springframework.samples.petclinic.care;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.pet.PetType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "care")
public class Care extends BaseEntity {
    
    @NotEmpty
    @Column(unique = true)
    @Size(min = 5, max = 30)
    String name;

    @NotEmpty
    String description;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "asociation1")
    //@NotEmpty
    @NotNull
    @Size(min = 1)
    Set<PetType> compatiblePetTypes;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "asociation2")
    Set<Care> incompatibleCares;
}
