/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntv.repository.impl;

import com.ntv.pojo.Expense;
import com.ntv.pojo.ExpenseItem;
import com.ntv.repository.ExStatsRepository;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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
public class ExStatsRepositoryImpl implements ExStatsRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public List<Object[]> exStats() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> e = b.createQuery(Object[].class);
        
        Root rE = e.from(Expense.class);
        Root rI = e.from(ExpenseItem.class);

        e.where(b.equal(rE.get("expenseItem"), rI.get("id")));
        e.multiselect(rI.get("id"), rI.get("itemName"), b.sum(rE.get("expenseCost")));
        e.groupBy(rI.get("id"));
        e = e.orderBy(b.asc(rI.get("id")));
        Query query = session.createQuery(e);
        return query.getResultList(); 
    }

    @Override
    public List<Object[]> expenseStats( int month, int quarter, int year) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root rE = q.from(Expense.class);
        Root rI = q.from(ExpenseItem.class);

        q.where(b.equal(rE.get("expenseItem"), rI.get("id")),
                b.equal(b.function("MONTH", Integer.class, rE.get("expenseDate")), month),
                b.equal(b.function("QUARTER", Integer.class, rE.get("expenseDate")), quarter),
                b.equal(b.function("YEAR", Integer.class, rE.get("expenseDate")), year));

        q.multiselect( rI.get("itemName"), rE.get("expenseDate"), rE.get("expenseCost"));
        
        Query query = session.createQuery(q);
        return query.getResultList(); 
    }
    
}
