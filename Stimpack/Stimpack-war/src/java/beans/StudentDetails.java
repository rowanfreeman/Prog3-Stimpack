/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import ejb.Student;
import ejb.StudentFacadeLocal;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Rowan
 */
@ManagedBean
@RequestScoped
public class StudentDetails {
    Student student;
    @EJB
    private StudentFacadeLocal studentFacade;
    private int studentId;
    @ManagedProperty(value = "#{userManager}")
    private UserManager userManager;
    /** Creates a new instance of StudentDetails */
    public StudentDetails() {}

    public UserManager getUserManager() {
        return userManager;
    }

    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }

    public int getStudentId() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        try {
            this.studentId = Integer.parseInt((String)facesContext.getExternalContext().getRequestParameterMap().get("view"));
        } catch (Exception e) {}
        if (userManager.isStudent())
            this.studentId = userManager.getStudent().getStudentId();
        return this.studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    
    public boolean exists() {
        student = studentFacade.findByStudentId(getStudentId());
        if (student != null)
            return true;
        return false;
    }
}
