/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntv.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author inmac
 */
@Entity
@Table(name = "Expense")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Expense.findAll", query = "SELECT e FROM Expense e"),
    @NamedQuery(name = "Expense.findById", query = "SELECT e FROM Expense e WHERE e.id = :id"),
    @NamedQuery(name = "Expense.findByExpenseDate", query = "SELECT e FROM Expense e WHERE e.expenseDate = :expenseDate"),
    @NamedQuery(name = "Expense.findByExpenseCost", query = "SELECT e FROM Expense e WHERE e.expenseCost = :expenseCost"),
    @NamedQuery(name = "Expense.findByNoteDate", query = "SELECT e FROM Expense e WHERE e.noteDate = :noteDate"),
    @NamedQuery(name = "Expense.findByNote", query = "SELECT e FROM Expense e WHERE e.note = :note")})
public class Expense implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ExpenseDate")
    @Temporal(TemporalType.DATE)
    private Date expenseDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ExpenseCost")
    private long expenseCost;
    @Column(name = "NoteDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date noteDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Note")
    private String note;
    @JoinColumn(name = "ExpenseItem", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private ExpenseItem expenseItem;
    @JoinColumn(name = "UserId", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Users userId;

    public Expense() {
    }

    public Expense(Integer id) {
        this.id = id;
    }

    public Expense(Integer id, Date expenseDate, long expenseCost, String note) {
        this.id = id;
        this.expenseDate = expenseDate;
        this.expenseCost = expenseCost;
        this.note = note;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(Date expenseDate) {
        this.expenseDate = expenseDate;
    }

    public long getExpenseCost() {
        return expenseCost;
    }

    public void setExpenseCost(long expenseCost) {
        this.expenseCost = expenseCost;
    }

    public Date getNoteDate() {
        return noteDate;
    }

    public void setNoteDate(Date noteDate) {
        this.noteDate = noteDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public ExpenseItem getExpenseItem() {
        return expenseItem;
    }

    public void setExpenseItem(ExpenseItem expenseItem) {
        this.expenseItem = expenseItem;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
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
        if (!(object instanceof Expense)) {
            return false;
        }
        Expense other = (Expense) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ntv.pojo.Expense[ id=" + id + " ]";
    }
    
}
