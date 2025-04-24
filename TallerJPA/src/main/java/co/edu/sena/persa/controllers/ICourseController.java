/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.persa.controllers;

import co.edu.sena.persa.model.Course;
import java.util.List;

/**
 *Fecha: 24/04/2025
 * @author Sebastian Rodriguez
 * Objetivo: Interface para el modelo Course.
 */
public interface ICourseController {
    public void insert(Course course) throws Exception;
    public void update(Course course) throws Exception;
    public void delete(Long id) throws Exception;
    public List<Course> findAll() throws Exception;
    public Course findById(Long id) throws Exception;
}
