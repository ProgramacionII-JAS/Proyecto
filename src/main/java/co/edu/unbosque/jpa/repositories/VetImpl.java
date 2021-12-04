package co.edu.unbosque.jpa.repositories;

import co.edu.unbosque.jpa.entities.Vet;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

/**
 * @author Oscar Santiago Florez, Yilber Andrey Rojas, Ana Lucero Perez y Juan Sebastian vargas
 */
public class VetImpl implements VetRepository{

    private EntityManager entityManager;

    public VetImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * method to save Vet
     * @param vet
     * @return vet saved
     */
    @Override
    public Optional<Vet> save(Vet vet) {
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(vet);
            entityManager.getTransaction().commit();
            return Optional.of(vet);
        }catch(Exception e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    /**
     * method to find Vet
     * @return Vet list
     */
    @Override
    public List<Vet> findAll() {
        return entityManager.createQuery("from Vet ").getResultList();
    }

    /**
     * method to find Vet by vetId
     * @param vetId
     * @return Vet list
     */
    @Override
    public Optional<Vet> findByVetId(Integer vetId) {
        Vet pet = entityManager.createQuery("SELECT o FROM Vet o WHERE o.username = :vetId", Vet.class)
                .setParameter("vetId", vetId).getSingleResult();
        return pet != null ? Optional.of(pet) : Optional.empty();
    }

    /**
     * method to find Vet username
     * @param name
     * @return Vet list
     */
    @Override
    public Optional<Vet> findByUsername(String name) {
        Vet pet = entityManager.createQuery("SELECT o FROM Vet o WHERE o.username = :name", Vet.class)
                .setParameter("name", name).getSingleResult();
        return pet != null ? Optional.of(pet) : Optional.empty();
    }

    /**
     * method to update name of vet
     * @param name
     * @param username
     * @return modified name
     */
    @Override
    public Optional<Vet> updateName(String name, String username) {
        try{
            entityManager.getTransaction().begin();
            Vet vet = entityManager.find(Vet.class, username);
            vet.setName(name);
            entityManager.getTransaction().commit();

            return Optional.of(vet);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    /**
     * method to update address of Vet
     * @param address
     * @param username
     * @return modified address
     */
    @Override
    public Optional<Vet> updateAddress(String address, String username) {
        try{
            entityManager.getTransaction().begin();
            Vet vet = entityManager.find(Vet.class, username);
            vet.setAddress(address);
            entityManager.getTransaction().commit();

            return Optional.of(vet);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    /**
     * method to update neighborhood of Vet
     * @param neighborhood
     * @param username
     * @return modified neighborhood
     */
    @Override
    public Optional<Vet> updateNeighborhood(String neighborhood, String username) {
        try{
            entityManager.getTransaction().begin();
            Vet vet = entityManager.find(Vet.class, username);
            vet.setNeighborhood(neighborhood);
            entityManager.getTransaction().commit();

            return Optional.of(vet);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    /**
     * method to update address and neighborhood
     * @param address
     * @param neighborhood
     * @param username
     * @return modified address and neighborhood
     */
    @Override
    public Optional<Vet> updateAddressAndNeighborhood(String address, String neighborhood, String username) {
        try{
            entityManager.getTransaction().begin();
            Vet vet = entityManager.find(Vet.class, username);
            vet.setAddress(address);
            vet.setNeighborhood(neighborhood);
            entityManager.getTransaction().commit();
            return Optional.of(vet);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    /**
     * method to update email
     * @param email
     * @param username
     * @return modified email
     */
    @Override
    public Optional<Vet> updateEmail(String email, String username) {
        try{
            entityManager.getTransaction().begin();
            Vet vet = entityManager.find(Vet.class, username);
            vet.setEmail(email);
            entityManager.getTransaction().commit();
            return Optional.of(vet);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    /**
     * method to update password
     * @param newPassword
     * @param userName
     * @return modified password
     */
    @Override
    public Optional<Vet> updatePassword(String newPassword, String userName) {
        try{
            entityManager.getTransaction().begin();
            Vet vet = entityManager.find(Vet.class, userName);
            vet.setPassword(newPassword);
            entityManager.getTransaction().commit();
            return Optional.of(vet);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    /**
     * method to update email and password
     * @param newPassword
     * @param newEmail
     * @param userName
     * @return modified email and password
     */
    @Override
    public Optional<Vet> updatePasswordEmail(String newPassword, String newEmail, String userName) {
        try{
            entityManager.getTransaction().begin();
            Vet vet = entityManager.find(Vet.class, userName);
            vet.setPassword(newPassword);
            vet.setEmail(newEmail);
            entityManager.getTransaction().commit();
            return Optional.of(vet);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
