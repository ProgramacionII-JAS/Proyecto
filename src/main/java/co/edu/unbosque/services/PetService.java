package co.edu.unbosque.services;

import co.edu.unbosque.jpa.entities.Owner;
import co.edu.unbosque.jpa.entities.Pet;
import co.edu.unbosque.jpa.repositories.OwnerImpl;
import co.edu.unbosque.jpa.repositories.OwnerRepository;
import co.edu.unbosque.jpa.repositories.PetImpl;
import co.edu.unbosque.jpa.repositories.PetRepository;
import co.edu.unbosque.resource.pojo.PetPOJO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Oscar Santiago Florez, Yilber Andrey Rojas, Ana Lucero Perez y Juan Sebastian vargas
 */
@Stateless
public class PetService {

    PetRepository petRepository;
    OwnerRepository ownerRepository;

    /**
     * save pet receiving as a parameter the petId, the microchip, the name, the species, the race, the size, the sex, the picture and ownerId.
     * @param petId
     * @param microchip
     * @param name
     * @param species
     * @param race
     * @param size
     * @param sex
     * @param picture
     * @param ownerId
     * @return pet created
     */
    public PetPOJO createdPet(Integer petId, String microchip, String name, String species, String race, String size, String sex, String picture, Integer ownerId){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("proyecto");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        petRepository = new PetImpl(entityManager);
        ownerRepository = new OwnerImpl(entityManager);
        Optional<Owner> owner = Optional.of(ownerRepository.findAll().get(ownerId-1));
        owner.ifPresent(o->{
            o.addPet(new Pet(petId, microchip, name,species, race,size,sex, picture));
            ownerRepository.create(o);
        });

        entityManager.close();
        entityManagerFactory.close();

        PetPOJO petPOJO = new PetPOJO(petId,microchip,name,species,race,size,sex,picture,ownerId);
        return petPOJO;

    }

    /**
     * method to find pet
     * @return pet list
     */
    public List<PetPOJO> findAll(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("proyecto");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        petRepository = new PetImpl(entityManager);
        List<Pet> pets = petRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();

        List<PetPOJO> petPOJOS = new ArrayList<>();
        for (Pet pet: pets){
            petPOJOS.add(new PetPOJO(
                    pet.getPetId(),pet.getMicroChip(),pet.getName(),pet.getSpecies(), pet.getRace(), pet.getSize(),
                    pet.getSex(),pet.getPicture(), pet.getOwner().getPersonId()
            ));
        }

        return petPOJOS;
    }

    /**
     * method to find pet by petId
     * @param petId
     * @return pet list
     */
    public Pet findPetId(Integer petId){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("proyecto");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        petRepository = new PetImpl(entityManager);
        Pet persistedPet = petRepository.findId(petId).get();

        entityManager.close();
        entityManagerFactory.close();

        return persistedPet;
    }

    /**
     * method to modify the name from the pet
     * @param newName
     * @param petId
     * @return name modified
     */
    public PetPOJO updateName(String newName, Integer petId){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("proyecto");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        petRepository = new PetImpl(entityManager);
        petRepository.updateName(newName, petId);

        entityManager.close();
        entityManagerFactory.close();

        Pet pet = findPetId(petId);
        PetPOJO petPOJO = new PetPOJO(pet.getPetId(),
                pet.getMicroChip(), pet.getName(), pet.getSpecies(),
                pet.getRace(), pet.getSize(), pet.getSex(), pet.getPicture(), petId);

        return petPOJO;
    }

    /**
     * method to modify the species from the pet
     * @param newSpecies
     * @param petId
     * @return specie modified
     */
    public PetPOJO updateSpecies(String newSpecies, Integer petId){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("proyecto");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        petRepository = new PetImpl(entityManager);
        petRepository.updateSpecies(newSpecies, petId);

        entityManager.close();
        entityManagerFactory.close();

        Pet pet = findPetId(petId);
        PetPOJO petPOJO = new PetPOJO(pet.getPetId(),
                pet.getMicroChip(), pet.getName(), pet.getSpecies(),
                pet.getRace(), pet.getSize(), pet.getSex(), pet.getPicture(), petId);

        return petPOJO;
    }

    /**
     * method to modify the race from the pet
     * @param newRace
     * @param petId
     * @return race modified
     */
    public PetPOJO updateRace(String newRace, Integer petId){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("proyecto");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        petRepository = new PetImpl(entityManager);
        petRepository.updateRace(newRace, petId);

        entityManager.close();
        entityManagerFactory.close();

        Pet pet = findPetId(petId);
        PetPOJO petPOJO = new PetPOJO(pet.getPetId(),
                pet.getMicroChip(), pet.getName(), pet.getSpecies(),
                pet.getRace(), pet.getSize(), pet.getSex(), pet.getPicture(), petId);

        return petPOJO;
    }

    /**
     * method to modify the size from the pet
     * @param newSize
     * @param petId
     * @return size modified
     */
    public PetPOJO updateSize(String newSize, Integer petId){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("proyecto");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        petRepository = new PetImpl(entityManager);
        petRepository.updateSize(newSize, petId);

        entityManager.close();
        entityManagerFactory.close();

        Pet pet = findPetId(petId);
        PetPOJO petPOJO = new PetPOJO(pet.getPetId(),
                pet.getMicroChip(), pet.getName(), pet.getSpecies(),
                pet.getRace(), pet.getSize(), pet.getSex(), pet.getPicture(), petId);

        return petPOJO;
    }

    /**
     * method to modify the sex from the pet
     * @param newSex
     * @param petId
     * @return sex modified
     */
    public PetPOJO updateSex(String newSex, Integer petId){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("proyecto");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        petRepository = new PetImpl(entityManager);
        petRepository.updateSex(newSex, petId);

        entityManager.close();
        entityManagerFactory.close();

        Pet pet = findPetId(petId);
        PetPOJO petPOJO = new PetPOJO(pet.getPetId(),
                pet.getMicroChip(), pet.getName(), pet.getSpecies(),
                pet.getRace(), pet.getSize(), pet.getSex(), pet.getPicture(), petId);

        return petPOJO;
    }

    /**
     * method to modify the picture from the pet
     * @param newPicture
     * @param petId
     * @return picture modified
     */
    public PetPOJO updatePicture(String newPicture, Integer petId){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("proyecto");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        petRepository = new PetImpl(entityManager);
        petRepository.updatePicture(newPicture, petId);


        entityManager.close();
        entityManagerFactory.close();

        Pet pet = findPetId(petId);
        PetPOJO petPOJO = new PetPOJO(pet.getPetId(),
                pet.getMicroChip(), pet.getName(), pet.getSpecies(),
                pet.getRace(), pet.getSize(), pet.getSex(), pet.getPicture(), petId);

        return petPOJO;
    }

    /**
     * method to modify the microchip from the pet
     * @param newMicrochip
     * @param petId
     * @return microchip modified
     */
    public PetPOJO updateMicrochip(String newMicrochip, Integer petId){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("proyecto");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        petRepository = new PetImpl(entityManager);
        petRepository.updatePetMicrochip(newMicrochip, petId);


        entityManager.close();
        entityManagerFactory.close();

        Pet pet = findPetId(petId);
        PetPOJO petPOJO = new PetPOJO(pet.getPetId(),
                pet.getMicroChip(), pet.getName(), pet.getSpecies(),
                pet.getRace(), pet.getSize(), pet.getSex(), pet.getPicture(), petId);

        return petPOJO;
    }
}
