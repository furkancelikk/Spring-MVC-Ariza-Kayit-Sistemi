package com.ileriJava.dao;

import com.ileriJava.model.User;
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

@Repository
public class UserRepository{

    @Autowired
    private SessionFactory sessionFactory;

    public List<User> getUser() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery< User > cq = cb.createQuery(User.class);
        Root< User > root = cq.from(User.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }

    public User getByNameAndPassword(String kullaniciAdi, String sifre){
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);

        Root<User> user = cq.from(User.class);
        Predicate kullaniciAdiPredicate = cb.equal(user.get("email"), kullaniciAdi);
        Predicate sifrePredicate = cb.equal(user.get("sifre"), sifre);
        cq.where(kullaniciAdiPredicate, sifrePredicate);

        Query query = session.createQuery(cq);
        Object result = query.getSingleResult();
        return (User)result;
    }

    public User findByMail(String email) {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);

        Root<User> user = cq.from(User.class);
        Predicate emailPredicate = cb.equal(user.get("email"), email);
        cq.where(emailPredicate);

        Query query = session.createQuery(cq);
        Object result = query.getSingleResult();
        return (User)result;
    }
}
