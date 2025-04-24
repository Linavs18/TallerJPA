/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.persa.controllers;

import co.edu.sena.persa.model.Users;
import co.edu.sena.persa.persistence.DAOFactory;
import co.edu.sena.persa.persistence.EntityManagerHelper;
import java.util.List;

/**
 *Fecha: 24/04/2025
 * @author Lina Vanessa Salcedo 
 * Objetivo: Implimentar la interface para controlar el modelo de Users
 */
public class UsersController implements IUsersController{

    @Override
    public void insert(Users users) throws Exception {
        if(users == null)
        {
            throw new Exception("El usuario es nulo");
        }
        
        if("".equals(users.getFullname()))
        {
            throw new Exception("El nombre es obligatorio");
        }
        
        if("".equals(users.getEmail()))
        {
            throw new Exception("El correo es obligatorio");
        }
        
        if("".equals(users.getPassword()))
        {
            throw new Exception("La contraseña es obligatorio");
        }
         
        if("".equals(users.getStatus()))
        {
            throw new Exception("El estado es obligatorio");
        }
        
        //FK
        if(users.getRoleId() == null)
        {
            throw new Exception("El tipo de rol es obligatoria");
        }
        
        //insertar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getUsersDAO().insert(users);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void update(Users users) throws Exception {
        if(users == null)
        {
            throw new Exception("El usuario es nulo");
        }
        
        if(users.getId() == 0)
        {
            throw new Exception("El id es obligatoria");
        }
        
        if("".equals(users.getFullname()))
        {
            throw new Exception("El nombre es obligatorio");
        }
        
        if("".equals(users.getEmail()))
        {
            throw new Exception("El correo es obligatorio");
        }
        
        if("".equals(users.getPassword()))
        {
            throw new Exception("La contraseña es obligatorio");
        }
         
        if("".equals(users.getStatus()))
        {
            throw new Exception("El estado es obligatorio");
        }
        
        //FK
        if(users.getRoleId() == null)
        {
            throw new Exception("El tipo de rol es obligatoria");
        }
        
        
        Users usersExists = DAOFactory.getUsersDAO().findById(users.getId());
        if (usersExists != null) 
        {
            throw new Exception("No existe el usuario");
        }
        
        //Merge
        usersExists.setFullname(users.getFullname());
        usersExists.setEmail(users.getEmail());
        usersExists.setPassword(users.getPassword());
        usersExists.setStatus(users.getStatus());
        usersExists.setRoleId(users.getRoleId());
        EntityManagerHelper.beginTransaction();
        DAOFactory.getUsersDAO().update(usersExists);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        
        
    }

    @Override
    public void delete(Long id) throws Exception {
        if(id== 0)
        {
            throw new Exception("El id es obligatorio");
        }
        
        Users userExists = DAOFactory.getUsersDAO().findById(id);
        if (userExists == null) 
        {
            throw new Exception("No existe el Usuario");
        }
        
        //Eliminar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getUsersDAO().delete(userExists);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public List<Users> findAll() throws Exception {
        return DAOFactory.getUsersDAO().findAll();
    }

    @Override
    public Users findById(Long id) throws Exception {
        if(id == 0)
        {
            throw new Exception("El id es obligatoria");
        }
        
        return DAOFactory.getUsersDAO().findById(id);
    }

    
}
