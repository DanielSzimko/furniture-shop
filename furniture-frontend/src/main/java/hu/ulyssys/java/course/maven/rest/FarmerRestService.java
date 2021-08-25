package hu.ulyssys.java.course.maven.rest;

import hu.ulyssys.java.course.maven.entity.*;
import hu.ulyssys.java.course.maven.rest.model.FarmerDataModel;
import hu.ulyssys.java.course.maven.rest.model.FarmerModel;
import hu.ulyssys.java.course.maven.service.*;
import hu.ulyssys.java.course.maven.service.FarmerService;
import hu.ulyssys.java.course.maven.util.CatModelMapperBean;
import hu.ulyssys.java.course.maven.util.DogModelMapperBean;
import hu.ulyssys.java.course.maven.util.ReindeerModelMapperBean;
import hu.ulyssys.java.course.maven.util.SlugModelMapperBean;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Path("/farmer")
public class FarmerRestService {

    @Inject
    private FarmerService service;
    @Inject
    private ReindeerService reindeerService;
    @Inject
    private DogService dogService;
    @Inject
    private CatService catService;
    @Inject
    private SlugService slugService;
    @Inject
    private CatModelMapperBean catModelMapperBean;
    @Inject
    private DogModelMapperBean dogModelMapperBean;
    @Inject
    private ReindeerModelMapperBean reindeerModelMapperBean;
    @Inject
    private SlugModelMapperBean slugModelMapperBean;

    @GET
    @Path("/data/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findDataById(@PathParam("id") Long id) {
        Farmer farmer = service.findById(id);
        if (farmer == null) {
            return Response.status(Response.Status.NOT_FOUND).build();

        }
        //Listányi cat
        List<Cat> catList = catService.findByFarmerId(id);
        // listányi dog
        List<Dog> dogList = dogService.findByFarmerId(id);

        //listányi slug
        List<Slug> slugList = slugService.findByFarmerId(id);

        //listányi reinderr
        List<Reindeer> reindeer = reindeerService.findByFarmerId(id);
        FarmerDataModel dataModel = new FarmerDataModel();
        dataModel.setId(farmer.getId());
        dataModel.setFullName(farmer.getFullName());
        dataModel.setCats(catModelMapperBean.createModelsFromList(catList));
        dataModel.setDogs(dogModelMapperBean.createModelsFromList(dogList));
        dataModel.setSlugs(slugModelMapperBean.createModelsFromList(slugList));
        dataModel.setReindeers(reindeerModelMapperBean.createModelsFromList(reindeer));

        return Response.ok(dataModel).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        return Response.ok(service.getAll().stream().map(this::createModelFromEntity).collect(Collectors.toList())).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(FarmerModel model) {
        Farmer farmer = new Farmer();
        farmer.setId(model.getId());
        farmer.setFullName(model.getFullName());

        service.add(farmer);
        return Response.ok(createModelFromEntity(farmer)).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(FarmerModel model) {
        Farmer farmer = service.findById(model.getId());
        if (farmer == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        farmer.setFullName(model.getFullName());
        service.update(farmer);
        return Response.ok(createModelFromEntity(farmer)).build();

    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") Long id) {
        Farmer Farmer = service.findById(id);
        if (Farmer == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        service.remove(Farmer);
        return Response.ok().build();
    }

    private FarmerModel createModelFromEntity(Farmer farmer) {
        FarmerModel model = new FarmerModel();
        model.setId(farmer.getId());
        model.setFullName(farmer.getFullName());

        return model;
    }
}
