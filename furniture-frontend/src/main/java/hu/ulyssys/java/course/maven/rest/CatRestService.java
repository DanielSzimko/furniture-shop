package hu.ulyssys.java.course.maven.rest;

import hu.ulyssys.java.course.maven.entity.Cat;
import hu.ulyssys.java.course.maven.rest.model.CatModel;

import javax.ws.rs.Path;

@Path("/cat")
public class CatRestService extends CoreRestService<Cat, CatModel> {

    @Override
    protected Cat initNewEntity() {
        return new Cat();
    }

}
