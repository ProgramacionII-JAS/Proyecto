package co.edu.unbosque.jpa.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * UserApp represents the entities, the relationships that the UserApp table will have, with the others.
 * @author Oscar Santiago Florez, Yilber Andrey Rojas, Ana Lucero Perez y Juan Sebastian vargas
 */

@Entity
@Table(name = "UserApp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class UserApp implements Serializable {

    /**
     * Primary key username column of the UserApp table
     */
    @Id
    @Column(name = "username")
    private String username;

    /**
     * Password column of the UserApp table
     */
    @Column(name = "password")
    private String password;

    /**
     * Email column of the UserApp table
     */
    @Column(name = "email")
    private String email;

    /**
     * Role column of the UserApp table
     */
    @Column(name = "role")
    private String role;

    /**
     * Create a UserApp receiving as a parameter, the username, the password, the email and the role.
     * @param username nombre de usuario
     * @param password contraseña de usuario
     * @param email email de usuario
     * @param role rol de usuario
     */
    public UserApp(String username, String password, String email, String role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public UserApp() {
    }

    /**
     * Gets the username
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the password
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the email
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the role
     * @return role
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets the role
     * @param role
     */
    public void setRole(String role) {
        this.role = role;
    }
}
