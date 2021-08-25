package hu.ulyssys.java.course.maven.dao.impl;

import hu.ulyssys.java.course.maven.dao.FarmerDAO;
import hu.ulyssys.java.course.maven.entity.Farmer;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Stateless
public class FarmerDAOImpl extends CoreDAOImpl<Farmer> implements FarmerDAO {


    @Override
    public Farmer findByName(String name) {
        //select f from Farmer f where fullname=name;
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Farmer> criteriaQuery = criteriaBuilder.createQuery(Farmer.class);
        Root<Farmer> root = criteriaQuery.from(Farmer.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("fullName"), name));
        TypedQuery<Farmer> query = entityManager.createQuery(criteriaQuery);

        //TypedQuery<Farmer> query = entityManager.createQuery("select f from Farmer f where f.fullName=:name", Farmer.class);
        List<Farmer> list = query.getResultList();
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected Class<Farmer> getManagedClass() {
        return Farmer.class;
    }
}
