package hu.ulyssys.java.course.maven.service.impl;

import hu.ulyssys.java.course.maven.dao.FarmerDAO;
import hu.ulyssys.java.course.maven.entity.Farmer;
import hu.ulyssys.java.course.maven.service.FarmerService;

import javax.ejb.Stateless;

@Stateless
public class FarmerServiceImpl extends AbstractServiceImpl<Farmer> implements FarmerService {

    @Override
    public Farmer findByName(String name) {
        return ((FarmerDAO) dao).findByName(name);
    }
}
