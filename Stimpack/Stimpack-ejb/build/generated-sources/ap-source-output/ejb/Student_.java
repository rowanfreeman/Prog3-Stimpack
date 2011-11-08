package ejb;

import ejb.Subject;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.2.0.v20110202-r8913", date="2011-11-09T10:51:02")
@StaticMetamodel(Student.class)
public class Student_ { 

    public static volatile SingularAttribute<Student, String> username;
    public static volatile SingularAttribute<Student, Integer> phone;
    public static volatile SingularAttribute<Student, Integer> studentId;
    public static volatile SingularAttribute<Student, String> email;
    public static volatile SingularAttribute<Student, Short> age;
    public static volatile SingularAttribute<Student, String> lastname;
    public static volatile SingularAttribute<Student, String> firstname;
    public static volatile SingularAttribute<Student, String> password;
    public static volatile CollectionAttribute<Student, Subject> subjectCollection;

}