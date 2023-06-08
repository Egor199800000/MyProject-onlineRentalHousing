package com.egor.spring.mvc_hibernate_aop.service;


import com.egor.spring.mvc_hibernate_aop.entity.House;
import com.egor.spring.mvc_hibernate_aop.entity.User;

import java.util.List;


public interface UserService {

     List<User> getAllUsers();
     void saveUser(User user);

     User getUser(int id);

     User getUserByEmail(String email);

     void deleteUser(int id);

     boolean passwordAndMailAuthentication(User user);

     User getUserByPassword(String password);

     public void addHouseToListHousesOwner(House house, User user);

     public User getAuthorizedUser();

     void addHouseToListHousesTenant(House house,User user);

     public List<House> getAllHousesOwnedByTheUser(User user);

     public boolean isAuthorizedUser(User user);

     User getRegisteredUserByPasswordAndEmail(String password, String email);

    boolean isUniqueEmail(String email);
}
