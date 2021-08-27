package hu.ulyssys.java.course.maven.util;

import hu.ulyssys.java.course.maven.entity.AppUser;
import hu.ulyssys.java.course.maven.entity.Courier;
import hu.ulyssys.java.course.maven.rest.CourierRestService;
import hu.ulyssys.java.course.maven.rest.model.CourierModel;
import hu.ulyssys.java.course.maven.service.AppUserService;
import hu.ulyssys.java.course.maven.service.CourierService;

import javax.inject.Inject;
import java.util.Date;

public class CourierModelMapperBean {

    @Inject
    private AppUserService appUserService;

    public CourierModel createModelFromEntity(Courier courier){
        CourierModel model = initNewModel();
        model.setId(courier.getId());
        model.setFirstName(courier.getFirstName());
        model.setLastName(courier.getLastName());
        model.setMobileNumber(courier.getMobileNumber());
        model.setCreatedDate(courier.getCreatedDate());
        model.setModifiedDate(courier.getModifiedDate());
        model.setCreatorID(courier.getCreatorUser().getId());
        if(courier.getModifierUser() != null){
            model.setModifierID(courier.getModifierUser().getId());
        }
        return model;
    }

    public void populateEntityFromModel(Courier courier, CourierModel model){

        if(model.getId() != null){
            courier.setId(model.getId());
            courier.setFirstName(model.getFirstName());
            courier.setLastName(model.getLastName());
            courier.setModifiedDate(new Date());
            courier.setMobileNumber(model.getMobileNumber());
            courier.setCreatorUser(appUserService.findById(model.getCreatorID()));
            if(model.getModifierID() != null){
                courier.setModifierUser(appUserService.findById(model.getModifierID()));
            }
        } else {
            courier.setFirstName(model.getFirstName());
            courier.setLastName(model.getLastName());
            courier.setCreatedDate(new Date());
            courier.setModifiedDate(null);
            courier.setMobileNumber(model.getMobileNumber());
            courier.setCreatorUser(appUserService.findById(model.getCreatorID()));
            if(model.getModifierID() != null){
                courier.setModifierUser(appUserService.findById(model.getModifierID()));
            }
        }

    }

    public CourierModel initNewModel(){
        return new CourierModel();
    }

}
