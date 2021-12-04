package co.edu.unbosque.resource;

import co.edu.unbosque.resource.pojo.OfficialPOJO;
import co.edu.unbosque.services.OfficialService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

/**
 * @author Oscar Santiago Florez, Yilber Andrey Rojas, Ana Lucero Perez y Juan Sebastian vargas
 */
@Path("/officials")
public class OfficialReosource {

    /**
     *  create an official with the /officials path and post method
     * @param official
     * @return official created
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(OfficialPOJO official) {

        Optional<OfficialPOJO> persistedOfficial = new OfficialService().createOfficial(official);

        if (persistedOfficial.isPresent()) {
            return Response.status(Response.Status.CREATED)
                    .entity(persistedOfficial.get())
                    .build();
        } else {
            return Response.serverError()
                    .entity("error")
                    .build();
        }

    }

    /**
     * put method to update official
     * @param official
     * @param update
     * @param officialPOJO
     * @return official modified
     */
    @PUT
    @Path("/{official}/{update}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response modify(@PathParam("official") String official, @PathParam("update") String update, OfficialPOJO officialPOJO){
        Optional<OfficialPOJO> persistedOfficial = null;

        if(official.equals("official") && update.equals("name")){
            persistedOfficial = Optional.of(new OfficialService().updateName(officialPOJO.getName(), officialPOJO.getUsername()));
        }else if (official.equals("official") && update.equals("email")){
            persistedOfficial = Optional.of(new OfficialService().updateEmail(officialPOJO.getEmail(), officialPOJO.getUsername()));
        }else{
            persistedOfficial = null;
        }
        if (persistedOfficial.isPresent()){
            return Response.status(Response.Status.CREATED).build();
        }else{
            return Response.status(400).build();
        }
    }
}
