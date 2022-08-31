/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntv.formatters;

import com.ntv.pojo.IncomeSource;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author inmac
 */
public class IncomeItemFormatter implements Formatter<IncomeSource> {

    @Override
    public String print(IncomeSource t, Locale locale) {
        return String.valueOf(t.getId());
    }

    @Override
    public IncomeSource parse(String id, Locale locale) throws ParseException {
        IncomeSource e = new IncomeSource();
        e.setId(Integer.parseInt(id));
        return e;
    }

}
