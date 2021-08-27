package hu.ulyssys.java.course.maven.dao.impl;

import hu.ulyssys.java.course.maven.dao.CourierDAO;
import hu.ulyssys.java.course.maven.entity.Courier;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Stateless
public class CourierDAOImpl extends CoreDAOImpl<Courier> implements CourierDAO {

    @Override
    public Courier findByName(String name) {

        String[] splited = name.split(" ");

        String firstName = splited[0];
        String lastName = splited[1];

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Courier> criteriaQuery1 = criteriaBuilder.createQuery(Courier.class);
        Root<Courier> root1 = criteriaQuery1.from(Courier.class);

        Predicate[] predicates = new Predicate[2];
        predicates[0] = criteriaBuilder.equal(root1.get("lastName"), lastName);
        predicates[1] = criteriaBuilder.equal(root1.get("firstName"), firstName);

        criteriaQuery1.select(root1).where(predicates);

        TypedQuery<Courier> query = entityManager.createQuery(criteriaQuery1);

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
