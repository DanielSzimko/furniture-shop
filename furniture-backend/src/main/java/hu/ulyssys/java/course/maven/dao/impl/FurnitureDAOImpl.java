package hu.ulyssys.java.course.maven.dao.impl;

import hu.ulyssys.java.course.maven.dao.FurnitureDAO;
import hu.ulyssys.java.course.maven.entity.Furniture;

import javax.ejb.Stateless;

@Stateless
public class FurnitureDAOImpl extends CoreDAOImpl<Furniture> implements FurnitureDAO {
    @Override
    protected Class<Furniture> getManagedClass() {
        return Furniture.class;
    }
}
