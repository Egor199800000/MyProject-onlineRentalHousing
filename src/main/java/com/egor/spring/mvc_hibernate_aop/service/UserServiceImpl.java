package com.egor.spring.mvc_hibernate_aop.service;

import com.egor.spring.mvc_hibernate_aop.dao.UserDao;
import com.egor.spring.mvc_hibernate_aop.entity.House;
import com.egor.spring.mvc_hibernate_aop.entity.User;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    @Transactional
    public User getUser(int id) {
       return userDao.getUser(id);
    }

    @Override
    @Transactional
    public User getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }

    @Override
    @Transactional
    public User getUserByPassword(String password) {
        return userDao.getUserByPassword(password);
    }



    @Override
    @Transactional
    public void deleteUser(int id) {
        User user=userDao.getUser(id);
        userDao.deleteUser(user);
    }

    @Override
    @Transactional
    public boolean passwordAndMailAuthentication(User user) {
        User user1= userDao.getUserByEmail(user.getEmail());
        User user2= userDao.getUserByPassword(user.getPassword());

        if (user1.getId()==user2.getId()){
            System.err.println("Users equals");
            return true;
        }else {
            return false;
        }
    }
    @Override
    @Transactional
    public User getRegisteredUserByPasswordAndEmail(String password, String email){
        User user1= userDao.getUserByEmail(email);
        User user2= userDao.getUserByPassword(password);
        if (user1.getId()==user2.getId()){
            System.err.println("Users equals");
            return userDao.getUser(user1.getId());
        }
        return null;
    }

    @Override
    @Transactional
    public void addHouseToListHousesOwner(House house,User user){
       userDao.addHouseToListHousesOwner(house,user);
        System.err.println("Done");
    }
    @Override
    @Transactional
    public void addHouseToListHousesTenant(House house,User user) {
        userDao.addHouseToListHousesTenant(house,user);
        System.err.println("Done");
    }

    @Override
    @Transactional
    public User getAuthorizedUser() {
        return userDao.getAuthorizedUser();
    }

    @Override
    @Transactional
    public boolean isAuthorizedUser(User user) {
        User user1= userDao.getUserByEmail(user.getEmail());
        User user2= userDao.getUserByPassword(user.getPassword());

        if (user1.getId()==user2.getId()){
            System.err.println("Users equals");
            user=userDao.getUser(user1.getId());
            user.setAuthorized(true);
            return true;
        }
        return false;
    }

//    @Override
//    public boolean isUniqueEmail(String email) {
//        List<User> users=userDao.getAllUsers();
//        while (users.iterator().hasNext()){
//            User user=users.iterator().next();
//            if (user.getEmail().equals(email)){
//                System.out.println("not unique Email");
//                return false;
//            }
//        }
//        return true;
//    }

    @Override
    public boolean isUniqueEmail(String email) {
        System.err.println(" isUniqueEmail НАЧАЛ РАБОТУ");
        ArrayList<User> users= (ArrayList<User>) userDao.getAllUsers();
        System.err.println("МЕТОД isUniqueEmail ПОЛУЧИЛ ЮЗЕРОВ");
        for (User u: users){
            if (u.getEmail().equals(email)){
                return false;
            }
        }
        return true;
    }

    @Override
    @Transactional
    public List<House> getAllHousesOwnedByTheUser(User user) {
       return userDao.getAllHousesOwnedByTheUser(user);
    }
}
