package co.edu.unbosque.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Official representa las entities, las relaciones que tendrá la tabla oficial, con las demás.
 * @author Oscar Santiago Florez, Yilber Andrey Rojas, Ana Lucero Perez y Juan Sebastian vargas
 *
 */

@Entity
@Table(name = "Official")
@PrimaryKeyJoinColumn
public class Official extends UserApp implements Serializable{

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "person_id", unique = true)
    private Long personId;

    /**
     * Crea un Official recibiendo como parámetros, el username, el password, el email, el name y el personId.
     * @param username nombre de usuario
     * @param password contraseña de usuario
     * @param email correo de usuario
     * @param name nombre de ususario
     * @param personId id del usuario
     */

    public Official(String username, String password, String email, String name, Long personId) {
        super(username, password, email, "official");
        this.name = name;
        this.personId = personId;
    }



    public Official() {
    }

    /**
     * Gets the name
     * @return the  name
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
     * Gets the personId
     * @return personId
     */
    public Long getPersonId() {
        return personId;
    }

    /**
     * Sets the personId
     * @param personId
     */
    public void setPersonId(Long personId) {
        this.personId = personId;
    }
}
