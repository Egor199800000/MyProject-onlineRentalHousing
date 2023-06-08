package com.egor.spring.mvc_hibernate_aop.service;


import com.egor.spring.mvc_hibernate_aop.entity.House;
import com.egor.spring.mvc_hibernate_aop.entity.User;


import java.util.List;

public interface HouseService {

    public List<House> getAllHouses();
    void saveHouse(House house);

   House getHouse(int id);

    void deleteHouse(int id);

    public List<House> getAllHousesByPriceAscending();

}
