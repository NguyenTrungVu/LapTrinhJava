/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntv.repository.impl;

import com.ntv.pojo.ExpenseItem;
import com.ntv.repository.ExpenseItemRepository;
import java.util.List;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author inmac
 */
@Repository
@Transactional
public class ExpenseItemRepositoryImpl implements ExpenseItemRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public List<ExpenseItem> getExpenseItem() {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("From ExpenseItem");
        return q.getResultList();
        
    }
    @Override
    public ExpenseItem getExpenseById(int ExpId) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        return s.get(ExpenseItem.class, ExpId);
    }

   
    
}
