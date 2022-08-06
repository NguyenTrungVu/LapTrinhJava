/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntv.pojo;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author inmac
 */
@Entity
@Table(name = "ExpenseItem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ExpenseItem.findAll", query = "SELECT e FROM ExpenseItem e"),
    @NamedQuery(name = "ExpenseItem.findById", query = "SELECT e FROM ExpenseItem e WHERE e.id = :id"),
    @NamedQuery(name = "ExpenseItem.findByItemName", query = "SELECT e FROM ExpenseItem e WHERE e.itemName = :itemName")})
public class ExpenseItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 50)
    @Column(name = "ItemName")
    private String itemName;
    @OneToMany(mappedBy = "expenseItem")
    private Set<Expense> expenseSet;

    public ExpenseItem() {
    }

    public ExpenseItem(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @XmlTransient
    public Set<Expense> getExpenseSet() {
        return expenseSet;
    }

    public void setExpenseSet(Set<Expense> expenseSet) {
        this.expenseSet = expenseSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExpenseItem)) {
            return false;
        }
        ExpenseItem other = (ExpenseItem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ntv.pojo.ExpenseItem[ id=" + id + " ]";
    }
    
}
