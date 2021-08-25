package hu.ulyssys.java.course.maven.rest;

import hu.ulyssys.java.course.maven.entity.Dog;
import hu.ulyssys.java.course.maven.rest.model.DogModel;
import hu.ulyssys.java.course.maven.service.DogService;
import hu.ulyssys.java.course.maven.service.FarmerService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.stream.Collectors;

@Path("/dog")
public class DogRestService extends CoreRestService<Dog, DogModel> {

    @Override
    protected Dog initNewEntity() {
        return new Dog();
    }

    @Override
    protected DogModel initNewModel() {
        return new DogModel();
    }
}
