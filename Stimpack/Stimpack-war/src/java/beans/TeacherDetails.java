/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import ejb.Teacher;
import ejb.TeacherFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Josh
 */
@ManagedBean
@RequestScoped
public class TeacherDetails {

	private Teacher teacher;
	@EJB
	private TeacherFacadeLocal teacherFacade;
	private boolean deleted;

	/** Creates a new instance of TeacherDetails */
	public TeacherDetails() {
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Integer getTeacherId() {
		return Integer.parseInt(
						FacesContext.getCurrentInstance().
						getExternalContext().
						getRequestParameterMap().
						get("teacherId"));
	}

	public Object add() {
		return "teacherList";
	}

	public Object delete() {
		Integer teacherId = getTeacherId();

		this.teacher = teacherFacade.find(teacherId);
		if (this.teacher != null) {
			teacherFacade.remove(teacher);
		} else {
			throw new RuntimeException("diddly fiddle: " + teacherId);
		}
		this.deleted = true;
		return "teacherList";
	}

	public List<Teacher> getAllTeachers() {
		return teacherFacade.findAll();
	}
}
