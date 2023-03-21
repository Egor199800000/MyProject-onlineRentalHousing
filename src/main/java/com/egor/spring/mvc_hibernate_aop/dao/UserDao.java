package com.egor.spring.mvc_hibernate_aop.dao;


import com.egor.spring.mvc_hibernate_aop.entity.House;
import com.egor.spring.mvc_hibernate_aop.entity.User;

import java.util.List;

public interface UserDao{

    List<User> getAllUsers();

     User getUser(int id);

     User getUserByEmail(String email);

     void saveUser(User user);//регистрация происходит сразу, если isEnable=false, то не открывается стартовая страница

    void deleteUser(User user);//пользователь может удалить аккаунт isDeleted=true, вместе с этим удаляются его объявления и арендованные дома становятся свободны

    User getUserByPassword(String password);

    //boolean passwordAndMailAuthentication(String password, String email);

    public User getAuthorizedUser();

    public void addHouseToListHousesOwner(House house, User user);
    public void addHouseToListHousesTenant(House house, User user);

    List<House> getAllHousesOwnedByTheUser(User user);

}
