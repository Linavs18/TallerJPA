/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.persa.controllers;

<<<<<<< HEAD
import co.edu.sena.persa.persistence.EntityManagerHelper;
=======
>>>>>>> origin/dev
import co.edu.sena.persa.model.Roles;
import co.edu.sena.persa.persistence.DAOFactory;
import co.edu.sena.persa.persistence.EntityManagerHelper;
import java.util.List;

/**
 * Fecha: 24/04/2025
 * @author Lina Vanessa Salcedo 
 * Objetivo: Implimentar la interface para controlar el modelo de Roles
 */
public class RolesController implements IRolesController {

    @Override
    public void insert(Roles roles) throws Exception {
        if(roles == null)
        {
            throw new Exception("El rol es nulo");
        }
        
        if("".equals(roles.getName()))
        {
            throw new Exception("El rol es obligatorio");
        }
        
        //insertar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getRolesDAO().insert(roles);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void update(Roles roles) throws Exception {
         if(roles == null)
        {
            throw new Exception("El tipo de rol es nulo");
        }
        
        if(roles.getId() == 0)
        {
            throw new Exception("El id es obligatoria");
        }
        
        if("".equals(roles.getName()))
        {
             throw new Exception("El rol es obligatoria");
        }
        
        //Consultar si existe en la bd
        Roles rolesExists = DAOFactory.getRolesDAO().findById(roles.getId());
        if(rolesExists == null)
        {
            throw new Exception("El tipo de rol no existe");
        }
        
        //merge
        rolesExists.setName(roles.getName());
        EntityManagerHelper.beginTransaction();
        DAOFactory.getRolesDAO().update(rolesExists);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void delete(Long id) throws Exception {
        if(id == 0)
        {
            throw new Exception("El id es obligatoria");
        }
        
        //Consultar si existe en la bd
        Roles rolesExists = DAOFactory.getRolesDAO().findById(id);
        if(rolesExists == null)
        {
            throw new Exception("El tipo de rol no existe");
        }
        
        //Eliminar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getRolesDAO().delete(rolesExists);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public List<Roles> findAll() throws Exception {
        return DAOFactory.getRolesDAO().findAll();
    }

    @Override
    public Roles findById(Long id) throws Exception {
         if(id == 0)
        {
            throw new Exception("El id es obligatoria");
        }
        
        return DAOFactory.getRolesDAO().findById(id);
    }
    
}
