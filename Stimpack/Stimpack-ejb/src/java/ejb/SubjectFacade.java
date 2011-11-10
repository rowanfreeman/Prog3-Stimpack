/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Rowan
 */
@Stateless
public class SubjectFacade extends AbstractFacade<Subject> implements SubjectFacadeLocal {
    @PersistenceContext(unitName = "Stimpack-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public SubjectFacade() {
        super(Subject.class);
    }

    @Override
    public List<Subject> findByStudentId(int studentId) {
        TypedQuery<Subject> createNamedQuery = em.createNamedQuery("Subject.findByStudentId", Subject.class);
        createNamedQuery.setParameter("studentId", studentId);
        try {
            return createNamedQuery.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
    
    @Override
    public List<Subject> findByTeacherId(int teacherId) {
        TypedQuery<Subject> createNamedQuery = em.createNamedQuery("Subject.findByTeacherId", Subject.class);
        createNamedQuery.setParameter("teacherId", teacherId);
        try {
            return createNamedQuery.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
    
}
