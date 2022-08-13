/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntv.repository;

import com.ntv.pojo.Users;
import java.util.List;

/**
 *
 * @author inmac
 */
public interface UserRepository {
    boolean addUser(Users user);
    List<Users> getUsers(String name);
}
