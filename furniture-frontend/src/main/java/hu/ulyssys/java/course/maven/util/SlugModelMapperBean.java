package hu.ulyssys.java.course.maven.util;

import hu.ulyssys.java.course.maven.entity.Slug;
import hu.ulyssys.java.course.maven.rest.model.SlugModel;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SlugModelMapperBean extends CoreModelMapperBean<SlugModel, Slug> {


    @Override
    public SlugModel initNewModel() {
        return new SlugModel();
    }
}
