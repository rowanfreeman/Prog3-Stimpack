/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

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
public class StudentManager {

	@ManagedProperty(value = "#{studentDetails}")
	private StudentDetails studentDetails;

	/** Creates a new instance of StudentManager */
	public StudentManager() {
	}
	@EJB
	private StudentFacadeLocal studentFacade;

	public StudentDetails getStudentDetails() {
		return studentDetails;
	}

	public void setStudentDetails(StudentDetails studentDetails) {
		this.studentDetails = studentDetails;
	}

	public void edit() {
		studentFacade.edit(studentDetails.student);
	}
}
