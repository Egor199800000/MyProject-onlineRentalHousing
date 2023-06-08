package com.egor.spring.mvc_hibernate_aop.dao;


import com.egor.spring.mvc_hibernate_aop.entity.House;

import java.util.List;

public interface HouseDao {

     List<House> getAllHouses();

     List<House> getAllRentedHouses();

    House getHouse(int id);

    void saveHouse(House house);

    void deleteHouse(House house);//удаление дома, isDeleted=true, isRented=true

    public List<House> getAllHousesByPriceAscending();
}
