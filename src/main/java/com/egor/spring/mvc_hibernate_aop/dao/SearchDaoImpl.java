package com.egor.spring.mvc_hibernate_aop.dao;

import com.egor.spring.mvc_hibernate_aop.entity.House;

import java.util.List;

public class SearchDaoImpl implements SearchDao{
    @Override
    public List<House> sortAllHousesByPriceAsc() {
        return null;
    }

    @Override
    public List<House> sortAllHousesByPriceDesc() {
        return null;
    }

    @Override
    public List<House> sortAllHousesByDateAsc() {
        return null;
    }

    @Override
    public List<House> sortAllHousesByDateDesc() {
        return null;
    }

    @Override
    public List<House> getSearchAllHousesByPriceRange(int from, int to) {
        return null;
    }

    @Override
    public List<House> getSearchAllHousesBySquareRange(int from, int to) {
        return null;
    }

    @Override
    public List<House> getAllNotRentedHouses() {
        return null;
    }

    @Override
    public List<House> getAllHousesWhereRatingFrom(int rating) {
        return null;
    }
}
