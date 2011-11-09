package ejb;

import ejb.Student;
import ejb.Teacher;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.2.0.v20110202-r8913", date="2011-11-09T15:59:13")
@StaticMetamodel(Subject.class)
public class Subject_ { 

    public static volatile SingularAttribute<Subject, Short> maxstudents;
    public static volatile SingularAttribute<Subject, Date> schedule;
    public static volatile SingularAttribute<Subject, Integer> classId;
    public static volatile SingularAttribute<Subject, String> name;
    public static volatile CollectionAttribute<Subject, Student> studentCollection;
    public static volatile SingularAttribute<Subject, Teacher> teacherId;

}