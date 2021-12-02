package co.edu.unbosque.jpa.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Owner representa las entities, las relaciones que tendrá la tabla owner, con las demás.
 * @author Oscar Santiago Florez, Yilber Andrey Rojas, Ana Lucero Perez y Juan Sebastian vargas
 *
 */

@Entity
@Table(name = "Owner")
@PrimaryKeyJoinColumn
public class Owner extends UserApp implements Serializable {

    @Column(name = "person_id")
    private Integer personId;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "neighborhood")
    private String neighborhood;

    @OneToMany(mappedBy = "ownerId",cascade = CascadeType.ALL)
    private List<Pet> pets = new ArrayList<>();

    public Owner() {}

    /**
     * Crea un Owner recibiendo como parámetros, el username, el password, el email, el personId, el name, el address y el neighborhood.
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
     *
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
