package coursesRegistration.driver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import coursesRegistration.util.FileProcessor;
import coursesRegistration.scheduler.Student;
import coursesRegistration.scheduler.Course;
import coursesRegistration.scheduler.Scheduler;
import coursesRegistration.util.Results;

/**
 * @author John Doe
 *
 */
public class Driver {
//	public ArrayList<Object> students;
	public static void main(String[] args) {

		/*
		 * As the build.xml specifies the arguments as argX, in case the
		 * argument value is not given java takes the default value specified in
		 * build.xml. To avoid that, below condition is used
		 */
		
		if (args.length != 3 || args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}")) {

			System.err.println("Error: Incorrect number of arguments. Program accepts 3 argumnets.");
			System.exit(0);
		}
		
		System.out.println("Hello World! Lets get started with the assignment");
		
		FileProcessor fp;
		
		fp = new FileProcessor(args[0]);
		ArrayList<Student> students = null;
		try {
			students = fp.readInputFileStudent();
		} catch(Exception e) {
			System.exit(1);
		}
		
		fp = new FileProcessor(args[1]);
		ArrayList<Course> courses = null;
		try {
			courses = fp.readInputFileCourse();
		} catch(Exception e) {
			System.exit(1);
		}
		
		Scheduler sch = new Scheduler(students,courses);
		sch.sortStudents();
		sch.sortCourses();
		sch.assignCourses();
		sch.calculateSatisfactionRating();
		Results re = new Results(students, sch.getAvgSatisfactionRating(), args[2]);
		//re.displayStdoutResults();
		re.displayResults();
		
	}
	

}


