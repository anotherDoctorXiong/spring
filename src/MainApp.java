import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        StudentDao studentJDBCTemplate =
                (StudentDao)context.getBean("studentJDBCTemplate");
        System.out.println("------Records Creation--------" );
        studentJDBCTemplate.create("Zara", 20);
        System.out.println("------Listing Multiple Records--------" );
        List<Student> students = studentJDBCTemplate.listStudents();
        for (Student record : students) {
            System.out.print("ID : " + record.getId() );
            System.out.print(", Name : " + record.getName() );
        }
        System.out.println("----Updating Record with ID = 2 -----" );

        Student student = studentJDBCTemplate.getStudent(93);
        System.out.print("ID : " + student.getId() );
        System.out.print(", Name : " + student.getName() );


    }
}
