package hu.ulyssys.java.course.maven.util;

import hu.ulyssys.java.course.maven.entity.AbstractAnimal;
import hu.ulyssys.java.course.maven.rest.model.CoreRestModel;
import hu.ulyssys.java.course.maven.service.FarmerService;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public abstract class CoreModelMapperBean<M extends CoreRestModel, T extends AbstractAnimal> {

    @Inject
    private FarmerService farmerService;

    public M createModelFromEntity(T entity) {
        M model = initNewModel();
        model.setLegsNumber(entity.getLegsNumber());
        model.setId(entity.getId());
        model.setName(entity.getName());
        if (entity.getFarmer() != null) {
            model.setFarmerID(entity.getFarmer().getId());
        }
        return model;
    }

    public List<M> createModelsFromList(List<T> entity) {
        return entity.stream().map(this::createModelFromEntity).collect(Collectors.toList());
    }

    public void populateEntityFromModel(T entity, M model) {
        if (model.getFarmerID() != null) {
            entity.setFarmer(farmerService.findById(model.getFarmerID()));
        }
        entity.setName(model.getName());
        entity.setLegsNumber(model.getLegsNumber());
    }

    public abstract M initNewModel();

}
