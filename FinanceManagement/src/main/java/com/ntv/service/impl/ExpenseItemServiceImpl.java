/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntv.service.impl;

import com.ntv.pojo.ExpenseItem;
import com.ntv.repository.ExpenseItemRepository;
import com.ntv.service.ExpenseItemService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author inmac
 */
@Service
public class ExpenseItemServiceImpl implements ExpenseItemService{
    @Autowired
    private ExpenseItemRepository expenseItemRepository;

    @Override
    public List<ExpenseItem> getExpenseItem() {
        return this.expenseItemRepository.getExpenseItem();
    }

    @Override
    public ExpenseItem getExpenseById(int ExpId) {
        return this.expenseItemRepository.getExpenseById(ExpId);
    }

    
}
