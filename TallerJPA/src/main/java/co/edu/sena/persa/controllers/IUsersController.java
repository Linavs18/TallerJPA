/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.persa.controllers;

import co.edu.sena.persa.model.Users;
import java.util.List;

/**
 * Fecha: 24/04/2025
 * @author Lina Vanessa Salcedo
 * Objetivo: Interface para el Users
 */
public interface IUsersController {
    public void insert(Users users) throws Exception;
    public void update(Users users) throws Exception;
    public void delete(Long id) throws Exception;
    public List<Users> findAll() throws Exception;
    public Users findById(Long id) throws Exception;
}
