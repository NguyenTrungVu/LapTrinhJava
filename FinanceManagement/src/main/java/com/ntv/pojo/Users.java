/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntv.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author inmac
 */
@Entity
@Table(name = "Users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "Users.findById", query = "SELECT u FROM Users u WHERE u.id = :id"),
    @NamedQuery(name = "Users.findByFullName", query = "SELECT u FROM Users u WHERE u.fullName = :fullName"),
    @NamedQuery(name = "Users.findByEmail", query = "SELECT u FROM Users u WHERE u.email = :email"),
    @NamedQuery(name = "Users.findByMobileNumber", query = "SELECT u FROM Users u WHERE u.mobileNumber = :mobileNumber"),
    @NamedQuery(name = "Users.findByPassword", query = "SELECT u FROM Users u WHERE u.password = :password"),
    @NamedQuery(name = "Users.findByRegDate", query = "SELECT u FROM Users u WHERE u.regDate = :regDate"),
    @NamedQuery(name = "Users.findByUserRole", query = "SELECT u FROM Users u WHERE u.userRole = :userRole")})
public class Users implements Serializable {
    public static final String LEADER = "ROLE_LEADER";
    public static final String ADMIN = "ROLE_ADMIN";
    public static final String MEMBER = "ROLE_MEMBER";

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 150)
    @Column(name = "FullName")
    private String fullName;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 200)
    @Column(name = "Email")
    private String email;
    @Size(max = 10)
    @Column(name = "MobileNumber")
    private String mobileNumber;
    @Size(max = 200)
    @Column(name = "Password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RegDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date regDate;
    @Size(max = 20)
    @Column(name = "UserRole")
    private String userRole;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Set<Expense> expenseSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Set<Income> incomeSet;
    @Size(max = 100)
    @Column(name = "Avatar")
    private String avatar;
    @Transient
    private MultipartFile file;
    @Transient
    private String comfirmPassword;
    

    public Users() {
    }

    public Users(Integer id) {
        this.id = id;
    }

    public Users(Integer id, Date regDate) {
        this.id = id;
        this.regDate = regDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    @XmlTransient
    public Set<Expense> getExpenseSet() {
        return expenseSet;
    }

    public void setExpenseSet(Set<Expense> expenseSet) {
        this.expenseSet = expenseSet;
    }

    @XmlTransient
    public Set<Income> getIncomeSet() {
        return incomeSet;
    }

    public void setIncomeSet(Set<Income> incomeSet) {
        this.incomeSet = incomeSet;
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
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ntv.pojo.Users[ id=" + id + " ]";
    }

    /**
     * @return the avatar
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * @param avatar the avatar to set
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * @return the file
     */
    public MultipartFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(MultipartFile file) {
        this.file = file;
    }

    /**
     * @return the comfirmPassword
     */
    public String getComfirmPassword() {
        return comfirmPassword;
    }

    /**
     * @param comfirmPassword the comfirmPassword to set
     */
    public void setComfirmPassword(String comfirmPassword) {
        this.comfirmPassword = comfirmPassword;
    }
    
}
