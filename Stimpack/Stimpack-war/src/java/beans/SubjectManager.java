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
    
    private Subject m_subject;

    /** Creates a new instance of SubjectManager */
    public SubjectManager() {
        m_subject = subjectFacade.find(getClassId());
    }
    
    private int getClassId() {
        int subjectId = 0;
        
        FacesContext facesContext = FacesContext.getCurrentInstance();
        try {
            subjectId = Integer.parseInt((String)facesContext.getExternalContext().getRequestParameterMap().get("subject"));
        } catch (Exception e) {}
        
        return subjectId;
    }
    
    public Subject getSubject() {
        return m_subject;
    }
    
    public List<Subject> getAllSubjects() {
        return subjectFacade.findAll();
    }
}
