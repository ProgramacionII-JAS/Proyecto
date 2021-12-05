package co.edu.unbosque.services;

import co.edu.unbosque.jpa.entities.Vet;
import co.edu.unbosque.jpa.repositories.VetImpl;
import co.edu.unbosque.jpa.repositories.VetRepository;
import co.edu.unbosque.resource.pojo.VetPOJO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Optional;

/**
 * @author Oscar Santiago Florez, Yilber Andrey Rojas, Ana Lucero Perez y Juan Sebastian vargas
 */
@Stateless
public class VetService {

    VetRepository vetRepository;

    /**
     * save vet receiving as a parameter the vetPOJO
     * @param vetPOJO
     * @return vet created
     */
    public Optional<VetPOJO> createVet(VetPOJO vetPOJO) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("proyecto");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        vetRepository = new VetImpl(entityManager);

        Vet vet = new Vet(vetPOJO.getUsername(), vetPOJO.getPassword(), vetPOJO.getEmail(), vetPOJO.getName(), vetPOJO.getAddress(),vetPOJO.getNeighborhood());
        Optional<Vet> persistedVet = vetRepository.save(vet);

        entityManager.close();
        entityManagerFactory.close();

        if (persistedVet.isPresent()) {
            return Optional.of(new VetPOJO(persistedVet.get().getUsername(),
                    persistedVet.get().getPassword(),
                    persistedVet.get().getEmail(),
                    persistedVet.get().getName() ,persistedVet.get().getAddress(),
                    persistedVet.get().getNeighborhood()));
        } else {
            return Optional.empty();
        }
    }

    /**
     * method to find vet by username
     * @param username
     * @return vet list
     */
    public Vet findUsername(String username){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("proyecto");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        vetRepository = new VetImpl(entityManager);
        Vet persistedVet = vetRepository.findByUsername(username).get();

        entityManager.close();
        entityManagerFactory.close();

        return persistedVet;
    }

    /**
     * method to modify the name from the vet
     * @param newName
     * @param username
     * @return name modified
     */
    public VetPOJO updateName(String newName, String username){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("proyecto");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        vetRepository = new VetImpl(entityManager);
        vetRepository.updateName(newName, username);

        entityManager.close();
        entityManagerFactory.close();

        Vet vet = findUsername(username);
        VetPOJO vetPOJO = new VetPOJO(vet.getUsername(),
                vet.getPassword(),
                vet.getEmail(),
                vet.getName(),
                vet.getAddress(),
                vet.getNeighborhood());

        return vetPOJO;
    }

    /**
     * method to modify the address from the vet
     * @param newAddress
     * @param username
     * @return address modified
     */
    public VetPOJO updateAddress(String newAddress, String username){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("proyecto");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        vetRepository = new VetImpl(entityManager);
        vetRepository.updateAddress(newAddress, username);

        entityManager.close();
        entityManagerFactory.close();

        Vet vet = findUsername(username);
        VetPOJO vetPOJO = new VetPOJO(vet.getUsername(),
                vet.getPassword(),
                vet.getEmail(),
                vet.getName(),
                vet.getAddress(),
                vet.getNeighborhood());

        return vetPOJO;
    }

    /**
     * method to modify the neighborhood from the vet
     * @param newNeigborhood
     * @param username
     * @return neighborhood modified
     */
    public VetPOJO updateNeighborhood(String newNeigborhood, String username){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("proyecto");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        vetRepository = new VetImpl(entityManager);
        vetRepository.updateNeighborhood(newNeigborhood, username);

        entityManager.close();
        entityManagerFactory.close();

        Vet vet = findUsername(username);
        VetPOJO vetPOJO = new VetPOJO(vet.getUsername(),
                vet.getPassword(),
                vet.getEmail(),
                vet.getName(),
                vet.getAddress(),
                vet.getNeighborhood());

        return vetPOJO;
    }

    /**
     * method to modify the address and neighborhood from the vet
     * @param address
     * @param neighborhood
     * @param username
     * @return address and neighborhood modified
     */
    public VetPOJO updateAddressAndNeighborhood(String address, String neighborhood, String username){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("proyecto");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        vetRepository = new VetImpl(entityManager);
        vetRepository.updateAddressAndNeighborhood(address,neighborhood,username);

        entityManager.close();
        entityManagerFactory.close();

        Vet vet = findUsername(username);
        VetPOJO vetPOJO = new VetPOJO(vet.getUsername(),
                vet.getPassword(),
                vet.getEmail(),
                vet.getName(),
                vet.getAddress(),
                vet.getNeighborhood());

        return vetPOJO;
    }

    /**
     * method to modify the email from the vet
     * @param email
     * @param username
     * @return email modified
     */
    public VetPOJO updateEmail(String email, String username){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("proyecto");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        vetRepository = new VetImpl(entityManager);
        vetRepository.updateEmail(email,username);

        entityManager.close();
        entityManagerFactory.close();

        Vet vet = findUsername(username);
        VetPOJO vetPOJO = new VetPOJO(vet.getUsername(),
                vet.getPassword(),
                vet.getEmail(),
                vet.getName(),
                vet.getAddress(),
                vet.getNeighborhood());

        return vetPOJO;
    }

    /**
     * method to modify the password from the vet
     * @param password
     * @param username
     * @return password modified
     */
    public VetPOJO updatePassword(String password, String username){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("proyecto");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        vetRepository = new VetImpl(entityManager);
        vetRepository.updatePassword(password,username);

        entityManager.close();
        entityManagerFactory.close();

        Vet vet = findUsername(username);
        VetPOJO vetPOJO = new VetPOJO(vet.getUsername(),
                vet.getPassword(),
                vet.getEmail(),
                vet.getName(),
                vet.getAddress(),
                vet.getNeighborhood());

        return vetPOJO;
    }

    /**
     * method to modify the email and password from the vet
     * @param password
     * @param email
     * @param username
     * @return email and password modified
     */
    public VetPOJO updateEmailAndPassword(String password, String email, String username){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("proyecto");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        vetRepository = new VetImpl(entityManager);
        vetRepository.updatePasswordEmail(password,email,username);

        entityManager.close();
        entityManagerFactory.close();

        Vet vet = findUsername(username);
        VetPOJO vetPOJO = new VetPOJO(vet.getUsername(),
                vet.getPassword(),
                vet.getEmail(),
                vet.getName(),
                vet.getAddress(),
                vet.getNeighborhood());

        return vetPOJO;
    }
}
