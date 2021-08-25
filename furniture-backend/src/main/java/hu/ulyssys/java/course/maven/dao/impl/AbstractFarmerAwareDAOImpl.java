package hu.ulyssys.java.course.maven.dao.impl;

import hu.ulyssys.java.course.maven.dao.FarmerAwareDAO;
import hu.ulyssys.java.course.maven.entity.AbstractAnimal;
import hu.ulyssys.java.course.maven.entity.Cat;

import javax.persistence.TypedQuery;
import java.util.List;

public abstract class AbstractFarmerAwareDAOImpl<T extends AbstractAnimal> extends CoreDAOImpl<T> implements FarmerAwareDAO<T> {

    @Override
    public List<T> findByFarmerId(Long id) {
        TypedQuery<T> query = entityManager.createQuery("select n from " + getManagedClass().getSimpleName() + " n where n.farmer.id=:id order by n.id", getManagedClass());
        query.setParameter("id", id);
        return query.getResultList();
    }
}
