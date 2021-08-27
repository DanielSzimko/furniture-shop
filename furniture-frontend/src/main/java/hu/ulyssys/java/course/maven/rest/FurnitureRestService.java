package hu.ulyssys.java.course.maven.rest;

import hu.ulyssys.java.course.maven.entity.Courier;
import hu.ulyssys.java.course.maven.entity.Furniture;
import hu.ulyssys.java.course.maven.rest.model.CourierModel;
import hu.ulyssys.java.course.maven.rest.model.FurnitureModel;
import hu.ulyssys.java.course.maven.service.FurnitureService;
import hu.ulyssys.java.course.maven.util.FurnitureModelMapperBean;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.stream.Collectors;

@Path("/furniture")
public class FurnitureRestService {

    @Inject
    private FurnitureService furnitureService;

    @Inject
    private FurnitureModelMapperBean modelMapperBean;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response findByID(@PathParam("id") Long id) {
        Furniture entity = furnitureService.findById(id);
        if (entity == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(createModelFromEntity(entity)).build();

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        return Response.ok(furnitureService.getAll().stream().map(this::createModelFromEntity).collect(Collectors.toList())).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(FurnitureModel model) {

        Furniture entity = initNewEntity();
        populateEntityFromModel(entity, model);

        furnitureService.add(entity);
        return Response.ok(createModelFromEntity(entity)).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(FurnitureModel model) {
        Furniture entity = furnitureService.findById(model.getId());
        if (entity == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        populateEntityFromModel(entity, model);
        furnitureService.update(entity);
        return Response.ok(createModelFromEntity(entity)).build();

    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") Long id) {
        Furniture entity = furnitureService.findById(id);
        if (entity == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        furnitureService.remove(entity);
        return Response.ok().build();
    }

    protected FurnitureModel createModelFromEntity(Furniture entity) {
        return modelMapperBean.createModelFromEntity(entity);
    }

    protected void populateEntityFromModel(Furniture entity, FurnitureModel model) {
        modelMapperBean.populateEntityFromModel(entity, model);
    }

    protected Furniture initNewEntity(){
        return new Furniture();
    }

}
