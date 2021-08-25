package hu.ulyssys.java.course.maven.service.impl;

import hu.ulyssys.java.course.maven.dao.FarmerAwareDAO;
import hu.ulyssys.java.course.maven.entity.AbstractAnimal;
import hu.ulyssys.java.course.maven.service.FarmerAwareService;

import java.util.List;

public abstract class AbstractFarmerServiceImpl<T extends AbstractAnimal> extends AbstractServiceImpl<T> implements FarmerAwareService<T> {


    @Override
    public List<T> findByFarmerId(Long id) {
        return ((FarmerAwareDAO<T>) dao).findByFarmerId(id);
    }
}
