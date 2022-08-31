/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntv.repository;

import com.ntv.pojo.IncomeSource;
import java.util.List;

/**
 *
 * @author inmac
 */
public interface IncomeItemRepository {
    List<IncomeSource> getSourceItem();
    IncomeSource getSourceById(int inId);
}
