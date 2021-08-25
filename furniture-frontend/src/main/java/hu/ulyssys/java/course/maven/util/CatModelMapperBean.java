package hu.ulyssys.java.course.maven.util;

import hu.ulyssys.java.course.maven.entity.Cat;
import hu.ulyssys.java.course.maven.rest.model.CatModel;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CatModelMapperBean extends CoreModelMapperBean<CatModel, Cat> {


    @Override
    public CatModel initNewModel() {
        return new CatModel();
    }
}
