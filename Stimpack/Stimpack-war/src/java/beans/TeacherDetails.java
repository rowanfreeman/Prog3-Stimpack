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
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Josh
 */
@ManagedBean
@RequestScoped
public class TeacherDetails {

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

		Teacher teacher = teacherFacade.find(teacherId);
		if (teacher != null) {
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
