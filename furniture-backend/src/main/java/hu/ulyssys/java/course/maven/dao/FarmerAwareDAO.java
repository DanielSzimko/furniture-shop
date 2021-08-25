package hu.ulyssys.java.course.maven.dao;

import hu.ulyssys.java.course.maven.entity.AbstractAnimal;

import java.util.List;

public interface FarmerAwareDAO<T extends AbstractAnimal> extends CoreDAO<T> {
    List<T> findByFarmerId(Long id);

}
