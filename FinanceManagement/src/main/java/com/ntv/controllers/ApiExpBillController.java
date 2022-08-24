/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntv.controllers;

import com.ntv.pojo.Expense;
import com.ntv.pojo.Users;
import com.ntv.service.ExpenseItemService;
import com.ntv.service.ExpenseService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author inmac
 */
//@RestController
//public class ApiExpBillController {
//    @Autowired
//    private ExpenseService expenseService; 
//    @PostMapping("/expense")
//    public ResponseEntity<Expense> addExpense(@RequestBody Map<String, String> params) {
//        
//        long cost = Long.parseLong(params.get("expenseCost"));
//        Expense e = this.expenseService.addExpense(cost);
//        return new ResponseEntity<>(e, HttpStatus.CREATED);
//    }
//   
//}
