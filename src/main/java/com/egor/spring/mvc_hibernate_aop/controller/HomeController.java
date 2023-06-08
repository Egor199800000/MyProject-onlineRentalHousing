package com.egor.spring.mvc_hibernate_aop.controller;

import com.egor.spring.mvc_hibernate_aop.entity.House;
import com.egor.spring.mvc_hibernate_aop.entity.User;
import com.egor.spring.mvc_hibernate_aop.service.HouseService;
import com.egor.spring.mvc_hibernate_aop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


//TODO: что еще реализовать: SearchController, обработка исключений в JSON формате, попробовать реализовать aop-разделение рабочего функционала от бизнес логики

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private HouseService houseService;

    @Autowired
    private UserService userService;

//    @RequestMapping("/")
//    public void showAuthorizedUser(Model model){
//        User user=userService.getAuthorizedUser();
//        model.addAttribute("authUserIcon",user);
//    }

    @RequestMapping("/")
    public String showAllHouses(Model model){
      User user=userService.getAuthorizedUser();
      model.addAttribute("authUser",user);
      //model.addAttribute("authUserName",user.getName());
        List<House> allHouses=houseService.getAllHouses();
        model.addAttribute("allHouses",allHouses);
        return "all-houses";
    }


    @RequestMapping("/showDetails")
    public String houseInfo(@RequestParam("houseId") int id, Model model){
//вбю-house-info; аттрибут- "houseDescr"
        House house=houseService.getHouse(id);
        //model.addAttribute("id", id);
        model.addAttribute("houseDescr",house);
        return "house-info";
//<form:form action="showDetails" modelAttribute="houseDescr">
    }

    @RequestMapping("/homePage")
    public String homePage(){
        return "redirect:/";
    }


//вывод имени авторизованного юзера
    @RequestMapping("profileUser") //-action
    public String profileButton( @ModelAttribute("authUser") User user){
        return "profile";
    }

//профиль юзера
    @RequestMapping("/profile")
    public String profile( @ModelAttribute("authUser") User user,Model model){
        User user1=userService.getAuthorizedUser();
        model.addAttribute("authUser",user1);
        return "profile";
    }

    @RequestMapping("/logOut")
    public String logOut(){
        User user=userService.getAuthorizedUser();
        if (user==null){
            return "redirect:/";
        }
        user.setAuthorized(false);
        userService.saveUser(user);
        return "redirect:/";
    }




//    @GetMapping("logOut/{id}")
//    public String logOut(@PathVariable("id") int id,
//                         RedirectAttributes redirectAttributes){
//        User user=userService.getUser(id);
//        user.setAuthorized(false);
//        redirectAttributes.addAttribute("authUser",user.getName());
//        userService.saveUser(user);
//        return "redirect:/";
//    }





}
