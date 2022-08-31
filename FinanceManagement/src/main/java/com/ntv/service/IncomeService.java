/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntv.service;

import com.ntv.pojo.Income;
import java.util.List;
import java.util.Map;

/**
 *
 * @author inmac
 */
public interface IncomeService { 
    List<Income> getIncome(Map<String, String> params, int page, int size);
    boolean deleteIncomeBill(int id);
    Income getIncomeById(int incomeId);
    boolean addIncome(Income i);
    long countIncome();
    
}
