package hu.ulyssys.java.course.maven.rest;

import hu.ulyssys.java.course.maven.entity.Slug;
import hu.ulyssys.java.course.maven.rest.model.SlugModel;
import hu.ulyssys.java.course.maven.service.SlugService;
import hu.ulyssys.java.course.maven.service.FarmerService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.stream.Collectors;

@Path("/slug")
public class SlugRestService extends CoreRestService<Slug, SlugModel> {

    @Override
    protected Slug initNewEntity() {
        return new Slug();
    }

}
