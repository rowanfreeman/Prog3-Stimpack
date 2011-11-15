/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import ejb.Student;
import ejb.StudentFacadeLocal;
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
	private StudentFacadeLocal studentFacade;
	@EJB
	private SubjectFacadeLocal subjectFacade;
	@EJB
	private TeacherFacadeLocal teacherFacade;
	
	@ManagedProperty(value = "#{param.view}")
	private int view;
	@ManagedProperty(value = "#{param.edit}")
	private int edit;
	@ManagedProperty(value = "#{param.delete}")
	private int delete;
	@ManagedProperty(value = "#{param.student}")
	private int studentId;
	
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

	public int getDelete() {
		return delete;
	}

	public void setDelete(int delete) {
		this.delete = delete;
	}

	public int getSubjectId() {
		if (view > 0) {
			return view;
		}
		if (edit > 0) {
			return edit;
		}
		if (delete > 0) {
			return delete;
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

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
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
			subjectFacade.edit(getSubject());
		} catch (Exception e) {
		}

		return "subjectList";
	}

	public String delete() {
		try {
			subjectFacade.remove(getSubject());
		} catch (Exception e) {
		}

		return "subjectList";
	}
	
	public String enrol() {
		Student student = studentFacade.find(studentId);
		Subject s = getSubject();
		s.enrolStudent(student);
		subjectFacade.edit(s);
		
		return "subjectList";
	}
	
	public String unenrol() {
		Student student = studentFacade.find(studentId);
		Subject s = getSubject();
		s.unenrolStudent(student);
		subjectFacade.edit(s);
		
		return "subjectList";
	}
}
