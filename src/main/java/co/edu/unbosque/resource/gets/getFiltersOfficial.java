package co.edu.unbosque.resource.gets;

import co.edu.unbosque.services.OfficialService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

/**
 * @author Oscar Santiago Florez, Yilber Andrey Rojas, Ana Lucero Perez y Juan Sebastian vargas
 */
@Path("/filtersOfficial")
public class getFiltersOfficial {

    /**
     * ownersNeighborhood get method and creation of the ownersNeighborhood path
     * @param localidad
     * @return Json of ownersNeighborhood
     */
    @GET
    @Path("/ownerLocalidad")
    @Produces(MediaType.APPLICATION_JSON)
    public Response ownersNeighborhood( String localidad){
        Optional persistedownerNeighborhood = Optional.of(new OfficialService().findOwnerLocalidad());
        if (persistedownerNeighborhood.isPresent()){
            return Response.status(Response.Status.OK).entity(persistedownerNeighborhood.get()).build();
        }else{
            return Response.status(400).build();
        }
    }

    /**
     * Species get method and creation of the Species path
     * @return Json of the species
     */
    @GET
    @Path("/petSpecies")
    @Produces(MediaType.APPLICATION_JSON)
    public Response petSpecies(){
        Optional persistedpetSpecies = Optional.of(new OfficialService().findBySpecie());
        if (persistedpetSpecies.isPresent()){
            return Response.status(Response.Status.OK).entity(persistedpetSpecies.get()).build();
        }else{
            return Response.status(404).build();
        }
    }

    /**
     * microchip get method and creation of the microchip path
     * @return Json of the microchip
     */
    @GET
    @Path("/statusMicrochip")
    @Produces(MediaType.APPLICATION_JSON)
    public Response statusMicrochip(){
        Optional persistedstatusMicrochip = Optional.of(new OfficialService().findPetByStatusMicrochip());
        if (persistedstatusMicrochip.isPresent()){
            return Response.status(Response.Status.OK).entity(persistedstatusMicrochip.get()).build();
        }else{
            return Response.status(404).build();
        }
    }

    /**
     * sterilization get method and creation of the sterilization path
     * @return Json of the sterilization
     */
    @GET
    @Path("/sterilization")
    @Produces(MediaType.APPLICATION_JSON)
    public Response sterilization(){
        Optional persitedsterilization = Optional.of(new OfficialService().findPetByStatusSterilization());
        if (persitedsterilization.isPresent()){
            return Response.status(Response.Status.OK).entity(persitedsterilization.get()).build();
        }else{
            return Response.status(404).build();
        }
    }

    /**
     * caseType get method and creation of the caseType path
     * @return Json of the types
     */
    @GET
    @Path("/caseType")
    @Produces(MediaType.APPLICATION_JSON)
    public Response caseType(){
        Optional persitedcaseType = Optional.of(new OfficialService().findCaseByType());
        if (persitedcaseType.isPresent()){
            return Response.status(Response.Status.OK).entity(persitedcaseType.get()).build();
        }else{
            return Response.status(404).build();
        }
    }

    /**
     * vetName get method and creation of the vetName path
     * @return Json of the vetName
     */
    @GET
    @Path("/vetName")
    @Produces(MediaType.APPLICATION_JSON)
    public Response vetName(){
        Optional persistedvetName = Optional.of(new OfficialService().findByVetName());
        if (persistedvetName.isPresent()){
            return Response.status(Response.Status.OK).entity(persistedvetName.get()).build();
        }else{
            return Response.status(404).build();
        }
    }

    /**
     * visitType get method and creation of the visitType path
     * @return Json of the visit type.
     */
    @GET
    @Path("/visitType")
    @Produces(MediaType.APPLICATION_JSON)
    public Response visitType(){
        Optional persistedvisitName = Optional.of(new OfficialService().findVisitByType());
        if (persistedvisitName.isPresent()){
            return Response.status(Response.Status.OK).entity(persistedvisitName.get()).build();
        }else{
            return Response.status(404).build();
        }
    }

}