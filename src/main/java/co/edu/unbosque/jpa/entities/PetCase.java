package co.edu.unbosque.jpa.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * PetCase extends from Pet and represents the entities, the relationships that the PetCase table will have, with the others.
 * @author Oscar Santiago Florez, Yilber Andrey Rojas, Ana Lucero Perez y Juan Sebastian vargas
 */

@Entity
@Table(name = "PetCase")
public class PetCase implements Serializable{

    /**
     * Primary key case_id column of the petCase table
     */
    @Id
    @Column(name = "case_id")
    private Integer caseId;

    /**
     * Created_at column of the petCase table
     */
    @Column(name = "created_at")
    private String created_at;

    /**
     * Type column of the petCase table
     */
    @Column(name = "type")
    private String type;

    /**
     * Description column of the petCase table
     */
    @Column(name = "description")
    private String description;

    /**
     * Pet_id column of the petCase table pet_id reference
     */
    @ManyToOne
    @JoinColumn(name = "pet_id", referencedColumnName = "pet_id", unique = true)
    private Pet pet_id;

    /**
     * Create a petCase receiving as a parameter, the created_at, the type and the description.
     * @param created_at fecha de creación del caso
     * @param type tipo de caso
     * @param description descripcion del caso
     */
    public PetCase(String created_at, String type, String description) {
        this.created_at = created_at;
        this.type = type;
        this.description = description;
    }

    /**
     * Create a petCase receiving as a parameter, the caseId, the created_at, the type and the description.
     * @param caseId id del caso
     * @param created_at fecha de creación del caso
     * @param type tipo de caso
     * @param description descripción del caso
     */
    public PetCase(Integer caseId, String created_at, String type, String description) {
        this.caseId = caseId;
        this.created_at = created_at;
        this.type = type;
        this.description = description;
    }

    public PetCase() {}

    /**
     * Gets the caseId
     * @return caseId
     */
    public Integer getCaseId() {
        return caseId;
    }

    /**
     * Sets the caseId
     * @param caseId
     */
    public void setCaseId(Integer caseId) {
        this.caseId = caseId;
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
     * @return typd
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

    /**
     * Gets the pet_id
     * @return pet_id
     */
    public Pet getPetId() {
        return pet_id;
    }

    /**
     * Sets the pet_id
     * @param petId
     */
    public void setPetId(Pet petId) {
        this.pet_id = petId;
    }
}
