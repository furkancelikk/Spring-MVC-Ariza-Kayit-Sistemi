package com.ileriJava.daoImpl;

import com.ileriJava.dao.UserRepository;
import com.ileriJava.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> getUser() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery< User > cq = cb.createQuery(User.class);
        Root< User > root = cq.from(User.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public void saveUser(User theUser) {

    }

    @Override
    public User getUser(int theId) {
        return null;
    }

    @Override
    public void deleteUser(int theId) {

    }

    @Override
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
}
