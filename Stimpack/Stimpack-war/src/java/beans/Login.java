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
public class Login {

    private String username;
    private String password;
    private String method;
    private String error;
    @ManagedProperty(value = "#{userManager}")
    private UserManager userManager;
    @EJB
    private StudentFacadeLocal studentFacade;

    public Login() {
    }

    public UserManager getUserManager() {
        return userManager;
    }

    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String  getError() {
        return error;
    }

    public void setError(String  error) {
        this.error = error;
    }

    public void login() {
        Student student = studentFacade.findByUsername(username);
        if (student == null) {
            error = "unknown";
        } else if (!password.equals(student.getPassword())) {
            error = "badpwd";
        } else {
            userManager.setStudent(student);
        }
    }
}
