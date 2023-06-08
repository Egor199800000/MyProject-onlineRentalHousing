package com.egor.spring.mvc_hibernate_aop.service;

import com.egor.spring.mvc_hibernate_aop.dao.HouseDao;
import com.egor.spring.mvc_hibernate_aop.entity.House;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class HouseServiceImpl implements HouseService{

    @Autowired
    @Qualifier("houseRep")
    HouseDao houseDao;

    @Override
    @Transactional
    public List<House> getAllHouses() {
        return houseDao.getAllHouses();
    }

    public List<House> getAllHousesByPriceAscending() {
        return houseDao.getAllHousesByPriceAscending();
    }

    @Override
    @Transactional
    public void saveHouse(House house) {
        houseDao.saveHouse(house);
    }

    @Override
    @Transactional
    public House getHouse(int id) {
        return houseDao.getHouse(id);
    }

    @Override
    @Transactional
    public void deleteHouse(int id) {
        House house=houseDao.getHouse(id);
houseDao.deleteHouse(house);
    }
}
