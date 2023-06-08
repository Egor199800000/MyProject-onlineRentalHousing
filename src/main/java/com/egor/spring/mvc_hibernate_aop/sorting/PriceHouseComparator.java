package com.egor.spring.mvc_hibernate_aop.sorting;

import com.egor.spring.mvc_hibernate_aop.entity.House;
import com.egor.spring.mvc_hibernate_aop.service.HouseService;

import java.util.Comparator;

public class PriceHouseComparator implements Comparator<House> {
    @Override
    public int compare(House house1, House house2) {
       return house1.getPrice()-house2.getPrice();
    }
}
