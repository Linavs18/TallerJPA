/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.persa.persistence;

import co.edu.sena.persa.model.Roles;
import java.util.List;

/**
 * Fecha: 24/04/25
 * @author Lina Vanessa Salcedo Cuellar
 * Descripcion: Interface para DAO de Roles
 */
public interface IRolesDAO {
    public void insert(Roles roles) throws Exception;
    public void update(Roles roles) throws Exception;
    public void delete(Roles roles) throws Exception;
    public Roles findById(Long id) throws Exception;
    public List<Roles> findAll() throws Exception;
}
