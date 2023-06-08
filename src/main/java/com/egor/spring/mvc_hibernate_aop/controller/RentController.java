//package com.egor.spring.mvc_hibernate_aop.controller;
//
//import com.egor.spring.mvc_hibernate_aop.entity.House;
//import com.egor.spring.mvc_hibernate_aop.entity.User;
//import com.egor.spring.mvc_hibernate_aop.service.HouseService;
//import com.egor.spring.mvc_hibernate_aop.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@Controller
//public class RentController {
//    @Autowired
//    private HouseService houseService;
//
//    @Autowired
//    private UserService userService;
//
//    //TODO:Доработать
//    @GetMapping("rentAHouse") //-кнопка
//    public String rent(@RequestParam("houseId") int id, Model model){
////сюда должны попасть id дома который мы смотрим
//        House house=houseService.getHouse(id);
//        System.err.println(houseService.getHouse(id).getDescription());
//        User user=userService.getAuthorizedUser();
//        userService.addHouseToListHousesTenant(house,user);
//        model.addAttribute("rentAHouse",house);
//        model.addAttribute("tenant",user);
//        return "rent";
//    }
//
//}
