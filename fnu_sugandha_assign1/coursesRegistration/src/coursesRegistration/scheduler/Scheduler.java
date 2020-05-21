package coursesRegistration.scheduler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import coursesRegistration.scheduler.Student;
import coursesRegistration.scheduler.Course;

public class Scheduler{
	
	ArrayList<Student> students;
	ArrayList<Course> courses;
	
	public Scheduler(ArrayList<Student> studentsin,ArrayList<Course> coursesin){
		students = studentsin;
		courses = coursesin;		
	}
	
	public void sortStudents() {
		Collections.sort(students, new SortbyLevel());
	}
	
	public void sortCourses() {
		Collections.sort(courses, new SortbyCourse());
	}
	
	public void assignCourses() {
		for (int i=0; i<students.size(); i++) {
			Student s = students.get(i);
			//max 3 courses can be assigned
			for (int j=0; j<s.courseprefrence.length; j++) {
				if(isCourseTimeOk(s.courseprefrence[j],s) && getCourseCapacity(s.courseprefrence[j]) > 0) {
					s.courseassigned[j] = 1;
					s.noofcoursesassigned++;
					updateCourseCapacity(s.courseprefrence[j]);
					if(s.noofcoursesassigned > 2) {
						break;
					}
				}
			}
		}
	}
	
	public boolean isCourseTimeOk(String currentcoursein,Student currentstudentin) {
		//find timimng for current course
		int currentcoursetime = getClassTimings(currentcoursein);
		
		if(currentstudentin.noofcoursesassigned > 0) { //if any course assigned to current student
			for (int i=0; i<currentstudentin.courseassigned.length; i++) {
				if (currentstudentin.courseassigned[i] == 1) {
					int temp = getClassTimings(currentstudentin.courseprefrence[i]);
					if (temp == currentcoursetime) {
						return false;
					}
				}
			}
		} else {
			return true;
		}
		
		return true;
		
	}
	
	private int getClassTimings(String coursenamein) {
		for (int i=0; i<courses.size(); i++) {
			 Course c = courses.get(i);
			 if(c.course.equals(coursenamein)) {
				 return c.classtiming;
			 }
		 }
		return 0;
	}
	
	private int getCourseCapacity(String coursenamein) {
		for (int i=0; i<courses.size(); i++) {
			 Course c = courses.get(i);
			 if(c.course.equals(coursenamein)) {
				 return c.currentcapacity;
			 }
		 }
		return 0;
	}
	
	private void updateCourseCapacity(String coursenamein) {
		for (int i=0; i<courses.size(); i++) {
			 Course c = courses.get(i);
			 if(c.course.equals(coursenamein)) {
				 c.currentcapacity--;
			 }
		 }
	}
	
	public void calculateSatisfactionRating() {
		for (int i = 0; i < students.size(); i++) { 
			Student s = students.get(i);
			for (int j=0; j<s.courseassigned.length; j++) {
				if (s.courseassigned[j] == 1) {
					s.satisfactionrating = s.satisfactionrating + (s.courseassigned.length - j);
				}
			}
         }
	}
	
	public float getAvgSatisfactionRating() {
		int total = 0;
		for (int i = 0; i < students.size(); i++) { 
			Student s = students.get(i);
			total = total + s.satisfactionrating;			
		}
		
		return (total/students.size());
	}
	
}


class SortbyLevel implements Comparator<Object> { 
    // Used for sorting in descending order of level
    public int compare(Object a, Object b) {
    	Student x = (Student)a;
    	Student y = (Student)b;
        return (x.level.toString()).compareTo(y.level.toString()) * -1; 
    }
}


class SortbyCourse implements Comparator<Object> { 
	// Used for sorting in ascending order of courses
    public int compare(Object a, Object b) {
    	Course x = (Course)a;
    	Course y = (Course)b;
        return (x.course).compareTo(y.course); 
    }
}