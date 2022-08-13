/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntv.service;

import com.ntv.pojo.ExpenseItem;
import java.util.List;

/**
 *
 * @author inmac
 */
public interface ExpenseItemService {
    List<ExpenseItem> getExpenseItem();
    ExpenseItem getExpenseById(int ExpId);
}
