package hu.ulyssys.java.course.maven.dao.impl;

import hu.ulyssys.java.course.maven.dao.SlugDAO;
import hu.ulyssys.java.course.maven.entity.Slug;

import javax.ejb.Stateless;

@Stateless
public class SlugDAOImpl extends AbstractFarmerAwareDAOImpl<Slug> implements SlugDAO {

    @Override
    protected Class<Slug> getManagedClass() {
        return Slug.class;
    }
}
