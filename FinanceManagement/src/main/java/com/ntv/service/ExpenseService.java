/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntv.service;

import com.ntv.pojo.Expense;
import com.ntv.pojo.ExpenseItem;
import java.util.List;
import java.util.Map;

/**
 *
 * @author inmac
 */
public interface ExpenseService {
    List<Expense> getExpense(Map<String, String> params, int page, int size);
    boolean addExpense (Expense e);
    boolean deleteExpenseBill(int id);
    Expense getExpenseById(int expenseId);
    long countExpense();
}
