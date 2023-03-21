package com.egor.spring.mvc_hibernate_aop.controller;

import com.egor.spring.mvc_hibernate_aop.entity.House;
import com.egor.spring.mvc_hibernate_aop.entity.User;
import com.egor.spring.mvc_hibernate_aop.service.HouseService;
import com.egor.spring.mvc_hibernate_aop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private HouseService houseService;

    @RequestMapping("/addNewUser") //-action
    public String addNewUser(Model model){

        User user=new User();
        model.addAttribute("user",user);
        return "user-info";
    }

    @RequestMapping("/saveNewUser")
    public String saveUser(@Valid @ModelAttribute("user") User user,
                           BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "user-info";
        }

        user.setDeleted(false);
        user.setEnable(true);
        user.setAuthorized(false);
        user.setRating(5);
        userService.saveUser(user);
        return "redirect:/";
    }




    @GetMapping("/signIn") //-кнопка
    public String signIn(Model model){
        User user=new User();
        model.addAttribute("user",user);
        return "signIn";
    }

    @PostMapping("authorized") //action
    public String authorized(@ModelAttribute("user") User user,
                             Model model){

        User user1= userService.getUserByEmail(user.getEmail());
        User user2= userService.getUserByPassword(user.getPassword());

        if (user1.getId()==user2.getId()){
            System.out.println("Users equals");
            user=userService.getUser(user1.getId());
            user.setAuthorized(true);
            userService.saveUser(user);
            model.addAttribute("user",user);
            return "success";
        }
        return "redirect:/";
    }

    @RequestMapping("/addNewHouse") //-action
    public String addNewHouse(Model model){
        House house=new House();
        User user=userService.getAuthorizedUser();
        model.addAttribute("authUser",user);
        model.addAttribute("house",house);
        return "house-param";
    }

    @PostMapping("saveNewHouse")
    public String saveHouse(@ModelAttribute("house") House house){
            User user=userService.getAuthorizedUser();
                userService.addHouseToListHousesOwner(house,user);
                System.err.println("House add");
        return "redirect:/";
    }



    @GetMapping("/ownerInfo") //-кнопка
    public String OwnerInformation(@RequestParam("houseId") int id,Model model){
//сюда должны попасть id дома который мы смотрим
        House house=houseService.getHouse(id);
        User user=house.getOwner();
        System.err.println(user.getName()+" -owner");
        model.addAttribute("owner",user);
        return "owner-information";
    }
}
