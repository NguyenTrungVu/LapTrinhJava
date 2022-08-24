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
@Table(name = "Income")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Income.findAll", query = "SELECT i FROM Income i"),
    @NamedQuery(name = "Income.findById", query = "SELECT i FROM Income i WHERE i.id = :id"),
    @NamedQuery(name = "Income.findByIncomeDate", query = "SELECT i FROM Income i WHERE i.incomeDate = :incomeDate"),
    @NamedQuery(name = "Income.findByIncomeCost", query = "SELECT i FROM Income i WHERE i.incomeCost = :incomeCost"),
    @NamedQuery(name = "Income.findByNoteDate", query = "SELECT i FROM Income i WHERE i.noteDate = :noteDate")})
public class Income implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "IncomeCost")
    private long incomeCost;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Column(name = "IncomeDate")
    @Temporal(TemporalType.DATE)
    private Date incomeDate;
    @Column(name = "NoteDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date noteDate;
    @JoinColumn(name = "IncomeItem", referencedColumnName = "ID")
    @ManyToOne
    private IncomeSource incomeItem;
    @JoinColumn(name = "UserId", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Users userId;

    public Income() {
    }

    public Income(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getIncomeDate() {
        return incomeDate;
    }

    public void setIncomeDate(Date incomeDate) {
        this.incomeDate = incomeDate;
    }


    public Date getNoteDate() {
        return noteDate;
    }

    public void setNoteDate(Date noteDate) {
        this.noteDate = noteDate;
    }

    public IncomeSource getIncomeItem() {
        return incomeItem;
    }

    public void setIncomeItem(IncomeSource incomeItem) {
        this.incomeItem = incomeItem;
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
        if (!(object instanceof Income)) {
            return false;
        }
        Income other = (Income) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ntv.pojo.Income[ id=" + id + " ]";
    }

    public long getIncomeCost() {
        return incomeCost;
    }

    public void setIncomeCost(long incomeCost) {
        this.incomeCost = incomeCost;
    }
    
}
