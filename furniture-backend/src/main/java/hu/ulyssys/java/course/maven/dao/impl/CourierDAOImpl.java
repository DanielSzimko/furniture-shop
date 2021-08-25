package hu.ulyssys.java.course.maven.dao.impl;

import hu.ulyssys.java.course.maven.dao.CourierDAO;
import hu.ulyssys.java.course.maven.entity.Courier;
import hu.ulyssys.java.course.maven.entity.Farmer;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Stateless
public class CourierDAOImpl extends CoreDAOImpl<Courier> implements CourierDAO {

    @Override
    public Courier findByName(String name) {
        //select f from Farmer f where fullname=name;
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Courier> criteriaQuery = criteriaBuilder.createQuery(Courier.class);
        Root<Courier> root = criteriaQuery.from(Courier.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("id"), name));
        TypedQuery<Courier> query = entityManager.createQuery(criteriaQuery);

        //TypedQuery<Farmer> query = entityManager.createQuery("select f from Farmer f where f.fullName=:name", Farmer.class);
        List<Courier> list = query.getResultList();
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }


    @Override
    protected Class<Courier> getManagedClass() {
        return Courier.class;
    }
}
