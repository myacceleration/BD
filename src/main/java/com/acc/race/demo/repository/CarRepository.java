package com.acc.race.demo.repository;

import com.acc.race.demo.model.Car;
import com.acc.race.demo.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Repository
@Transactional
public class CarRepository {


    @PersistenceContext
    EntityManager em;

    public void saveCar(Car c) {
        em.persist(c);
    }

    public List<Car> findAll() {
       Query q =  em.createQuery("from Car");
       return q.getResultList();
    }
}
