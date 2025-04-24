/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.persa.controllers;

import co.edu.sena.persa.model.PermissionType;
import co.edu.sena.persa.persistence.DAOFactory;
import co.edu.sena.persa.persistence.EntityManagerHelper;
import java.util.List;

/**
 *Date: 24/04/2025
 * @author alejo
 * Objetive: implementar la interface para controlar el modelo permissionType
 */
public class PermissionTypeController implements IPermissionTypeController{

    @Override
    public void insert(PermissionType permissionType) throws Exception {
        if (permissionType == null)
        {
            throw new Exception("El tipo de permiso es nulo");
        }
        if ("".equals(permissionType.getName()))
        {
            throw new Exception("El tipo de permiso es nulo");
        }
        
        //insert
        EntityManagerHelper.beginTransaction();
        DAOFactory.getPermissionTypeDAO().insert(permissionType);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void update(PermissionType permissionType) throws Exception {
        if (permissionType == null)
        {
            throw new Exception("El tipo de permiso es nulo");
        }
        if ("".equals(permissionType.getName()))
        {
            throw new Exception("El tipo de permiso es nulo");
        }
        //Consultar si el tipo de permiso existe en la DB
        PermissionType permissionTypeExists = DAOFactory.getPermissionTypeDAO().findById(permissionType.getId());
        if (permissionTypeExists != null){
            throw new Exception("Ya existe un tipo de permiso con ese id");
        }
               
        //merge
        permissionTypeExists.setId(permissionType.getId());
        permissionTypeExists.setName(permissionTypeExists.getName());
        EntityManagerHelper.beginTransaction();
        DAOFactory.getPermissionTypeDAO().update(permissionType);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void delete(Long id) throws Exception {
        if(id == 0){
            throw new Exception("El id es obligatorio");
        }
        //Consultar si el tipo de permiso existe en la DB
        PermissionType permissionTypeExists = DAOFactory.getPermissionTypeDAO().findById(id);
        if(permissionTypeExists != null){
            throw new Exception("No existe un registro con ese id");
        }
        
        EntityManagerHelper.beginTransaction();
        DAOFactory.getPermissionTypeDAO().delete(permissionTypeExists);
    }

    @Override
    public List<PermissionType> findAll() throws Exception {
        return DAOFactory.getPermissionTypeDAO().findAll();
    }

    @Override
    public PermissionType findById(Long id) throws Exception {
        if(id == 0){
            throw new Exception("El id no puede ser 0");
        }
        return DAOFactory.getPermissionTypeDAO().findById(id);
    }

  
    
}
