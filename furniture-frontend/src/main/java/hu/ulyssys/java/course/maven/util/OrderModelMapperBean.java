package hu.ulyssys.java.course.maven.util;

import hu.ulyssys.java.course.maven.entity.Furniture;
import hu.ulyssys.java.course.maven.entity.Order;
import hu.ulyssys.java.course.maven.rest.model.FurnitureModel;
import hu.ulyssys.java.course.maven.rest.model.OrderModel;
import hu.ulyssys.java.course.maven.service.AppUserService;
import hu.ulyssys.java.course.maven.service.CourierService;

import javax.inject.Inject;
import java.util.Date;

public class OrderModelMapperBean {

    @Inject
    private AppUserService appUserService;

    @Inject
    private CourierService courierService;

    public OrderModel createModelFromEntity(Order order) {
        OrderModel model = initNewModel();
        model.setCity(order.getCity());
        model.setStreet(order.getStreet());
        model.setTypeOfStreet(model.getTypeOfStreet());
        model.setId(order.getId());
        model.setCreatedDate(order.getCreatedDate());
        model.setModifiedDate(order.getModifiedDate());
        model.setDeliverDate(order.getDeliverDate());
        model.setFurnitureList(order.getFurnitureList());
        model.setHouseNumber(order.getHouseNumber());
        model.setCreatorID(order.getCreatorUser().getId());
        if(order.getModifierUser() != null){
            model.setModifierID(order.getModifierUser().getId());
        }
        else {
            model.setModifierID(null);
        }

        return model;
    }

    public void populateEntityFromModel(Order order, OrderModel model){

        if(model.getId() != null){
            order.setId(model.getId());
            order.setCity(model.getCity());
            order.setStreet(model.getStreet());
            order.setTypeOfStreet(model.getTypeOfStreet());
            order.setCreatedDate(model.getCreatedDate());
            order.setModifiedDate(new Date());
            order.setDeliverDate(model.getDeliverDate());
            order.setFurnitureList(model.getFurnitureList());
            order.setHouseNumber(model.getHouseNumber());
            order.setCreatorUser(appUserService.findById(model.getCreatorID()));
            order.setModifierUser(appUserService.findById(model.getModifierID()));
        } else {
            order.setCity(model.getCity());
            order.setStreet(model.getStreet());
            order.setTypeOfStreet(model.getTypeOfStreet());
            order.setCreatedDate(new Date());
            order.setModifiedDate(null);
            order.setDeliverDate(new Date());
            order.setFurnitureList(model.getFurnitureList());
            order.setHouseNumber(model.getHouseNumber());
            order.setCreatorUser(appUserService.findById(model.getCreatorID()));
            order.setModifierUser(appUserService.findById(model.getModifierID()));
        }

    }

    public OrderModel initNewModel(){
        return new OrderModel();
    }

}
