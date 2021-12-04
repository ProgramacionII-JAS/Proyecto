package co.edu.unbosque.jpa.repositories;

import co.edu.unbosque.jpa.entities.Owner;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

/**
 * @author Oscar Santiago Florez, Yilber Andrey Rojas, Ana Lucero Perez y Juan Sebastian vargas
 */
public class OwnerImpl implements OwnerRepository {

    private EntityManager entityManager;

    public OwnerImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Create an Owner that receives a ow as a parameter
     * @param ow
     * @return Owner created
     */
    @Override
    public Optional<Owner> create(Owner ow) {
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(ow);
            entityManager.getTransaction().commit();
            return Optional.of(ow);
        }catch(Exception e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    /**
     * Method to find all
     * @return Owner list
     */
    @Override
    public List<Owner> findAll() {
        return entityManager.createQuery("from Owner").getResultList();
    }

    /**
     * method to find owner by ownerId
     * @param ownerId
     * @return Owner list
     */
    @Override
    public Optional<Owner> findByOwnerId(String ownerId) {
        Owner ow = entityManager.createQuery("SELECT o FROM Owner o WHERE o.username = :ownerId", Owner.class)
                .setParameter("ownerId", ownerId).getSingleResult();
        return ow != null ? Optional.of(ow) : Optional.empty();
    }

    /**
     * method to update name
     * @param name
     * @param username
     * @return modified name
     */
    @Override
    public Optional<Owner> updateName(String name, String username) {
        try{
            entityManager.getTransaction().begin();
            Owner owner = entityManager.find(Owner.class, username);
            owner.setName(name);
            entityManager.getTransaction().commit();

            return Optional.of(owner);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    /**
     * Method to update email
     * @param email
     * @param username
     * @return modified email
     */
    @Override
    public Optional<Owner> updateEmail(String email, String username) {
        try{
            entityManager.getTransaction().begin();
            Owner owner = entityManager.find(Owner.class, username);
            owner.setEmail(email);
            entityManager.getTransaction().commit();

            return Optional.of(owner);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    /**
     * Method to update password
     * @param newPassword
     * @param userName
     * @return modified password
     */
    @Override
    public Optional<Owner> updatePassword(String newPassword, String userName) {
        try{
            entityManager.getTransaction().begin();
            Owner owner = entityManager.find(Owner.class, userName);
            owner.setPassword(newPassword);
            entityManager.getTransaction().commit();
            return Optional.of(owner);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    /**
     * Method to update email and password
     * @param newPassword
     * @param newEmail
     * @param userName
     * @return modified email and password
     */
    @Override
    public Optional<Owner> updatePasswordEmail(String newPassword, String newEmail, String userName) {
        try{
            entityManager.getTransaction().begin();
            Owner owner = entityManager.find(Owner.class, userName);
            owner.setPassword(newPassword);
            owner.setEmail(newEmail);
            entityManager.getTransaction().commit();
            return Optional.of(owner);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    /**
     * Method to update address and neighborhood
     * @param address
     * @param neighborhood
     * @param username
     * @return modified address and neighborhood
     */
    @Override
    public Optional<Owner> updateAddressAndNeighborhood(String address, String neighborhood, String username) {
        try{
            entityManager.getTransaction().begin();
            Owner owner = entityManager.find(Owner.class, username);
            owner.setAddress(address);
            owner.setNeighborhood(neighborhood);
            entityManager.getTransaction().commit();
            return Optional.of(owner);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    /**
     * Method to update address
     * @param address
     * @param username
     * @return modified address
     */
    @Override
    public Optional<Owner> updateAddress(String address, String username) {
        try{
            entityManager.getTransaction().begin();
            Owner owner = entityManager.find(Owner.class, username);
            owner.setAddress(address);
            entityManager.getTransaction().commit();

            return Optional.of(owner);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    /**
     * Method to update neighborhood
     * @param neighborhood
     * @param username
     * @return modified neighborhood
     */
    @Override
    public Optional<Owner> updateNeighborhood(String neighborhood, String username) {
        try{
            entityManager.getTransaction().begin();
            Owner owner = entityManager.find(Owner.class, username);
            owner.setNeighborhood(neighborhood);
            entityManager.getTransaction().commit();

            return Optional.of(owner);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
