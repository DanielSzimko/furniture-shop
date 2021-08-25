package hu.ulyssys.java.course.maven.util;

import hu.ulyssys.java.course.maven.entity.Dog;
import hu.ulyssys.java.course.maven.rest.model.DogModel;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DogModelMapperBean extends CoreModelMapperBean<DogModel, Dog> {


    @Override
    public DogModel initNewModel() {
        return new DogModel();
    }
}
