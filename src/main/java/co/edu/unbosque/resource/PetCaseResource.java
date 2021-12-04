package co.edu.unbosque.resource;

import co.edu.unbosque.resource.pojo.PetCasePOJO;
import co.edu.unbosque.services.PetCaseService;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

/**
 * @author Oscar Santiago Florez, Yilber Andrey Rojas, Ana Lucero Perez y Juan Sebastian vargas
 */
@Path("/petcase")
public class PetCaseResource {

    /**
     * create an petCase with the /petcase path and post method
     * @param petcasePOJO
     * @return petCase created
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(PetCasePOJO petcasePOJO){
        Optional<PetCasePOJO> persistedPetCase = Optional.of(new PetCaseService().save(
                petcasePOJO.getCaseId(), petcasePOJO.getCreatedAt(),
                petcasePOJO.getType(), petcasePOJO.getDescription(), petcasePOJO.getPetId()));

        if (persistedPetCase.isPresent()){
            return Response.status(Response.Status.CREATED)
                    .entity(persistedPetCase.get())
                    .build();
        }else {
            return Response.serverError()
                    .entity("No se pudo crear la mascota")
                    .build();
        }
    }
}
