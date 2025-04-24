/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.persa.persistence;

/**
 * fecha: 24/04/2025
 * @author Lina Vanessa Salcedo Cuellar
 * descripcion: Instanciar los DAO's creados en la persistencia
 */
public class DAOFactory {
    private static ICareerDAO careerDAO = new CareerDAO();
    private static ICourseDAO courseDAO = new CourseDAO();
    private static ILocationDAO locationDAO = new LocationDAO();
    private static IPermissionDAO permissionDAO = new PermissionDAO();
    private static IPermissionTypeDAO permissionTypeDAO = new PermissionTypeDAO();
    private static IRolesDAO rolesDAO = new RolesDAO();
    private static IUsersDAO usersDAO = new UsersDAO();
    
    public static ICareerDAO getCareerDAO() {
        return careerDAO;
    }
    
    public static ICourseDAO getCourseDAO() {
        return courseDAO;
    }
    
    public static ILocationDAO getLocationDAO() {
        return locationDAO;
    }
    
    public static IPermissionDAO getPermissionDAO() {
        return permissionDAO;
    }
    
    public static IPermissionTypeDAO getPermissionTypeDAO() {
        return permissionTypeDAO;
    }
    
    public static IRolesDAO getRolesDAO() {
        return rolesDAO;
    }
    
    public static IUsersDAO getUsersDAO() {
        return usersDAO;
    }
    
}
