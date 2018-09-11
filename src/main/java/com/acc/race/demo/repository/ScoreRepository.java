package com.acc.race.demo.repository;

import com.acc.race.demo.model.Car;
import com.acc.race.demo.model.Score;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Repository
@Transactional
public class ScoreRepository {


    @PersistenceContext
    EntityManager em;

    public void saveScore(Score s) {
        em.persist(s);
    }

    public List<Score> findAll() {
       Query q =  em.createQuery("from Score");
       return q.getResultList();
    }

    public List<Score> findByCar(Long car) {
        Query q = em.createQuery("from Score where car.id = :car")
                .setParameter("car", car);
        return q.getResultList();
    }
}
