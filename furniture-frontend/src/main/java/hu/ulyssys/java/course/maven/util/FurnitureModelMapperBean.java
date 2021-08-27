package hu.ulyssys.java.course.maven.util;

import hu.ulyssys.java.course.maven.entity.Furniture;
import hu.ulyssys.java.course.maven.rest.model.FurnitureModel;
import hu.ulyssys.java.course.maven.service.AppUserService;

import javax.inject.Inject;
import java.util.Date;

public class FurnitureModelMapperBean {

    @Inject
    private AppUserService appUserService;

    public FurnitureModel createModelFromEntity(Furniture furniture) {
        FurnitureModel model = initNewModel();
        model.setId(furniture.getId());
        model.setName(furniture.getName());
        model.setDescription(furniture.getDescription());
        model.setPrice(furniture.getPrice());
        model.setCreatedDate(furniture.getCreatedDate());
        model.setModifiedDate(furniture.getModifiedDate());
        model.setCreatorID(furniture.getCreatorUser().getId());
        model.setModifierID(furniture.getModifierUser().getId());
        return model;
    }

    public void populateEntityFromModel(Furniture furniture, FurnitureModel model){
        if(model.getId() != null){
            furniture.setId(model.getId());
            furniture.setName(model.getName());
            furniture.setDescription(model.getDescription());
            furniture.setPrice(model.getPrice());
            furniture.setCreatorUser(appUserService.findById(model.getCreatorID()));
            furniture.setModifierUser(appUserService.findById(model.getModifierID()));
            furniture.setCreatedDate(model.getCreatedDate());
            furniture.setModifiedDate(new Date());
        } else {
            furniture.setName(model.getName());
            furniture.setDescription(model.getDescription());
            furniture.setPrice(model.getPrice());
            furniture.setCreatorUser(appUserService.findById(model.getCreatorID()));
            furniture.setModifierUser(appUserService.findById(model.getModifierID()));
            furniture.setCreatedDate(new Date());
            furniture.setModifiedDate(new Date());
        }

    }

    public FurnitureModel initNewModel(){
        return new FurnitureModel();
    }

}
