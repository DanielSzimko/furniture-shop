package hu.ulyssys.java.course.maven.dao.impl;

import hu.ulyssys.java.course.maven.dao.CatDAO;
import hu.ulyssys.java.course.maven.entity.Cat;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

@Stateless
public class CatDAOImpl extends AbstractFarmerAwareDAOImpl<Cat> implements CatDAO {

    @Override
    protected Class<Cat> getManagedClass() {
        return Cat.class;
    }

}
