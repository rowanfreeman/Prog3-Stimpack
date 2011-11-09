package ejb;

import ejb.Subject;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.2.0.v20110202-r8913", date="2011-11-09T15:10:54")
@StaticMetamodel(Teacher.class)
public class Teacher_ { 

    public static volatile SingularAttribute<Teacher, String> username;
    public static volatile SingularAttribute<Teacher, Integer> phone;
    public static volatile SingularAttribute<Teacher, String> email;
    public static volatile SingularAttribute<Teacher, Short> age;
    public static volatile SingularAttribute<Teacher, String> lastname;
    public static volatile SingularAttribute<Teacher, String> firstname;
    public static volatile SingularAttribute<Teacher, String> password;
    public static volatile SingularAttribute<Teacher, Integer> teacherId;
    public static volatile CollectionAttribute<Teacher, Subject> subjectCollection;

}