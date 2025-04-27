/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.persa.controllers;

import co.edu.sena.persa.model.Course;
import co.edu.sena.persa.persistence.DAOFactory;
import co.edu.sena.persa.persistence.EntityManagerHelper;
import java.util.List;

/**
 * Fecha: 24/04/2025
 * @author Juan Sebastian Rodriguez Cruz
 * Objetivo: Implementar la interface para controlar el modelo Course.
 */
public class CourseController implements ICourseController{

    @Override
    public void insert(Course course) throws Exception {
        if (course == null)
        {
            throw  new Exception("El curso es nulo");
        }
        
        if ("".equals(course.getShift()))
        {
            throw  new Exception("La jornada es obligatoria");
        }
        if ("".equals(course.getTrimester()))
        {
            throw  new Exception("El trimestre es obligatoria");
        }
        if("".equals(course.getYear()))
        {
            throw new Exception("El año es obligatorio");
        }
        if ("".equals(course.getStatus()))
        {
            throw  new Exception("El estado es obligatorio");
        }
        
        //FK's
        if(course.getCareerId()== null)
        {
            throw  new Exception("El id del empleado es obligatorio");
        }
        
        
        EntityManagerHelper.beginTransaction();
        DAOFactory.getCourseDAO().insert(course);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void update(Course course) throws Exception {
        if (course == null)
        {
            throw  new Exception("El curso es nulo");  
        }
        if(course.getId()== 0)
        {
            throw new Exception("La id es obligatorio");
        }
        
        if ("".equals(course.getShift()))
        {
            throw  new Exception("La jornada es obligatoria");
        }
        if ("".equals(course.getTrimester()))
        {
            throw  new Exception("El trimestre es obligatoria");
        }
        if("".equals(course.getYear()))
        {
            throw new Exception("El año es obligatorio");
        }
        if ("".equals(course.getStatus()))
        {
            throw  new Exception("El estado es obligatorio");
        }
   
        //FK's
        if(course.getCareerId()== null)
        {
            throw  new Exception("El id del curso es obligatorio");
        }
        
        //Consultar si la carrera existe en la bd.
        Course courseExists = DAOFactory.getCourseDAO().findById(course.getId());
        if(courseExists == null)
        {
            throw new Exception("el curso no existe");
        }
        
        //Merge:
        courseExists.setId(course.getId());
        courseExists.setShift(course.getShift());
        courseExists.setTrimester(course.getTrimester());
         courseExists.setYear(course.getYear());
        courseExists.setStatus(course.getStatus());
        courseExists.setCareerId(course.getCareerId());
        
        //Actualizar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getCourseDAO().update(course);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void delete(Long id) throws Exception {
        if(id == 0)
        {
            throw  new Exception("El Id es obligatorio");
        }
        
        Course courseExists = DAOFactory.getCourseDAO().findById(id);
        if(courseExists == null)
        {
            throw new Exception("el curso no existe");
        }
        
        EntityManagerHelper.beginTransaction();
        DAOFactory.getCourseDAO().delete(courseExists);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public List<Course> findAll() throws Exception {
        return DAOFactory.getCourseDAO().findAll();
    }

    @Override
    public Course findById(Long id) throws Exception {
        Course courseExists = DAOFactory.getCourseDAO().findById(id);
        if (courseExists == null)
        {
            throw new Exception("No existe un curso con ese id");
        }
        return DAOFactory.getCourseDAO().findById(id);
    }
}
  
