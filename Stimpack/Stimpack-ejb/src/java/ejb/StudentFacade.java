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
public class StudentFacade extends AbstractFacade<Student> implements StudentFacadeLocal {
    @PersistenceContext(unitName = "Stimpack-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public StudentFacade() {
        super(Student.class);
    }

    @Override
    public Student findByUsername(String username) {
        TypedQuery<Student> createNamedQuery = em.createNamedQuery("Student.findByUsername", Student.class);
        createNamedQuery.setParameter("username", username);
        try {
            return createNamedQuery.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
