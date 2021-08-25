package hu.ulyssys.java.course.maven.dao.impl;

import hu.ulyssys.java.course.maven.dao.DogDAO;
import hu.ulyssys.java.course.maven.entity.Dog;

import javax.ejb.Stateless;

@Stateless
public class DogDAOImpl extends AbstractFarmerAwareDAOImpl<Dog> implements DogDAO {

    @Override
    protected Class<Dog> getManagedClass() {
        return Dog.class;
    }
}
