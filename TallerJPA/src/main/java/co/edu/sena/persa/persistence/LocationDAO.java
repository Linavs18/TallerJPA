/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.persa.persistence;

import co.edu.sena.persa.model.Location;
import java.util.List;
import javax.persistence.Query;

/**
 * fecha: 24/04/2025
 * @author Lina Vanessa Salcedo Cuellar
 * descripcion: Implementar DAO para modelo de Location
 */
public class LocationDAO implements ILocationDAO{

    @Override
    public void insert(Location location) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().persist(location);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void update(Location location) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().merge(location);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void delete(Location location) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().remove(location);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public Location findById(Long id) throws Exception {
        try {
            return EntityManagerHelper.getEntityManager().find(Location.class, id);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public List<Location> findAll() throws Exception {
        try {
            Query query = EntityManagerHelper.getEntityManager().createNamedQuery("Location.findAll");
            return query.getResultList();
        } catch (RuntimeException e) {
            throw e;
        }
    }
    
}
