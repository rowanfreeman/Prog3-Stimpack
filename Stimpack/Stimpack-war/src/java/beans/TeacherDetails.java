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

	Teacher teacher;
	@EJB
	private TeacherFacadeLocal teacherFacade;
	private boolean deleted;
	private boolean edited;
	@ManagedProperty(value = "#{param.view}")
	private int view;
	@ManagedProperty(value = "#{param.edit}")
	private int edit;

	/** Creates a new instance of TeacherDetails */
	public TeacherDetails() {
	}

	public boolean isEdited() {
		return edited;
	}

	public void setEdited(boolean edited) {
		this.edited = edited;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

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

	public Teacher getTeacher() {
		if (teacher == null) {
			int teacherId = getTeacherId();
			if (teacherId > 0) {
				teacher = teacherFacade.find(teacherId);
			}
		}
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Integer getTeacherId() {
		if (view > 0) {
			return view;
		}
		if (edit > 0) {
			return edit;
		}
		if (FacesContext.getCurrentInstance().
						getExternalContext().
						getRequestParameterMap().
						get("teacherId") != null) {
			return Integer.parseInt(
							FacesContext.getCurrentInstance().
							getExternalContext().
							getRequestParameterMap().
							get("teacherId"));
		}
		return 0;
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
			throw new RuntimeException("Teacher is null: " + teacherId);
		}
		this.deleted = true;
		return "teacherList";
	}

	public List<Teacher> getAllTeachers() {
		return teacherFacade.findAll();
	}

	public boolean exists(int id) {
		return this.teacher != null;
	}
}
