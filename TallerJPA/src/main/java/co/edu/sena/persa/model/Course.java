/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.persa.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author alejo
 */
@Entity
@Table(name = "course")
@NamedQueries({
    @NamedQuery(name = "Course.findAll", query = "SELECT c FROM Course c"),
    @NamedQuery(name = "Course.findById", query = "SELECT c FROM Course c WHERE c.id = :id"),
    @NamedQuery(name = "Course.findByShift", query = "SELECT c FROM Course c WHERE c.shift = :shift"),
    @NamedQuery(name = "Course.findByTrimester", query = "SELECT c FROM Course c WHERE c.trimester = :trimester"),
    @NamedQuery(name = "Course.findByYear", query = "SELECT c FROM Course c WHERE c.year = :year"),
    @NamedQuery(name = "Course.findByStatus", query = "SELECT c FROM Course c WHERE c.status = :status")})
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "shift")
    private String shift;
    @Basic(optional = false)
    @Column(name = "trimester")
    private String trimester;
    @Basic(optional = false)
    @Column(name = "year")
    private int year;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @JoinTable(name = "instructor_course", joinColumns = {
        @JoinColumn(name = "course_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "instructor_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Users> usersCollection;
    @JoinTable(name = "apprentice_course", joinColumns = {
        @JoinColumn(name = "course_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "user_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Users> usersCollection1;
    @JoinColumn(name = "career_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Career careerId;

    public Course() {
    }

    public Course(Long id) {
        this.id = id;
    }

    public Course(Long id, String shift, String trimester, int year, String status) {
        this.id = id;
        this.shift = shift;
        this.trimester = trimester;
        this.year = year;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public String getTrimester() {
        return trimester;
    }

    public void setTrimester(String trimester) {
        this.trimester = trimester;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Collection<Users> getUsersCollection() {
        return usersCollection;
    }

    public void setUsersCollection(Collection<Users> usersCollection) {
        this.usersCollection = usersCollection;
    }

    public Collection<Users> getUsersCollection1() {
        return usersCollection1;
    }

    public void setUsersCollection1(Collection<Users> usersCollection1) {
        this.usersCollection1 = usersCollection1;
    }

    public Career getCareerId() {
        return careerId;
    }

    public void setCareerId(Career careerId) {
        this.careerId = careerId;
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
        if (!(object instanceof Course)) {
            return false;
        }
        Course other = (Course) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.persa.model.Course[ id=" + id + " ]";
    }
    
}
