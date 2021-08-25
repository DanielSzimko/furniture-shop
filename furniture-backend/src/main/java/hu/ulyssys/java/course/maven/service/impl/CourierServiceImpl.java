package hu.ulyssys.java.course.maven.service.impl;

import hu.ulyssys.java.course.maven.entity.Courier;
import hu.ulyssys.java.course.maven.entity.Farmer;
import hu.ulyssys.java.course.maven.service.CourierService;

import javax.ejb.Stateless;

@Stateless
public class CourierServiceImpl extends AbstractServiceImpl<Courier> implements CourierService {


    @Override
    public Courier findByName(String name) {
        return null;
    }
}
