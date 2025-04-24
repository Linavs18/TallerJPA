/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.persa.controllers;

import co.edu.sena.persa.model.Location;
import java.util.List;

/**
 *Fecha: 24/04/2025
 * @author Sebastian Rodriguez
 * Objetivo: Interface para el modelo Location.
 */
public interface ILocationController {
    public void insert(Location location) throws Exception;
    public void update(Location location) throws Exception;
    public void delete(Long id) throws Exception;
    public List<Location> findAll() throws Exception;
    public Location findById(Long id) throws Exception;
}
