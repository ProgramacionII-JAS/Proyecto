package co.edu.unbosque.jpa.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Pet extends from Owner and represents the entities, the relationships that the Pet table will have, with the others.
 * @author Oscar Santiago Florez, Yilber Andrey Rojas, Ana Lucero Perez y Juan Sebastian vargas
 *
 */

@Entity
@Table(name = "Pet")
public class Pet implements Serializable{

    /**
     * Primary key pet_id column of the pet table
     */
    @Id
    @Column(name = "pet_id")
    private Integer petId;

    /**
     * Microchip column of the pet table
     */
    @Column(name = "microchip")
    private String microChip;

    /**
     * Name column of the pet table
     */
    @Column(name = "name")
    private String name;

    /**
     * Species column of the pet table
     */
    @Column(name = "species")
    private String species;

    /**
     * Race column of the pet table
     */
    @Column(name = "race")
    private String race;

    /**
     * Size column of the pet table
     */
    @Column(name = "size")
    private String size;

    /**
     * Sex column of the pet table
     */
    @Column(name = "sex")
    private String sex;

    /**
     * Picture column of the pet table
     */
    @Column(name = "picture")
    private String picture;

    /**
     * Owner_id column of the pet table person_id reference
     */
    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "person_id")
    private Owner ownerId;

    /**
     * One to many relationship referencing the pet_id
     */
    @OneToMany(mappedBy = "pet_id",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Visit> visit = new ArrayList<>();

    /**
     * One to many relationship referencing the pet_id
     */
    @OneToMany(mappedBy = "pet_id", cascade = CascadeType.MERGE)
    private List<PetCase> petCase = new ArrayList<>();

    /**
     * Create a pet receiving as a parameter, the petIt, the microchip, the name, the species, the race, the size, the sex and the picture.
     * @param petId Id de la mascota
     * @param microChip microchip de la mascota
     * @param name nombre de la mascota
     * @param species especie de la mascota
     * @param race raza de la mascota
     * @param size tamaño de la mascota
     * @param sex sexo de la mascota
     * @param picture imagen de la mascota
     */
    public Pet(Integer petId, String microChip, String name, String species, String race, String size, String sex, String picture) {
        this.petId = petId;
        this.microChip = microChip;
        this.name = name;
        this.species = species;
        this.race = race;
        this.size = size;
        this.sex = sex;
        this.picture = picture;
    }

    public Pet() {

    }

    /**
     * Add a petCase receiving a petCase as a parameter
     * @param petcases
     */
    public void addPetCase(PetCase petcases) {
        petCase.add(petcases);
        petcases.setPetId(this);
    }

    /**
     * Add a visit receiving a visits as a parameter
     * @param visits
     */
    public void addVisit(Visit visits) {
        visit.add(visits);
        visits.setPet_id(this);
    }

    /**
     * Gets the petId
     * @return petId
     */
    public Integer getPetId() {
        return petId;
    }

    /**
     * Sets the petId
     * @param petId
     */
    public void setPetId(Integer petId) {
        this.petId = petId;
    }

    /**
     * Gets the microchip
     * @return microchip
     */
    public String getMicroChip() {
        return microChip;
    }

    /**
     * Sets the microchip
     * @param microChip
     */
    public void setMicroChip(String microChip) {
        this.microChip = microChip;
    }

    /**
     * Gets the name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the species
     * @return species
     */
    public String getSpecies() {
        return species;
    }

    /**
     * Sets the species
     * @param species
     */
    public void setSpecies(String species) {
        this.species = species;
    }

    /**
     * Gets the race
     * @return race
     */
    public String getRace() {
        return race;
    }

    /**
     * Sets the race
     * @param race
     */
    public void setRace(String race) {
        this.race = race;
    }

    /**
     * Gets the size
     * @return size
     */
    public String getSize() {
        return size;
    }

    /**
     * Sets the size
     * @param size
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * Gets the sex
     * @return sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * Sets the sex
     * @param sex
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * Gets the picture
     * @return picture
     */
    public String getPicture() {
        return picture;
    }

    /**
     *Sets the picture
     * @param picture
     */
    public void setPicture(String picture) {
        this.picture = picture;
    }

    /**
     * Gets the owner
     * @return owner
     */
    public Owner getOwner() {
        return ownerId;
    }

    /**
     * Sets the owner
     * @param owner
     */
    public void setOwner(Owner owner) {
        this.ownerId = owner;
    }

    /**
     * Gets the visit
     * @return visit
     */
    public List<Visit> getVisit() {
        return visit;
    }

    /**
     * Sets the visit
     * @param visit
     */
    public void setVisit(List<Visit> visit) {
        this.visit = visit;
    }

    /**
     * Gets the case
     * @return case
     */
    public List<PetCase> getPetCase() {
        return petCase;
    }

    /**
     * Sets the case
     * @param petCase
     */
    public void setPetCase(List<PetCase> petCase) {
        this.petCase = petCase;
    }
}
