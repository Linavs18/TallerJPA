/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.persa.persistence;

import co.edu.sena.persa.model.Course;
import java.util.List;

/**
 * Fecha: 24/04/25
 * @author Lina Vanessa Salcedo Cuellar
 * Descripcion: Interface para DAO de Course
 */
public interface ICourseDAO {
    public void insert(Course course) throws Exception;
    public void update(Course course) throws Exception;
    public void delete(Course course) throws Exception;
    public Course findById(Long id) throws Exception;
    public List<Course> findAll() throws Exception;
}
