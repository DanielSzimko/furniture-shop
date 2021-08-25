package hu.ulyssys.java.course.maven.util;

import hu.ulyssys.java.course.maven.entity.Reindeer;
import hu.ulyssys.java.course.maven.entity.Slug;
import hu.ulyssys.java.course.maven.rest.model.ReindeerModel;
import hu.ulyssys.java.course.maven.rest.model.SlugModel;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ReindeerModelMapperBean extends CoreModelMapperBean<ReindeerModel, Reindeer> {

    @Override
    public ReindeerModel createModelFromEntity(Reindeer entity) {
        ReindeerModel reindeerModel = super.createModelFromEntity(entity);
        reindeerModel.setHornNumber(entity.getHornNumber());
        return reindeerModel;
    }

    @Override
    public void populateEntityFromModel(Reindeer entity, ReindeerModel model) {
        super.populateEntityFromModel(entity, model);
        entity.setHornNumber(model.getHornNumber());
    }

    @Override
    public ReindeerModel initNewModel() {
        return new ReindeerModel();
    }
}
