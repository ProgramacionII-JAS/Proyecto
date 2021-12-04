package co.edu.unbosque.resource.gets;

import co.edu.unbosque.resource.pojo.VetPOJO;
import co.edu.unbosque.services.VetService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

/**
 * @author Oscar Santiago Florez, Yilber Andrey Rojas, Ana Lucero Perez y Juan Sebastian vargas
 */
@Path("updatesVetEP")
public class updateEmailPasswordVet {

    /**
     * email or password put method for the vet path to modify
     * @param update
     * @param vetPOJO
     * @return email or password sent by Json
     */
    @PUT
    @Path("/vet/{update1}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response modify(@PathParam("update1") String update, VetPOJO vetPOJO){
        Optional<VetPOJO> persistedVet = null;

        if (update.equals("password")){
            persistedVet = Optional.of(new VetService().updatePassword(vetPOJO.getPassword(), vetPOJO.getUsername()));
        }else if (update.equals("email")){
            persistedVet = Optional.of(new VetService().updateEmail(vetPOJO.getEmail(), vetPOJO.getUsername()));
        }else{
            persistedVet = null;
        }
        if (persistedVet.isPresent()){
            return Response.status(Response.Status.CREATED).build();
        }else{
            return Response.status(400).build();
        }
    }

    /**
     * address and neighborhood put method for the vet path to modify
     * @param update
     * @param update2
     * @param vetPOJO
     * @return address and neighborhood sent by Json
     */
    @PUT
    @Path("/vet/{update}/{update2}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response modify2( @PathParam("update") String update, @PathParam("update2") String update2, VetPOJO vetPOJO){
        Optional<VetPOJO> persistedVet = null;

        if (update.equals("address") && update2.equals("neighborhood")){
            persistedVet = Optional.of(new VetService().updateAddressAndNeighborhood(vetPOJO.getAddress(), vetPOJO.getNeighborhood(), vetPOJO.getUsername()));
        }else{
            persistedVet = null;
        }
        if (persistedVet.isPresent()){
            return Response.status(Response.Status.CREATED).build();
        }else{
            return Response.status(400).build();
        }
    }
}
