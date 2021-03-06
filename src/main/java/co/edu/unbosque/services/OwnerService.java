package co.edu.unbosque.services;

import co.edu.unbosque.jpa.entities.Owner;
import co.edu.unbosque.jpa.entities.Pet;
import co.edu.unbosque.jpa.repositories.OwnerImpl;
import co.edu.unbosque.jpa.repositories.OwnerRepository;
import co.edu.unbosque.jpa.repositories.PetImpl;
import co.edu.unbosque.resource.pojo.OwnerPOJO;
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
public class OwnerService {

    OwnerRepository ownerRepository;

    /**
     * Create an Owner receiving as a parameter the ownerPOJO.
     * @param ownerPOJO
     * @return owner created
     */
    public Optional<OwnerPOJO> createOwner(OwnerPOJO ownerPOJO){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("proyecto");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        ownerRepository = new OwnerImpl(entityManager);
        Owner owner = new Owner(ownerPOJO.getUsername(), ownerPOJO.getPassword(), ownerPOJO.getEmail(),
                ownerPOJO.getPersonId(), ownerPOJO.getName(), ownerPOJO.getAddress(), ownerPOJO.getNeighborhood());
        Optional<Owner> persistedOwner = ownerRepository.create(owner);

        entityManager.close();
        entityManagerFactory.close();

        if (persistedOwner.isPresent()) {
            return Optional.of(new OwnerPOJO(persistedOwner.get().getUsername(),
                    persistedOwner.get().getPassword(),
                    persistedOwner.get().getEmail(),
                    persistedOwner.get().getPersonId(),
                    persistedOwner.get().getName(),
                    persistedOwner.get().getAddress(),
                    persistedOwner.get().getNeighborhood()));
        } else {
            return Optional.empty();
        }
    }

    /**
     * method to find owner by username
     * @param username
     * @return owner list
     */
    public Owner findUsername(String username){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("proyecto");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        ownerRepository = new OwnerImpl(entityManager);
        Owner persistedOwner = ownerRepository.findByOwnerId(username).get();

        entityManager.close();
        entityManagerFactory.close();

        return persistedOwner;
    }

    /**
     * method to modify the name from the owner
     * @param newName
     * @param username
     * @return name modified
     */
    public OwnerPOJO updateName(String newName, String username){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("proyecto");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        ownerRepository = new OwnerImpl(entityManager);
        ownerRepository.updateName(newName, username);

        entityManager.close();
        entityManagerFactory.close();

        Owner owner = findUsername(username);
        OwnerPOJO ownerPOJO = new OwnerPOJO(owner.getUsername(),
                owner.getPassword(),
                owner.getEmail(),
                owner.getPersonId(),
                owner.getName(),
                owner.getAddress(),
                owner.getNeighborhood());

        return ownerPOJO;
    }

    /**
     * method to modify the email from the owner
     * @param newEmail
     * @param username
     * @return email modified
     */
    public OwnerPOJO updateEmail(String newEmail, String username){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("proyecto");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        ownerRepository = new OwnerImpl(entityManager);
        ownerRepository.updateEmail(newEmail, username);

        entityManager.close();
        entityManagerFactory.close();

        Owner owner = findUsername(username);
        OwnerPOJO ownerPOJO = new OwnerPOJO(owner.getUsername(),
                owner.getPassword(),
                owner.getEmail(),
                owner.getPersonId(),
                owner.getName(),
                owner.getAddress(),
                owner.getNeighborhood());

        return ownerPOJO;
    }

    /**
     * method to modify the address from the owner
     * @param newAddress
     * @param username
     * @return address modified
     */
    public OwnerPOJO updateAddress(String newAddress, String username){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("proyecto");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        ownerRepository = new OwnerImpl(entityManager);
        ownerRepository.updateAddress(newAddress, username);

        entityManager.close();
        entityManagerFactory.close();

        Owner owner = findUsername(username);
        OwnerPOJO ownerPOJO = new OwnerPOJO(owner.getUsername(),
                owner.getPassword(),
                owner.getEmail(),
                owner.getPersonId(),
                owner.getName(),
                owner.getAddress(),
                owner.getNeighborhood());
        return ownerPOJO;
    }

    /**
     * method to modify the neighborhood from the owner
     * @param newNeighbohood
     * @param username
     * @return neighborhood modified
     */
    public OwnerPOJO updateNeighborhood(String newNeighbohood, String username){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("proyecto");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        ownerRepository = new OwnerImpl(entityManager);
        ownerRepository.updateNeighborhood(newNeighbohood, username);

        entityManager.close();
        entityManagerFactory.close();

        Owner owner = findUsername(username);
        OwnerPOJO ownerPOJO = new OwnerPOJO(owner.getUsername(),
                owner.getPassword(),
                owner.getEmail(),
                owner.getPersonId(),
                owner.getName(),
                owner.getAddress(),
                owner.getNeighborhood());
        return ownerPOJO;
    }

    /**
     * method to modify the password from the owner
     * @param newPassword
     * @param userName
     * @return password modified
     */
    public OwnerPOJO updatePassword(String newPassword, String userName){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("proyecto");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        ownerRepository = new OwnerImpl(entityManager);
        ownerRepository.updatePassword(newPassword, userName);

        entityManager.close();
        entityManagerFactory.close();

        Owner owner = findUsername(userName);
        OwnerPOJO ownerPOJO = new OwnerPOJO(owner.getUsername(),
                owner.getPassword(),
                owner.getEmail(),
                owner.getPersonId(),
                owner.getName(),
                owner.getAddress(),
                owner.getNeighborhood());
        return ownerPOJO;
    }

    /**
     * method to modify the address and email from the owner
     * @param newEmail
     * @param newPassword
     * @param userName
     * @return address and email modified
     */
    public OwnerPOJO updateEmailPassword(String newEmail, String newPassword, String userName){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("proyecto");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        ownerRepository = new OwnerImpl(entityManager);
        ownerRepository.updatePasswordEmail(newPassword, newEmail, userName);

        entityManager.close();
        entityManagerFactory.close();

        Owner owner = findUsername(userName);
        OwnerPOJO ownerPOJO = new OwnerPOJO(owner.getUsername(),
                owner.getPassword(),
                owner.getEmail(),
                owner.getPersonId(),
                owner.getName(),
                owner.getAddress(),
                owner.getNeighborhood());
        return ownerPOJO;
    }

    /**
     * method to modify the address and neighborhood from the owner
     * @param address
     * @param neighborhood
     * @param username
     * @return address and neighborhood modified
     */
    public OwnerPOJO updateAddressNeighnorhood(String address, String neighborhood, String username){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("proyecto");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        ownerRepository = new OwnerImpl(entityManager);
        ownerRepository.updateAddressAndNeighborhood(address,neighborhood,username);

        entityManager.close();
        entityManagerFactory.close();

        Owner owner = findUsername(username);
        OwnerPOJO ownerPOJO = new OwnerPOJO(owner.getUsername(),
                owner.getPassword(),
                owner.getEmail(),
                owner.getPersonId(),
                owner.getName(),
                owner.getAddress(),
                owner.getNeighborhood());
        return ownerPOJO;
    }
}