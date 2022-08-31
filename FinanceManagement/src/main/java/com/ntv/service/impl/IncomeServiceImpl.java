/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntv.service.impl;

import com.ntv.pojo.Income;

import com.ntv.repository.IncomeRepository;
import com.ntv.repository.UserRepository;
import com.ntv.service.IncomeService;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * r
 *
 * @author inmac
 */
@Service
public class IncomeServiceImpl implements IncomeService {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Autowired
    private Environment env;
    @Autowired
    private IncomeRepository incomeRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Income> getIncome(Map<String, String> params, int page, int size) {
        return this.incomeRepository.getIncome(params, page, size);
    }

    @Override
    public boolean deleteIncomeBill(int id) {
        return this.incomeRepository.deleteIncomeBill(id);
    }

    @Override
    public Income getIncomeById(int incomeId) {
        return this.incomeRepository.getIncomeById(incomeId);
    }

    @Override
    public boolean addIncome(Income i) {
        long cost = i.getIncomeCost();
        i.setIncomeCost(cost);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        i.setUserId(this.userRepository.getUsers(authentication.getName()));
        i.setIncomeDate(new Date());
        i.setNoteDate(new Date());

        return this.incomeRepository.addIncome(i);
    }

    @Override
    public long countIncome() {
        return this.incomeRepository.countIncome();
    }

}
