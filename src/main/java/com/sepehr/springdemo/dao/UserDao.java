package com.sepehr.springdemo.dao;

import com.sepehr.springdemo.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao implements DAO<User> {

    private SessionFactory factory;

    @Autowired
    public void setFactory(SessionFactory factory) {
        this.factory = factory;
    }

    public List<User> getReferences(){
        Session session = factory.getCurrentSession();

        Query<User> query = session.createQuery("from User order by lastName");

        List<User> users = query.getResultList();

        return users;
    }

    public void save(User user){
        Session session = factory.getCurrentSession();

        session.save(user);
    }

    public void saveOrUpdate(User reference) {
        Session session = factory.getCurrentSession();

        session.saveOrUpdate(reference);
    }

    public User getReferenceById(Object id) {
        Session session = factory.getCurrentSession();

        User user = session.get(User.class, (Integer) id);

        return user;
    }

    public User getReferencesBySpecialValue(Object email){
        Session session = factory.getCurrentSession();

        User user = (User) session.createQuery("from User where email = :email").setParameter("email", email.toString()).uniqueResult();

        return user;

    }

    public void update(User references) {
        Session session = factory.getCurrentSession();

        session.update(references);
    }

    public void delete(User references) {
        Session session = factory.getCurrentSession();

        session.delete(references);
    }

    public void reset() {
        Session session = factory.getCurrentSession();

        session.createQuery("delete from User").executeUpdate();
    }
}
