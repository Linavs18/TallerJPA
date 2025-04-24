/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.persa.persistence;

import co.edu.sena.persa.model.Course;
import java.util.List;
import javax.persistence.Query;

/**
 * fecha: 24/04/2025
 * @author Lina Vanessa Salcedo Cuellar
 * descripcion: Implementar DAO para modelo de Course
 */
public class CourseDAO implements ICourseDAO {

    @Override
    public void insert(Course course) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().persist(course);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void update(Course course) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().merge(course);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void delete(Course course) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().remove(course);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public Course findById(Long id) throws Exception {
        try {
            return EntityManagerHelper.getEntityManager().find(Course.class, id);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public List<Course> findAll() throws Exception {
        try {
            Query query = EntityManagerHelper.getEntityManager().createNamedQuery("Course.findAll");
            return query.getResultList();
        } catch (RuntimeException e) {
            throw e;
        }
    }
    
}
