package com.ileriJava.dao;

import com.ileriJava.model.Comments;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @author furkancelik
 **/

@Repository
public class CommentRepository {

    @Autowired
    SessionFactory sessionFactory;


    public List<Comments> findByPostID(Long postID) {

        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Comments> cq = cb.createQuery(Comments.class);
        Root< Comments > commentRoot = cq.from(Comments.class);

        Predicate postPredicate = cb.equal(commentRoot.get("faultRecord").get("faultid"), postID);

        cq.where(postPredicate);

        Query query = session.createQuery(cq);
        return query.getResultList();
    }
}
