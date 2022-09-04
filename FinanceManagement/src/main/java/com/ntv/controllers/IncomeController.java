/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntv.controllers;



import com.ntv.pojo.Income;

import com.ntv.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author inmac
 */
@Controller
public class IncomeController {
     @Autowired
    private IncomeService incomeService;

    @GetMapping("/income")
    public String register(Model model){
        model.addAttribute("income",new Income());
        return "add-income";
    }
    
    @PostMapping("/income")
    public String register(Model model, @ModelAttribute(value = "income") Income e ) {
//        if(r.hasErrors()){
//            return "add-expense";
//        }
        if(this.incomeService.addIncome(e) == true){
            model.addAttribute("errMsg", "Them khoan thu thanh cong!!");
            return "redirect:/home";

        }
        return "add-income";
    }
}
