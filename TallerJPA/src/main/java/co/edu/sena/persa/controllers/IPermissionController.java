/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.persa.controllers;

import co.edu.sena.persa.model.Permission;
import java.util.List;

/**
 *Date: 24/04/2025
 * @author alejo
 * Objetive: interface para el metodo permission
 */
public interface IPermissionController {
    public void insert (Permission permission)throws Exception;
    public void update (Permission permission)throws Exception;
    public void delete (Long id)throws Exception;
    public List <Permission> findAll() throws Exception;
    public Permission findById(Long id) throws Exception;
}
