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
    @ManagedProperty(value="#{param.view}")
    private int view;
    @ManagedProperty(value="#{param.edit}")
    private int edit;
    /** Creates a new instance of StudentDetails */
    public StudentDetails() {}

    public int getEdit() {
        return edit;
    }

    public void setEdit(int edit) {
        this.edit = edit;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public UserManager getUserManager() {
        return userManager;
    }

    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }

    public int getStudentId() {
        if (view != 0)
            this.studentId = view;
        if (edit != 0)
            this.studentId = edit;
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
