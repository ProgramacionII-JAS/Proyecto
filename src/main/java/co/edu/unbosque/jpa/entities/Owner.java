package co.edu.unbosque.jpa.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Owner extends from userApp and represents the entities, the relationships that the Owner table will have, with the others.
 * @author Oscar Santiago Florez, Yilber Andrey Rojas, Ana Lucero Perez y Juan Sebastian vargas
 *
 */

@Entity
@Table(name = "Owner")
@PrimaryKeyJoinColumn
public class Owner extends UserApp implements Serializable {

    /**
     * Person_id column of the owner table
     */
    @Column(name = "person_id")
    private Integer personId;

    /**
     * Name column of the owner table
     */
    @Column(name = "name")
    private String name;

    /**
     * Address column of the owner table
     */
    @Column(name = "address")
    private String address;

    /**
     * Neighborhood column of the owner table
     */
    @Column(name = "neighborhood")
    private String neighborhood;

    /**
     * One to many relationship referencing the ownerId
     */
    @OneToMany(mappedBy = "ownerId",cascade = CascadeType.ALL)
    private List<Pet> pets = new ArrayList<>();

    public Owner() {}

    /**
     * Create an Owner receiving as a parameter, the username and password, the email, the personId, the name, the address and the neighborhood.
     * @param username nombre de usuario
     * @param password contraseña de usuario
     * @param email correo de usuario
     * @param personId id del propietario
     * @param name name del propietario
     * @param address dirección del propietario
     * @param neighborhood localidad del propietario
     */
    public Owner(String username, String password, String email, Integer personId, String name, String address, String neighborhood) {
        super(username, password, email, "owner");
        this.personId = personId;
        this.name = name;
        this.address = address;
        this.neighborhood = neighborhood;
    }

    /**
     * Add a pet receiving a pet as a parameter
     * @param pet
     */
    public void addPet(Pet pet) {
        pets.add(pet);
        pet.setOwner(this);
    }

    /**
     * Gets the personId
     * @return personId
     */
    public Integer getPersonId() {
        return personId;
    }

    /**
     * Sets the personId
     * @param personId
     */
    public void setPersonId(Integer personId) {
        this.personId = personId;
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
     * Gets the address
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets the neighborhood
     * @return neighborhood
     */
    public String getNeighborhood() {
        return neighborhood;
    }

    /**
     * Sets the neighborhood
     * @param neighborhood
     */
    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }
}
