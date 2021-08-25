package hu.ulyssys.java.course.maven.service;

import hu.ulyssys.java.course.maven.entity.AbstractAnimal;

import java.util.List;

public interface FarmerAwareService<T extends AbstractAnimal> {

    List<T> findByFarmerId(Long id);

}
