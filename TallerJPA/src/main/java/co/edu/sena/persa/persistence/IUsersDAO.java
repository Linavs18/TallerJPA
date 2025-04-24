/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.persa.persistence;

import co.edu.sena.persa.model.Users;
import java.util.List;

/**
 *Fecha: 24/04/25
 * @author Lina Vanessa Salcedo Cuellar
 * Descripcion: Interface para DAO de Users
 */
public interface IUsersDAO {
    public void insert(Users users) throws Exception;
    public void update(Users users) throws Exception;
    public void delete(Users users) throws Exception;
    public Users findById(Long id) throws Exception;
    public List<Users> findAll() throws Exception;
}
