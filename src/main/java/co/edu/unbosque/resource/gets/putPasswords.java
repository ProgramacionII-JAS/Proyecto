package co.edu.unbosque.resource.gets;

import co.edu.unbosque.resource.pojo.OwnerPOJO;
import co.edu.unbosque.resource.pojo.VetPOJO;
import co.edu.unbosque.services.OwnerService;
import co.edu.unbosque.services.VetService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

/**
 * @author Oscar Santiago Florez, Yilber Andrey Rojas, Ana Lucero Perez y Juan Sebastian vargas
 */
@Path("/passwords")
public class putPasswords {

    /**
     * passwords put method for the owner path to modify
     * @param newPassword
     * @param ownerPOJO
     * @return new password sent by Json
     */
    @PUT
    @Path("/{owner}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response modify(@PathParam("owner") String newPassword, OwnerPOJO ownerPOJO){
        Optional<OwnerPOJO> persistedOwner = null;
        if (newPassword.equals("password")){
            persistedOwner = Optional.of(new OwnerService().updatePassword(ownerPOJO.getPassword(), ownerPOJO.getUsername()));
        }else{
            persistedOwner = null;
        }
        if (persistedOwner.isPresent()){
            return Response.status(Response.Status.CREATED).build();
        }else{
            return Response.status(400).build();
        }
    }

    /**
     * email, password, address or neighborhood put method for the owner path to modify
     * @param update1
     * @param update2
     * @param ownerPOJO
     * @return email, password, address or neighborhood sent by Json
     */
    @PUT
    @Path("/owner/{update1}/{update2}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response modidy( @PathParam("update1") String update1, @PathParam("update2") String update2, OwnerPOJO ownerPOJO){
        Optional<OwnerPOJO> persistedowner = null;

        if (update1.equals("email") && update2.equals("password")){
            persistedowner = Optional.of(new OwnerService().updateEmailPassword(ownerPOJO.getEmail(), ownerPOJO.getPassword(),ownerPOJO.getUsername()));
        }else if (update1.equals("address") && update2.equals("neighborhood")){
            persistedowner = Optional.of(new OwnerService().updateAddressNeighnorhood(ownerPOJO.getAddress(), ownerPOJO.getNeighborhood(), ownerPOJO.getUsername()));
        }else{
            return null;
        }
        if (persistedowner.isPresent()){
            return Response.status(Response.Status.CREATED).build();
        }else{
            return Response.status(400).build();
        }
    }

    /**
     * email and password put method for the vet path to modify
     * @param update1
     * @param update2
     * @param vetPOJO
     * @return email and password sent by Json
     */
    @PUT
    @Path("/vet/{update1}/{update2}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response modify(@PathParam("update1") String update1, @PathParam("update2") String update2, VetPOJO vetPOJO){
        Optional<VetPOJO> persistedVet = null;

        if (update1.equals("email") && update2.equals("password")){
            persistedVet = Optional.of(new VetService().updateEmailAndPassword(vetPOJO.getPassword(), vetPOJO.getEmail(), vetPOJO.getUsername()));
        }else{
            return null;
        }
        if (persistedVet.isPresent()){
            return Response.status(Response.Status.CREATED).build();
        }else{
            return Response.status(400).build();
        }
    }
}
