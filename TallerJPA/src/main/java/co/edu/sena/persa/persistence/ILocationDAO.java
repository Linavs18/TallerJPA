/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.persa.persistence;

import co.edu.sena.persa.model.Location;
import java.util.List;

/**
 * Fecha: 24/04/25
 * @author Lina Vanessa Salcedo Cuellar
 * Descripcion: Interface para DAO de Location
 */
public interface ILocationDAO {
    public void insert(Location location) throws Exception;
    public void update(Location location) throws Exception;
    public void delete(Location location) throws Exception;
    public Location findById(Long id) throws Exception;
    public List<Location> findAll() throws Exception;
}
