/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntv.controllers;

import com.ntv.service.ExpenseItemService;
import com.ntv.service.ExpenseService;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author inmac
 */
@Controller
@ControllerAdvice
public class HomeController {
   
    @Autowired
    private ExpenseItemService expenseItemService;
    @Autowired
    private ExpenseService expenseService;
    
    @ModelAttribute
    public void commonAtt(Model model, HttpSession session){
        model.addAttribute("expenseitem", this.expenseItemService.getExpenseItem());
        model.addAttribute("currentUser", session.getAttribute("currentUser"));
    }
    
   
    @RequestMapping(value= "/home")
    public String home(Model model, @RequestParam Map<String, String> params){
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        model.addAttribute("expenses", this.expenseService.getExpense(params, page));
//        model.addAttribute("productCounter", this.expenseService.());
        
        return "home";
    }
}
