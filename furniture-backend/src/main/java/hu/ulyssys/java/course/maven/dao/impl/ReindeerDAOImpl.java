package hu.ulyssys.java.course.maven.dao.impl;

import hu.ulyssys.java.course.maven.dao.ReindeerDAO;
import hu.ulyssys.java.course.maven.entity.Reindeer;

import javax.ejb.Stateless;

@Stateless
public class ReindeerDAOImpl extends AbstractFarmerAwareDAOImpl<Reindeer> implements ReindeerDAO {
    @Override
    protected Class<Reindeer> getManagedClass() {
        return Reindeer.class;
    }
}
