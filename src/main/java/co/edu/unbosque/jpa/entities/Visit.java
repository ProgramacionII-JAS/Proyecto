package co.edu.unbosque.jpa.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Visit extends from Vet and represents the entities, the relationships that the Visit table will have, with the others.
 * @author Oscar Santiago Florez, Yilber Andrey Rojas, Ana Lucero Perez y Juan Sebastian vargas
 */

@Entity
@Table(name = "Visit")
public class Visit implements Serializable{

    /**
     * Primary key visit_id column of the Visit table
     */
    @Id
    @Column(name = "visit_id", nullable = false)
    private String visit_id;

    /**
     * Created_at column of the Visit table
     */
    @Column(name = "created_at")
    private String created_at;

    /**
     * Type column of the Visit table
     */
    @Column(name = "type")
    private String type;

    /**
     * Description column of the Visit table
     */
    @Column(name = "description")
    private String description;

    /**
     * Many to one relationship vet_id column of the Visit table
     */
    @ManyToOne
    @JoinColumn(name = "vet_id")
    private Vet vet_id;

    /**
     * Many to one relationship pet_id column of the Visit table
     */
    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet_id;

    /**
     * Create a Visit receiving as a parameter, the visit_id, the created_at, the type and the description.
     * @param visit_id id de la visita
     * @param created_at fecha de creación de la visita
     * @param type tipo de visita
     * @param description descripción de la visita
     */
    public Visit(String visit_id, String created_at, String type, String description) {
        this.visit_id = visit_id;
        this.created_at = created_at;
        this.type = type;
        this.description = description;
    }

    public Visit() {
    }

    /**
     * Gets the visit_id
     * @return visit_id
     */
    public String getVisit_id() {
        return visit_id;
    }

    /**
     * Sets the visit_id
     * @param visit_id
     */
    public void setVisit_id(String visit_id) {
        this.visit_id = visit_id;
    }

    /**
     * Gets the created_at
     * @return created_at
     */
    public String getCreated_at() {
        return created_at;
    }

    /**
     * Sets the created_at
     * @param created_at
     */
    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    /**
     * Gets the type
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets the vet_id
     * @return vet_id
     */
    public Vet getVet_id() {
        return vet_id;
    }

    /**
     * Sets the vet_id
     * @param vet_id
     */
    public void setVet_id(Vet vet_id) {
        this.vet_id = vet_id;
    }

    /**
     * Gets the pet_id
     * @return pet_id
     */
    public Pet getPet_id() {
        return pet_id;
    }

    /**
     * Sets the pet_id
     * @param pet_id
     */
    public void setPet_id(Pet pet_id) {
        this.pet_id = pet_id;
    }

    /**
     * Gets the description
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
