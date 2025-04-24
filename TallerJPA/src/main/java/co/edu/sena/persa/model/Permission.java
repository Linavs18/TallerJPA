/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.persa.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "permission")
@NamedQueries({
    @NamedQuery(name = "Permission.findAll", query = "SELECT p FROM Permission p"),
    @NamedQuery(name = "Permission.findById", query = "SELECT p FROM Permission p WHERE p.id = :id"),
    @NamedQuery(name = "Permission.findByPermissionDate", query = "SELECT p FROM Permission p WHERE p.permissionDate = :permissionDate"),
    @NamedQuery(name = "Permission.findByStartTime", query = "SELECT p FROM Permission p WHERE p.startTime = :startTime"),
    @NamedQuery(name = "Permission.findByEndTime", query = "SELECT p FROM Permission p WHERE p.endTime = :endTime"),
    @NamedQuery(name = "Permission.findByDepartureTime", query = "SELECT p FROM Permission p WHERE p.departureTime = :departureTime"),
    @NamedQuery(name = "Permission.findByReasons", query = "SELECT p FROM Permission p WHERE p.reasons = :reasons"),
    @NamedQuery(name = "Permission.findByStatus", query = "SELECT p FROM Permission p WHERE p.status = :status")})
public class Permission implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "permission_date")
    @Temporal(TemporalType.DATE)
    private Date permissionDate;
    @Basic(optional = false)
    @Column(name = "start_time")
    @Temporal(TemporalType.TIME)
    private Date startTime;
    @Basic(optional = false)
    @Column(name = "end_time")
    @Temporal(TemporalType.TIME)
    private Date endTime;
    @Column(name = "departure_time")
    @Temporal(TemporalType.TIME)
    private Date departureTime;
    @Basic(optional = false)
    @Column(name = "reasons")
    private String reasons;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Location locationId;
    @JoinColumn(name = "permission_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PermissionType permissionTypeId;
    @JoinColumn(name = "instructor_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Users instructorId;
    @JoinColumn(name = "guard_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Users guardId;

    public Permission() {
    }

    public Permission(Long id) {
        this.id = id;
    }

    public Permission(Long id, Date permissionDate, Date startTime, Date endTime, String reasons, String status) {
        this.id = id;
        this.permissionDate = permissionDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.reasons = reasons;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getPermissionDate() {
        return permissionDate;
    }

    public void setPermissionDate(Date permissionDate) {
        this.permissionDate = permissionDate;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public String getReasons() {
        return reasons;
    }

    public void setReasons(String reasons) {
        this.reasons = reasons;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Location getLocationId() {
        return locationId;
    }

    public void setLocationId(Location locationId) {
        this.locationId = locationId;
    }

    public PermissionType getPermissionTypeId() {
        return permissionTypeId;
    }

    public void setPermissionTypeId(PermissionType permissionTypeId) {
        this.permissionTypeId = permissionTypeId;
    }

    public Users getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(Users instructorId) {
        this.instructorId = instructorId;
    }

    public Users getGuardId() {
        return guardId;
    }

    public void setGuardId(Users guardId) {
        this.guardId = guardId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Permission)) {
            return false;
        }
        Permission other = (Permission) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.persa.model.Permission[ id=" + id + " ]";
    }
    
}
