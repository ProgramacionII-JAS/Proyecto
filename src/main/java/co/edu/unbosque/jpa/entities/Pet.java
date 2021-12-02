package co.edu.unbosque.jpa.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Pet representa las entities, las relaciones que tendrá la tabla Pet, con las demás.
 * @author Oscar Santiago Florez, Yilber Andrey Rojas, Ana Lucero Perez y Juan Sebastian vargas
 *
 */

@Entity
@Table(name = "Pet")
public class Pet implements Serializable{

    /**
     * Primary Key pet_id de la tabla Pet
     */
    @Id
    @Column(name = "pet_id")
    private Integer petId;

    /**
     * Columna microchip
     */
    @Column(name = "microchip")
    private String microChip;

    /**
     * Columna name
     */
    @Column(name = "name")
    private String name;

    /**
     * Columna species
     */
    @Column(name = "species")
    private String species;

    /**
     * Columna race
     */
    @Column(name = "race")
    private String race;

    /**
     * Columna size
     */
    @Column(name = "size")
    private String size;

    /**
     * Columna sex
     */
    @Column(name = "sex")
    private String sex;

    /**
     * Columna picture
     */
    @Column(name = "picture")
    private String picture;

    /**
     *
     */
    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "person_id")
    private Owner ownerId;

    /**
     *
     */
    @OneToMany(mappedBy = "pet_id",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Visit> visit = new ArrayList<>();

    /**
     *
     */
    @OneToMany(mappedBy = "pet_id", cascade = CascadeType.MERGE)
    private List<PetCase> petCase = new ArrayList<>();

    /**
     * Crea un Pet recibiendo como parámetros, el petId, el microchip, el name, la specie, la raza, el size, el sex y la picture.
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
     *
     * @param petcases
     */
    public void addPetCase(PetCase petcases) {
        petCase.add(petcases);
        petcases.setPetId(this);
    }

    /**
     *
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
