/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import ejb.Subject;
import ejb.SubjectFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author Josh
 */
@ManagedBean
public class SubjectManager {
    @EJB
    private SubjectFacadeLocal subjectFacade;
    
    /** Creates a new instance of SubjectManager */
    public SubjectManager() {
    }
    
    public int getSubjectId() {
        int subjectId = 0;
        
        FacesContext facesContext = FacesContext.getCurrentInstance();
        try {
            subjectId = Integer.parseInt((String)facesContext.getExternalContext().getRequestParameterMap().get("subjectId"));
        } catch (Exception e) {}
        
        return subjectId;
    }
    
    public Subject getSubject() {
        try {
            return subjectFacade.find(getSubjectId());
        } catch (Exception e) {
            return null;
        }
    }
    
    public List<Subject> getSubjectsInScope() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        int studentId = 0, teacherId = 0;
        try {
            studentId = Integer.parseInt((String)facesContext.getExternalContext().getRequestParameterMap().get("studentId"));
        } catch (Exception e) {}
        try {
            teacherId = Integer.parseInt((String)facesContext.getExternalContext().getRequestParameterMap().get("teacherId"));
        } catch (Exception e) {}
        
        if (studentId > 0) {
            return subjectFacade.findByStudentId(studentId);
        } else if (teacherId > 0) {
            return subjectFacade.findByTeacherId(teacherId);
        } else {
            return subjectFacade.findAll();
        }
    }
    
    public List<Subject> getAllSubjects() {
        return subjectFacade.findAll();
    }
}
