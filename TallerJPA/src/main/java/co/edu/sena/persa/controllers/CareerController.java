/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.persa.controllers;

import co.edu.sena.persa.model.Career;
import co.edu.sena.persa.persistence.DAOFactory;
import co.edu.sena.persa.persistence.EntityManagerHelper;
import java.util.List;

/**
 * Fecha: 24/04/2025
 * @author Juan Sebastian Rodriguez Cruz
 * Objetivo: Implementar la interface para controlar el modelo Career.
 */
public class CareerController implements ICareerController{

    @Override
    public void insert(Career career) throws Exception {
        if(career == null)
        {
            throw new Exception("La carrera es nula");
        }
        
        if("".equals(career.getName()))
        {
            throw new Exception("El nombre es obligatorio");
        }
        
        if("".equals(career.getType()))
        {
            throw new Exception("El tipo de carrera es obligatorio");
        }
        
        //Insertar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getCareerDAO().insert(career);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void update(Career career) throws Exception {
        if(career == null)
        {
            throw new Exception("La carrera es nula");
        }
        
        if(career.getId()== 0)
        {
            throw new Exception("El id es obligatorio");
        }
        
        if("".equals(career.getName()))
        {
            throw new Exception("El nombre es obligatorio");
        }
        
        if("".equals(career.getType()))
        {
            throw new Exception("El tipo de carrera es obligatorio");
        }
        
        //Consultar si la carrera existe en la bd.
        Career careerExists = DAOFactory.getCareerDAO().findById(career.getId());
        if(careerExists == null)
        {
            throw new Exception("La carrera no existe");
        }
        
        //Merge:
        careerExists.setId(career.getId());
        careerExists.setName(career.getName());
        careerExists.setType(career.getType());
        
        //Actualizar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getCareerDAO().update(career);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public  List<Career> findAll() throws Exception {
        return DAOFactory.getCareerDAO().findAll();
    }

    @Override
    public void delete(Long id) throws Exception {
        if(id == 0)
        {
            throw  new Exception("El Id es obligatorio");
        }
        
        //Consultar si el key existe en la bd.
        Career careerExists = DAOFactory.getCareerDAO().findById(id);
        if(careerExists == null)
        {
            throw new Exception("La carrera no existe");
        }
        EntityManagerHelper.beginTransaction();
        DAOFactory.getCareerDAO().delete(careerExists);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public Career findById(Long id) throws Exception {
        if(id == 0)
        {
            throw  new Exception("El Id es obligatorio");
        }
        return DAOFactory.getCareerDAO().findById(id);
    }
    
}
