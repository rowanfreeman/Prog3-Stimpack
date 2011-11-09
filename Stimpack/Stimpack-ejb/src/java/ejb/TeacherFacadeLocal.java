/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Rowan
 */
@Local
public interface TeacherFacadeLocal {

    void create(Teacher teacher);

    void edit(Teacher teacher);

    void remove(Teacher teacher);

    Teacher find(Object id);

    List<Teacher> findAll();

    List<Teacher> findRange(int[] range);

    int count();

    Teacher findByUsername(String username);
    
}
