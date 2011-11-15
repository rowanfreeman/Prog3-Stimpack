/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import ejb.Teacher;
import ejb.TeacherFacadeLocal;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 * Provides form handling for Teacher-related forms.
 */
@ManagedBean
@RequestScoped
public class TeacherManager {

	Teacher teacher;
	@EJB
	private TeacherFacadeLocal teacherFacade;
	@ManagedProperty(value = "#{teacherDetails}")
	private TeacherDetails teacherDetails;
	@ManagedProperty(value = "#{userManager}")
	private UserManager userManager;
	private boolean deleted;

	/** Creates a new instance of StudentManager */
	public TeacherManager() {
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

	public Teacher getTeacher() {
		if (this.teacher == null) {
			return this.teacher = new Teacher();
		}
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public TeacherDetails getTeacherDetails() {
		return teacherDetails;
	}

	public void setTeacherDetails(TeacherDetails teacherDetails) {
		this.teacherDetails = teacherDetails;
	}

	public void edit() {
		teacherFacade.edit(teacherDetails.getTeacher());
		teacherDetails.setEdited(true);
	}

	public void add() {
		teacherFacade.create(this.teacher);
		try {
			FacesContext.getCurrentInstance().getExternalContext().dispatch("teacherList.xhtml?add=" + teacher.getTeacherId());
		} catch (IOException ex) {
			Logger.getLogger(TeacherManager.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void delete(int teacherId) {
		this.deleted = true;
	}
}
