/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntv.formatters;

import com.ntv.pojo.ExpenseItem;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;


/**
 *
 * @author inmac
 */
public class ExpenseItemFormatter implements Formatter<ExpenseItem>{

    @Override
    public String print(ExpenseItem t, Locale locale) {
        return String.valueOf(t.getId());
    }

    @Override
    public ExpenseItem parse(String id, Locale locale) throws ParseException {
        ExpenseItem e = new ExpenseItem();
        e.setId(Integer.parseInt(id));
        return e;
    }
    
}
