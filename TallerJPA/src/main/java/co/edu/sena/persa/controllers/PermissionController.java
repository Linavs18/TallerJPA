/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.persa.controllers;

import co.edu.sena.persa.model.Permission;
import co.edu.sena.persa.persistence.DAOFactory;
import co.edu.sena.persa.persistence.EntityManagerHelper;
import java.util.List;

/**
 *Date: 25/03/2025
 * @author alejo
 * Objetive: implementar la interface para controlar el modelo permission
 */
public class PermissionController implements IPermissionController{

    @Override
    public void insert(Permission permission) throws Exception {
        if (permission == null)
        {
            throw new Exception ("El permiso es nulo");
        }
        if(permission.getPermissionDate() == null)
        {
            throw new Exception("La fecha del permiso es obligatoria");
        }
        if(permission.getStartTime() == null)
        {
            throw new Exception("La hora de inicio es obligatoria");
        }
        if(permission.getEndTime()== null)
        {
            throw new Exception("La hora de finalización es obligatoria");
        }
        if(permission.getReasons()== null)
        {
            throw new Exception("La razon es obligatoria");
        }
        //FK
        if(permission.getInstructorId()== null)
        {
            throw new Exception("El id del instructor es obligatorio es obligatorio");
        }
        //FK
        if(permission.getLocationId()== null)
        {
            throw new Exception("El id de la ubicación es obligatorio");
        }
        //FK
        if(permission.getPermissionTypeId()== null)
        {
            throw new Exception("El tipo de permiso es obligatorio");
        }
        //Insert
        EntityManagerHelper.beginTransaction();
        DAOFactory.getPermissionDAO().insert(permission);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void update(Permission permission) throws Exception {
        if (permission == null)
        {
            throw new Exception ("El permiso es nulo");
        }
        if(permission.getId() == 0)
        {
            throw  new Exception("El id no puede ser 0");
        }
        if(permission.getPermissionDate() == null)
        {
            throw new Exception("La fecha del permiso es obligatoria");
        }
        if(permission.getStartTime() == null)
        {
            throw new Exception("La hora de inicio es obligatoria");
        }
        if(permission.getEndTime()== null)
        {
            throw new Exception("La hora de finalización es obligatoria");
        }
        if("".equals(permission.getReasons()))
        {
            throw new Exception("La razon es obligatoria");
        }
        //FK
        if(permission.getInstructorId()== null)
        {
            throw new Exception("El id del instructor es obligatorio es obligatorio");
        }
        //FK
        if(permission.getLocationId()== null)
        {
            throw new Exception("El id de la ubicación es obligatorio");
        }
        //FK
        if(permission.getPermissionTypeId()== null)
        {
            throw new Exception("El tipo de permiso es obligatorio");
        }
        if("".equals(permission.getStatus()))
        {
            throw new Exception("El estado es obligatorio");
        }
        //Consultar si el permiso existe en la DB
        Permission permissionExists = DAOFactory.getPermissionDAO().findById(permission.getId());
        if (permissionExists != null){
            throw new Exception("Ya existe un permiso con ese id");
        }
        
        //Merge
        permissionExists.setId(permission.getId());
        permissionExists.setDepartureTime(permission.getDepartureTime());
        permissionExists.setEndTime(permission.getEndTime());
        permissionExists.setGuardId(permission.getGuardId());
        permissionExists.setInstructorId(permission.getInstructorId());
        permissionExists.setLocationId(permission.getLocationId());
        permissionExists.setPermissionDate(permission.getPermissionDate());
        permissionExists.setPermissionTypeId(permission.getPermissionTypeId());
        permissionExists.setReasons(permission.getReasons());
        permissionExists.setStartTime(permission.getStartTime());
        permissionExists.setStatus(permission.getStatus());
        EntityManagerHelper.beginTransaction();
        DAOFactory.getPermissionDAO().update(permission);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void delete(Long id) throws Exception {
        if(id == 0){
            throw  new Exception("El id es obligatorio");
        }
        //Consultar si el permiso existe en la DB
        Permission permissionExists = DAOFactory.getPermissionDAO().findById(id);
        if (permissionExists != null){
            throw new Exception("No existe un permiso con ese id");
        } 
        
        EntityManagerHelper.beginTransaction();
        DAOFactory.getPermissionDAO().delete(permissionExists);
    }

    @Override
    public List<Permission> findAll() throws Exception {
        return DAOFactory.getPermissionDAO().findAll();
    }

    @Override
    public Permission findById(Long id) throws Exception {
        if(id == 0){
            throw new Exception("El id no puede ser 0");
        }
        return DAOFactory.getPermissionDAO().findById(id);
    }
    
}
