/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntv.service;

import com.ntv.pojo.Users;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author inmac
 */
public interface UserService extends UserDetailsService {

    boolean addUser(Users user);

    Users getUserByUsername(String username);
}
