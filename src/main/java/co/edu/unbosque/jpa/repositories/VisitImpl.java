package co.edu.unbosque.jpa.repositories;

import co.edu.unbosque.jpa.entities.Pet;
import co.edu.unbosque.jpa.entities.Visit;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

/**
 * @author Oscar Santiago Florez, Yilber Andrey Rojas, Ana Lucero Perez y Juan Sebastian vargas
 */
public class VisitImpl implements VisitRepository{

    private EntityManager entityManager;

    public VisitImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * method to save Visit
     * @param visit
     * @return Visit saved
     */
    @Override
    public Optional<Visit> save(Visit visit) {
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(visit);
            entityManager.getTransaction().commit();
            return Optional.of(visit);
        }catch(Exception e){
            e.printStackTrace();
        }

        return Optional.empty();
    }

    /**
     * method to find Visit
     * @return Visit list
     */
    @Override
    public List<Visit> findAll() {
        return entityManager.createQuery("from Visit ").getResultList();
    }

    @Override
    public Optional<Pet> findPetId(Integer petId) {
        Pet pet = entityManager.createQuery("SELECT o FROM Pet o WHERE o.petId = :petId", Pet.class)
                .setParameter("petId", petId).getSingleResult();
        return pet != null ? Optional.of(pet) : Optional.empty();
    }

    /**
     * method to find Visit by petId
     * @param namePet
     * @return Visit list
     */
    @Override
    public List<Visit> findVisitPetId(String namePet) {
        return entityManager.createQuery("SELECT vi FROM Visit vi WHERE vi.pet_id.name = :namePet", Visit.class)
                .setParameter("namePet", namePet).getResultList();

    }
}
