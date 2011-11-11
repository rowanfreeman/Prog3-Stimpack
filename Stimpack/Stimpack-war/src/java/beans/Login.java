/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import ejb.Administrator;
import ejb.Student;
import ejb.StudentFacadeLocal;
import ejb.Teacher;
import ejb.TeacherFacadeLocal;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import pojo.md5;

/**
 *
 * @author Rowan
 */
@ManagedBean
@RequestScoped
public class Login {
	
	private final String ERROR_UNKNOWN_USER = "Unknown user";
	private final String ERROR_BAD_PASSWORD = "Password is incorrect";
	private final String ERROR_NO_USERNAME_GIVEN = "You must enter a username";
	private String username;
	private String password;
	private String method;
	private String error;
	@ManagedProperty(value = "#{userManager}")
	private UserManager userManager;
	@EJB
	private StudentFacadeLocal studentFacade;
	@EJB
	private TeacherFacadeLocal teacherFacade;

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
		this.password = md5.md5(password);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public void login() {
		if (username.equals("")) {
			error = ERROR_NO_USERNAME_GIVEN;
		} else if (method.equals("student")) {
			studentLogin();
		} else if (method.equals("teacher")) {
			teacherLogin();
		} else if (method.equals("administrator")) {
			administratorLogin();
		}
	}

	public void studentLogin() {
		Student student = studentFacade.findByUsername(username);
		if (student == null) {
			error = ERROR_UNKNOWN_USER;
		} else if (!password.equals(student.getPassword())) {
			error = ERROR_BAD_PASSWORD;
		} else {
			userManager.setStudent(student);
		}
	}

	public void teacherLogin() {
		Teacher teacher = teacherFacade.findByUsername(username);
		if (teacher == null) {
			error = ERROR_UNKNOWN_USER;
		} else if (!password.equals(teacher.getPassword())) {
			error = ERROR_BAD_PASSWORD;
		} else {
			userManager.setTeacher(teacher);
		}
	}

	private void administratorLogin() {
		if (!username.equals("admin")) {
			error = ERROR_UNKNOWN_USER;
		} else if (!md5.md5("pass").equals(password)) {
			error = ERROR_BAD_PASSWORD;
		} else {
			userManager.setAdministrator(new Administrator());
			userManager.getAdministrator().setUsername(username);
			userManager.getAdministrator().setPassword(password);
		}
	}
}
