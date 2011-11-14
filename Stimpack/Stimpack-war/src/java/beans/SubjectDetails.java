/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import ejb.Subject;
import ejb.SubjectFacadeLocal;
import ejb.Teacher;
import ejb.TeacherFacadeLocal;
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
public class SubjectDetails {

	@EJB
	private SubjectFacadeLocal subjectFacade;
	@EJB
	private TeacherFacadeLocal teacherFacade;
	@ManagedProperty(value = "#{param.view}")
	private int view;
	@ManagedProperty(value = "#{param.edit}")
	private int edit;
	
	private Subject subject;

	/** Creates a new instance of SubjectDetails */
	public SubjectDetails() {
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

	public int getSubjectId() {
		if (view > 0) {
			return view;
		}
		if (edit > 0) {
			return edit;
		}
		if (FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("subjectId") != null) {
			return Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("subjectId").toString());
		}
		return 0;
	}

	public Subject getSubject() {
		if (subject == null) {
			int subjectId = getSubjectId();
			if (subjectId > 0) {
				subject = subjectFacade.find(subjectId);
			}
		}
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public int getTeacherId() {
		return this.subject.getTeacherId().getTeacherId();
	}

	public void setTeacherId(int teacherId) {
		Teacher newTeacher = teacherFacade.find(teacherId);
		this.subject.setTeacherId(newTeacher);
	}
	
	public String edit() {
		try {
			subjectFacade.edit(subject);
			return "subjectList";
		} catch (Exception e) {
			return "subjectList"; // i'm sure there's something more appropriate to do here
		}
	}
}
