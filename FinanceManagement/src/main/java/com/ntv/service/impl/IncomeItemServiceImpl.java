/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntv.service.impl;

import com.ntv.pojo.ExpenseItem;
import com.ntv.pojo.IncomeSource;
import com.ntv.repository.IncomeItemRepository;
import com.ntv.service.IncomeItemService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author inmac
 */
@Service
public class IncomeItemServiceImpl implements IncomeItemService{
    @Autowired
    private IncomeItemRepository incomeItemRepository ;
    

    @Override
    public List<IncomeSource> getSourceItem() {
        return this.incomeItemRepository.getSourceItem();
    }

    @Override
    public IncomeSource getSourceById(int i) {
        return this.incomeItemRepository.getSourceById(i);
    }
    
}
