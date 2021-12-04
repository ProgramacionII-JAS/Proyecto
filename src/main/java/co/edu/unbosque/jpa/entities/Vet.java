package co.edu.unbosque.jpa.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Vet extends from UserApp and represents the entities, the relationships that the Vet table will have, with the others.
 * @author Oscar Santiago Florez, Yilber Andrey Rojas, Ana Lucero Perez y Juan Sebastian vargas
 */

@Entity
@Table(name = "Vet")
@PrimaryKeyJoinColumn
public class Vet extends UserApp implements Serializable {

    /**
     * Name column of the Vet table
     */
    @Column(name = "name")
    private String name;

    /**
     * Address column of the Vet table
     */
    @Column(name = "address")
    private String address;

    /**
     * Neighborhood column of the Vet table
     */
    @Column(name = "neighborhood")
    private String neighborhood;

    /**
     * One to many relationship referencing the vet_id
     */
    @OneToMany(mappedBy = "vet_id", cascade = CascadeType.ALL)
    private List<Visit> visits;

    /**
     * Create a Vet receiving as a parameter, the username, the password, the email, the name, the address and the neighborhood.
     * @param username
     * @param password
     * @param email
     * @param name
     * @param address
     * @param neighborhood
     */
    public Vet(String username, String password, String email, String name, String address, String neighborhood) {
        super(username, password, email, "VET");
        this.name = name;
        this.address = address;
        this.neighborhood = neighborhood;
    }

    public Vet() {}

    /**
     * Add a visit receiving a visit as a parameter
     * @param visit
     */
    public void addVisit(Visit visit) {
        visits.add(visit);
        visit.setVet_id(this);
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
