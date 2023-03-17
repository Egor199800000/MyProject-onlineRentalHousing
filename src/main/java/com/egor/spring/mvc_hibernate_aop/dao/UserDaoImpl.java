package com.egor.spring.mvc_hibernate_aop.dao;


import com.egor.spring.mvc_hibernate_aop.entity.House;
import com.egor.spring.mvc_hibernate_aop.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveUser(User user) {
        Session session= sessionFactory.getCurrentSession();
        session.merge(user);
    }

    @Override
    public User getUser(int id) {
        Session session=sessionFactory.getCurrentSession();
        User user=session.get(User.class,id);
        return user;
    }

    @Override
    public User getUserByPassword(String reqPassword) {
        Session session=sessionFactory.getCurrentSession();
        String hql="from User where password= :lg";
        Query query=session.createQuery(hql);
        query.setParameter("lg",reqPassword);
        List<User> users=query.getResultList();
        User user=users.get(0);
        int id=user.getId();
        System.err.println(user.getId());
        User userByEmail=session.get(User.class,id);
        return userByEmail;
    }

    @Override
    public User getUserByEmail(String reqEmail) {
        Session session=sessionFactory.getCurrentSession();
        String hql="from User where email= :lg";
            Query query=session.createQuery(hql);
            query.setParameter("lg",reqEmail);
            List<User> users=query.getResultList();
            User user=users.get(0);
            int id=user.getId();
            System.err.println(user.getId());
        User userByEmail=session.get(User.class,id);
        return userByEmail;
    }



    @Override
    public List<User> getAllUsers() {
        Session session=sessionFactory.getCurrentSession();
        Query<User> query=session.createQuery("from User", User.class);
        List<User> allUsers=query.getResultList();
        return allUsers;
    }




    @Override
    public void deleteUser(User user) {
        Session session=sessionFactory.getCurrentSession();
        user.setEnable(false);
        user.setDeleted(true);
        session.merge(user);
    }

    @Override
    public void addHouseToListHouses(House house, User user){
        Session session=sessionFactory.getCurrentSession();
        List<House> housesList=user.getHouses();
        System.err.println("Method addHouseToListHouses on");
        if (housesList==null){
            System.err.println("First House for "+user.getName());
            housesList=new ArrayList<>();
        }
        housesList.add(house);
        house.setOwner(user);//by Directional связь
        session.merge(user);
    }


    @Override
    public User getAuthorizedUser() {
        Session session=sessionFactory.getCurrentSession();
        Query<User> query=session.createQuery("from User", User.class);
        List<User> allUsers=query.getResultList();
        User user=null;
        for (int i=0;i<allUsers.size();){
             user=session.get(User.class,i+1);
            if (user.isAuthorized()){
                System.err.println(user.getName()+" Authorized");
                return user;
            }
            else i++;
        }
        System.err.println("No authorized user");
        return user;
    }


//    @Override
//    public boolean passwordAndMailAuthentication(String password, String email) {
//        password=sessionFactory.getCurrentSession()
//    }

}
