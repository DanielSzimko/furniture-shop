package hu.ulyssys.java.course.maven.rest;

import hu.ulyssys.java.course.maven.entity.Reindeer;
import hu.ulyssys.java.course.maven.rest.model.ReindeerModel;

import javax.ws.rs.Path;

@Path("/reindeer")
public class ReindeerRestService extends CoreRestService<Reindeer, ReindeerModel> {

    @Override
    protected Reindeer initNewEntity() {
        return new Reindeer();
    }



}
