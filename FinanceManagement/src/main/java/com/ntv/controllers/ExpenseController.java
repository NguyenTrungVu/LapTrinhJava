/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntv.controllers;

import com.ntv.pojo.Expense;
import com.ntv.service.ExpenseService;
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
public class ExpenseController {
     @Autowired
    private ExpenseService expenseService;

    @GetMapping("/expense")
    public String register(Model model){
        model.addAttribute("expense",new Expense());
        return "add-expense";
    }
    
    @PostMapping("/expense")
    public String register(Model model, @ModelAttribute(value = "expense") Expense e ) {
//        if(r.hasErrors()){
//            return "add-expense";
//        }
        if(this.expenseService.addExpense(e) == true){
            model.addAttribute("errMsg", "Them hoa don chi phi thanh cong!!");
            return "redirect:/";

        }
        return "add-expense";
    }
  
}
