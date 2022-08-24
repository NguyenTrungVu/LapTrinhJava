/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntv.repository.impl;

import com.ntv.pojo.Expense;
import com.ntv.pojo.Users;
import com.ntv.repository.ExpenseRepository;
import com.ntv.repository.UserRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author inmac
 */
@Repository
@PropertySource("classpath:databases.properties")
@Transactional
public class ExpenseRepositoryImpl implements ExpenseRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private Environment env;

    @Override
    public List<Expense> getExpense(Map<String, String> params, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Expense> e = b.createQuery(Expense.class);
        Root root = e.from(Expense.class);
        e.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();
            String expenseId = params.get("expenseSet");
            if (expenseId != null) {
                Predicate p = b.equal(root.get("expenseSet"), Integer.parseInt(expenseId));
                predicates.add(p);
            }
            e.where(predicates.toArray(new Predicate[]{}));
        }
        e.orderBy(b.desc(root.get("id")));

        Query query = session.createQuery(e);
        if (page > 0) {
            int size = Integer.parseInt(env.getProperty("page.size").toString());
            int start = (page - 1) * size;
            query.setFirstResult(start);
            query.setMaxResults(size);

        }

        return query.getResultList();
    }

    @Override
    public boolean deleteExpenseBill(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        try {
            Expense p = session.get(Expense.class, id);
            session.delete(p);

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Expense getExpenseById(int expenseId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        return session.get(Expense.class, expenseId);
    }

    @Override
    public boolean addExpense(Expense e) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
       
       try{
           session.save(e);
           return true;
       }catch(HibernateException ex){
           System.err.println(ex.getMessage());
       }
        
        return false;
    }
}
