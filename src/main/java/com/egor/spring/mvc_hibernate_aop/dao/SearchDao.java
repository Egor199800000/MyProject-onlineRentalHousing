package com.egor.spring.mvc_hibernate_aop.dao;

import com.egor.spring.mvc_hibernate_aop.entity.House;

import java.util.List;

public interface SearchDao {

    //цена по возрастанию/убыванию
   List<House> sortAllHousesByPriceAsc();
   List<House> sortAllHousesByPriceDesc();


   //дата по возрастанию/убыванию
    List<House> sortAllHousesByDateAsc();
    List<House> sortAllHousesByDateDesc();

    //поиск по диапазону цены
    List<House> getSearchAllHousesByPriceRange(int from, int to);

    //поиск по диапазону площади
    List<House> getSearchAllHousesBySquareRange(int from, int to);

    //не арендованные дома
    List<House> getAllNotRentedHouses();

    //дома с рейтингом выше 3 4 5 звезд
    List<House> getAllHousesWhereRatingFrom(int rating);







}
