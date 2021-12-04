package co.edu.unbosque.jpa.repositories;

import co.edu.unbosque.jpa.entities.Pet;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

/**
 * @author Oscar Santiago Florez, Yilber Andrey Rojas, Ana Lucero Perez y Juan Sebastian vargas
 */
public class PetImpl implements PetRepository {

    private final EntityManager entityManager;

    public PetImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * method to save pet
     * @param pet
     * @return pet saved
     */
    @Override
    public Optional<Pet> save(Pet pet) {
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(pet);
            entityManager.getTransaction().commit();
            return Optional.of(pet);
        }catch(Exception e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    /**
     * method to find pet
     * @return pet list
     */
    @Override
    public List<Pet> findAll() {
        return entityManager.createQuery("from Pet").getResultList();
    }

    /**
     * method to find pet by Id
     * @param id
     * @return pet list
     */
    @Override
    public Optional<Pet> findId(Integer id) {
        Pet pet = entityManager.createQuery("SELECT o FROM Pet o WHERE o.petId = :id", Pet.class)
                .setParameter("id", id).getSingleResult();
        return pet != null ? Optional.of(pet) : Optional.empty();
    }

    /**
     * v
     * @param ownerId
     * @return pet list
     */
    @Override
    public Optional<Pet> findOwnerId(String ownerId) {
        Pet pet = entityManager.createQuery("SELECT o FROM Pet o WHERE o.ownerId= :ownerId", Pet.class)
                .setParameter("ownerId", ownerId).getSingleResult();
        return pet != null ? Optional.of(pet) : Optional.empty();
    }

    /**
     * method to update name
     * @param name
     * @param petId
     * @return modified name
     */
    @Override
    public Optional<Pet> updateName(String name, Integer petId) {
        try{
            entityManager.getTransaction().begin();
            Pet pet = entityManager.find(Pet.class, petId);
            pet.setName(name);
            entityManager.getTransaction().commit();

            return Optional.of(pet);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    /**
     * method to update species
     * @param species
     * @param petId
     * @return modified specie
     */
    @Override
    public Optional<Pet> updateSpecies(String species, Integer petId) {
        try{
            entityManager.getTransaction().begin();
            Pet pet = entityManager.find(Pet.class, petId);
            pet.setSpecies(species);
            entityManager.getTransaction().commit();

            return Optional.of(pet);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    /**
     * method to update race
     * @param race
     * @param petId
     * @return modified race
     */
    @Override
    public Optional<Pet> updateRace(String race, Integer petId) {
        try{
            entityManager.getTransaction().begin();
            Pet pet = entityManager.find(Pet.class, petId);
            pet.setRace(race);
            entityManager.getTransaction().commit();

            return Optional.of(pet);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    /**
     * method to update size
     * @param size
     * @param petId
     * @return modified size
     */
    @Override
    public Optional<Pet> updateSize(String size, Integer petId) {
        try{
            entityManager.getTransaction().begin();
            Pet pet = entityManager.find(Pet.class, petId);
            pet.setSize(size);
            entityManager.getTransaction().commit();

            return Optional.of(pet);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    /**
     * method to update sex
     * @param sex
     * @param petId
     * @return modified sex
     */
    @Override
    public Optional<Pet> updateSex(String sex, Integer petId) {
        try{
            entityManager.getTransaction().begin();
            Pet pet = entityManager.find(Pet.class, petId);
            pet.setSex(sex);
            entityManager.getTransaction().commit();

            return Optional.of(pet);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    /**
     * method to update picture
     * @param picture
     * @param petId
     * @return modified picture
     */
    @Override
    public Optional<Pet> updatePicture(String picture, Integer petId) {
        try{
            entityManager.getTransaction().begin();
            Pet pet = entityManager.find(Pet.class, petId);
            pet.setPicture(picture);
            entityManager.getTransaction().commit();

            return Optional.of(pet);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    /**
     * method to update microchip
     * @param microchip
     * @param petId
     * @return modified microchip
     */
    @Override
    public Optional<Pet> updatePetMicrochip(String microchip, Integer petId) {
        try{
            entityManager.getTransaction().begin();
            Pet pet = entityManager.find(Pet.class, petId);
            pet.setMicroChip(microchip);
            entityManager.getTransaction().commit();

            return Optional.of(pet);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
