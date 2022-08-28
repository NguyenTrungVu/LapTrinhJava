/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntv.service.impl;

import com.ntv.pojo.ExpenseItem;
import com.ntv.repository.ExStatsRepository;
import com.ntv.service.ExStatsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author inmac
 */
@Service
public class ExStatsServiceImpl implements ExStatsService{
    @Autowired
    private ExStatsRepository exStatsRepository;

    @Override
    public List<Object[]> exStats() {
        return this.exStatsRepository.exStats();
    }

    @Override
    public List<Object[]> expenseStats( ExpenseItem e,int month, int year) {
        return this.exStatsRepository.expenseStats(e, month,  year);
    }
}
