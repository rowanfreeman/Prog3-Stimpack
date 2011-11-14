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
public class StudentManager {

	Student student;
	@EJB
	private StudentFacadeLocal studentFacade;
	@ManagedProperty(value = "#{studentDetails}")
	private StudentDetails studentDetails;
	@ManagedProperty(value = "#{userManager}")
	private UserManager userManager;
	private boolean deleted;

	/** Creates a new instance of StudentManager */
	public StudentManager() {
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public UserManager getUserManager() {
		return userManager;
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	public Student getStudent() {
		if (this.student == null)
			return this.student = new Student();
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public StudentDetails getStudentDetails() {
		return studentDetails;
	}

	public void setStudentDetails(StudentDetails studentDetails) {
		this.studentDetails = studentDetails;
	}

	public void edit() {
		studentFacade.edit(studentDetails.student);
	}

	public void add() {
		studentFacade.create(this.student);
		userManager.setStudent(student);
	}
	
	public void delete(int studentId) {
		studentFacade.remove(studentFacade.findByStudentId(studentId));
		this.deleted = true;
	}
}
