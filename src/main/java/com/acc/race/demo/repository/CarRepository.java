package com.acc.race.demo.repository;

import com.acc.race.demo.model.Car;
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

    public List<String> findManufacturers() {
        Query q = em.createNativeQuery("select distinct manufacturer from car");
        return q.getResultList();
    }

    public void deleteCar(Long id) {
        em.createQuery("delete from Car where id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }

    public List<Car> findByManufacturer(String brand) {
        Query q = em.createQuery("from Car where manufacturer = :brand")
                .setParameter("brand", brand);
        return q.getResultList();
    }
}
