/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntv.repository;

import com.ntv.pojo.Expense;
import java.util.List;
import java.util.Map;

/**
 *
 * @author inmac
 */
public interface ExpenseRepository {
    List<Expense> getExpense(Map<String, String> params, int page);
    boolean deleteExpenseBill(int id);
    Expense getExpenseById(int expenseId);
    boolean addExpense(Expense e);
}
