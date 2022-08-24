/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntv.service.impl;

import com.cloudinary.utils.ObjectUtils;
import com.ntv.pojo.Expense;
import com.ntv.pojo.Users;
import com.ntv.repository.ExpenseRepository;
import com.ntv.repository.UserRepository;
import com.ntv.service.ExpenseService;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 *
 * @author inmac
 */
@Service
public class ExpenseServiceImpl implements ExpenseService{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Autowired
    private Environment env;
    @Autowired
    private ExpenseRepository expenseRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Expense> getExpense(Map<String, String> params, int page) {
        return this.expenseRepository.getExpense(params, page);
    }

       @Override
    public boolean deleteExpenseBill(int id) {
        return this.expenseRepository.deleteExpenseBill(id);
    }

    @Override
    public Expense getExpenseById(int expenseId) {
        return this.expenseRepository.getExpenseById(expenseId);
    }

    @Override
    public boolean addExpense(Expense e) {
       
            long cost = e.getExpenseCost();
            e.setExpenseCost(cost);
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            e.setUserId(this.userRepository.getUsers(authentication.getName()));
            String note = e.getNote();
            e.setNote(note);
            e.setExpenseDate(new Date());
            e.setNoteDate(new Date());
            
            return this.expenseRepository.addExpense(e);
            
        
    }

    
    
}
