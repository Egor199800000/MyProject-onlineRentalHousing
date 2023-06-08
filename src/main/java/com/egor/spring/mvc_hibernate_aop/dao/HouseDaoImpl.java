package com.egor.spring.mvc_hibernate_aop.dao;

import com.egor.spring.mvc_hibernate_aop.entity.House;
import com.egor.spring.mvc_hibernate_aop.sorting.PriceHouseComparator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository("houseRep")
public class HouseDaoImpl implements HouseDao{

    @Override
    public List<House> getAllRentedHouses() {
        return null;
    }

    @Autowired
    private SessionFactory sessionFactory; //Внедрение SessionFactory-бина для работы с БД

    @Override
    public List<House> getAllHouses() {
        Session session=sessionFactory.getCurrentSession();
        Query<House> query=session.createQuery("from House", House.class);
        List<House> allHouses=query.getResultList();
        for (int i=0;i<allHouses.size();i++){
            System.err.println(allHouses.get(i).getOwner().getName());
        }
        return allHouses;
    }

    @Override
    public List<House> getAllHousesByPriceAscending() {
        Session session=sessionFactory.getCurrentSession();
        Query<House> query=session.createQuery("from House", House.class);
        List<House> allHouses=query.getResultList();
       Collections.sort(allHouses,new PriceHouseComparator());
        return allHouses;
    }

    @Override
    public House getHouse(int id) {
        Session session=sessionFactory.getCurrentSession();
        House house=session.get(House.class,id);
        return house;
    }

    @Override
    public void saveHouse(House house) {
        Session session= sessionFactory.getCurrentSession();
        session.merge(house);
    }

    @Override
    public void deleteHouse(House house) {
        Session session=sessionFactory.getCurrentSession();
        house.setDeleted(true);
        house.setRented(false);
        session.merge(house);
    }
}
