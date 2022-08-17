/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntv.controllers;

import com.ntv.pojo.Users;
import com.ntv.service.UserService;
import com.ntv.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author inmac
 */
@Controller
public class UserController {
    
    @Autowired
    private UserService userDetailService; 
    
    @RequestMapping(value= "/login")
    public String login(){
        return "login";
    }
    
    @GetMapping("/register")
    public String registerView(Model model){
        model.addAttribute("user", new Users());
        return "register";
    }
    
    @PostMapping("/register")
    public String register(Model model, @ModelAttribute(value="user") Users user){
        if(user.getPassword().isEmpty()|| !user.getPassword().equals(user.getComfirmPassword()))
            model.addAttribute("errMsg", "Mat khau khong khop!!");
        else{
            if(this.userDetailService.addUser(user) == true){
                return "redirect:/login";
            }
            model.addAttribute("errMsg", "Co loi xay ra, vui long quay lai sau!!");
        }
        return "register";
    }
    
}
