package hu.ulyssys.java.course.maven.rest;

import hu.ulyssys.java.course.maven.entity.Order;
import hu.ulyssys.java.course.maven.rest.model.OrderModel;
import hu.ulyssys.java.course.maven.service.OrderService;
import hu.ulyssys.java.course.maven.util.OrderModelMapperBean;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.stream.Collectors;

@Path("/order")
public class OrderRestService {

    @Inject
    private OrderService orderService;

    @Inject
    private OrderModelMapperBean modelMapperBean;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response findByID(@PathParam("id") Long id) {
        Order entity = orderService.findById(id);
        if (entity == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(createModelFromEntity(entity)).build();

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        return Response.ok(orderService.getAll().stream().map(this::createModelFromEntity).collect(Collectors.toList())).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(OrderModel model) {

        Order entity = initNewEntity();
        populateEntityFromModel(entity, model);

        orderService.add(entity);
        return Response.ok(createModelFromEntity(entity)).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(OrderModel model) {
        Order entity = orderService.findById(model.getId());
        if (entity == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        populateEntityFromModel(entity, model);
        orderService.update(entity);
        return Response.ok(createModelFromEntity(entity)).build();

    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") Long id) {
        Order entity = orderService.findById(id);
        if (entity == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        orderService.remove(entity);
        return Response.ok().build();
    }

    protected OrderModel createModelFromEntity(Order entity) {
        return modelMapperBean.createModelFromEntity(entity);
    }

    protected void populateEntityFromModel(Order entity, OrderModel model) {
        modelMapperBean.populateEntityFromModel(entity, model);
    }

    protected Order initNewEntity(){
        return new Order();
    }

}


