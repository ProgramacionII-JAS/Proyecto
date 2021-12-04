package co.edu.unbosque.jpa.repositories;

import co.edu.unbosque.jpa.entities.UserApp;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

/**
 * @author Oscar Santiago Florez, Yilber Andrey Rojas, Ana Lucero Perez y Juan Sebastian vargas
 */
public class UserAppImpl implements UserAppRepository{

    private EntityManager entityManager;

    public UserAppImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * method to save UserApp
     * @param user
     * @return UserApp saved
     */
    @Override
    public Optional<UserApp> save(UserApp user) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(user);
            entityManager.getTransaction().commit();
            return Optional.of(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    /**
     * method to find UserApp
     * @return UserApp list
     */
    @Override
    public List<UserApp> findAll() {
        return entityManager.createQuery("from UserApp ").getResultList();
    }

    /**
     * method to update user
     * @param email
     * @param username
     * @return modified user
     */
    @Override
    public Optional<UserApp> updateUser(String email, String username) {
        UserApp user = (UserApp) entityManager.createQuery("UPDATE UserApp u  SET u.email = : email WHERE u.username = :username")
                .setParameter("email", email).setParameter("username", username).getSingleResult();
        return user != null ? Optional.of(user) : Optional.empty();
    }

    /**
     * Method to find UserApp by userName
     * @param username
     * @return UserApp list
     */
    @Override
    public Optional<UserApp> findByUsername(String username) {
        UserApp userApp = entityManager.find(UserApp.class,username);
        return userApp!=null ? Optional.of(userApp) : Optional.empty();
    }
}
