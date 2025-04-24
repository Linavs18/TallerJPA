/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.persa.controllers;

import co.edu.sena.persa.model.Location;
import co.edu.sena.persa.persistence.DAOFactory;
import co.edu.sena.persa.persistence.EntityManagerHelper;
import java.util.List;

/**
 * Fecha: 24/04/2025
 * @author Juan Sebastian Rodriguez Cruz
 * Objetivo: Implementar la interface para controlar el modelo Location.
 */
public class LocationController implements ILocationController{

    @Override
    public void insert(Location location) throws Exception {
        if(location == null)
        {
            throw new Exception("La sede es nula");
        }
        
        if("".equals(location.getName()))
        {
            throw new Exception("El nombre es obligatorio");
        }
        
        if("".equals(location.getAddress()))
        {
            throw new Exception("La direccion es obligatoria");
        }
        
        //Insertar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getLocationDAO().insert(location);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void update(Location location) throws Exception {
        if(location == null)
        {
            throw new Exception("La sede es nula");
        }
        
        if(location.getId()== 0)
        {
            throw new Exception("El id es obligatorio");
        }
        
        if("".equals(location.getName()))
        {
            throw new Exception("El nombre es obligatorio");
        }
        
        if("".equals(location.getAddress()))
        {
            throw new Exception("La direccion es obligatoria");
        }
        
        //Consultar si la carrera existe en la bd.
        Location locationExists = DAOFactory.getLocationDAO().findById(location.getId());
        if(locationExists == null)
        {
            throw new Exception("La sede no existe");
        }
        
        //Merge:
        locationExists.setId(location.getId());
        locationExists.setName(location.getName());
        locationExists.setAddress(location.getAddress());
        
        //Actualizar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getLocationDAO().update(location);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void delete(Long id) throws Exception {
        if(id == 0)
        {
            throw  new Exception("El Id es obligatorio");
        }
        
        Location locationExists = DAOFactory.getLocationDAO().findById(id);
        if (locationExists == null)
        {
            throw new Exception("No existe una sede con ese id");
        }
        
        EntityManagerHelper.beginTransaction();
        DAOFactory.getLocationDAO().delete(locationExists);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public List<Location> findAll() throws Exception {
        return DAOFactory.getLocationDAO().findAll();
    }

    @Override
    public Location findById(Long id) throws Exception {
        Location locationExists = DAOFactory.getLocationDAO().findById(id);
        if (locationExists == null)
        {
            throw new Exception("No existe una sede con ese id");
        }
        return DAOFactory.getLocationDAO().findById(id);
    }
    
}
