/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import ejb.Student;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Rowan
 */
@ManagedBean
@SessionScoped
public class UserManager {

    private Student student;

    public UserManager() {
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public boolean loggedIn() {
        if (student != null) {
            return true;
        }
        return false;
    }

    public void logout() {
        student = null;
    }
}
