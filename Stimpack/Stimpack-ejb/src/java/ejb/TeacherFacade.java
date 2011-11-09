/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

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
public class TeacherFacade extends AbstractFacade<Teacher> implements TeacherFacadeLocal {
    @PersistenceContext(unitName = "Stimpack-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public TeacherFacade() {
        super(Teacher.class);
    }

    @Override
    public Teacher findByUsername(String username) {
        TypedQuery<Teacher> createNamedQuery = em.createNamedQuery("Teacher.findByUsername", Teacher.class);
        createNamedQuery.setParameter("username", username);
        try {
            return createNamedQuery.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    
}
