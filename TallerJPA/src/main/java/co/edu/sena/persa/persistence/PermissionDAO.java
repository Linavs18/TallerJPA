/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.persa.persistence;

import co.edu.sena.persa.model.Permission;
import java.util.List;
import javax.persistence.Query;

/**
 * fecha: 24/04/2025
 * @author Lina Vanessa Salcedo Cuellar
 * descripcion: Implementar DAO para modelo de Permission
 */
public class PermissionDAO implements IPermissionDAO{

    @Override
    public void insert(Permission permission) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().persist(permission);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void update(Permission permission) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().merge(permission);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void delete(Permission permission) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().remove(permission);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public Permission findById(Long id) throws Exception {
        try {
            return EntityManagerHelper.getEntityManager().find(Permission.class, id);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public List<Permission> findAll() throws Exception {
        try {
            Query query = EntityManagerHelper.getEntityManager().createNamedQuery("Permission.findAll");
            return query.getResultList();
        } catch (RuntimeException e) {
            throw e;
        }
    }
    
}
