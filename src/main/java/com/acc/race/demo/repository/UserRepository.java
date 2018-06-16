package com.acc.race.demo.repository;

import com.acc.race.demo.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Repository
@Transactional
public class UserRepository{


    @PersistenceContext
    EntityManager em;

    public void saveUser(User u) {
        em.persist(u);
    }

    public List<User> findAll() {
       Query q =  em.createQuery("from User");
       return q.getResultList();
    }

    public void deleteUser(Long id) {
        em.createQuery("delete from User where id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }

    public User findByLogin(String login) {
        Query q = em.createQuery("from User where login = :login")
                .setParameter("login", login);
        List l = q.getResultList();
        if(l.size() == 1) {
            return (User)l.get(0);
        }
        return null;
    }
}
