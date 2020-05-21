package coursesRegistration.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import coursesRegistration.scheduler.Student;
import coursesRegistration.scheduler.Course;

public class FileProcessor {
	private String inputfilename;
	
	public FileProcessor(String inputfilenameIn){		
		inputfilename = inputfilenameIn;
		
	}
	
	public ArrayList<Student> readInputFileStudent() throws CustomException {
		FileReader fr = null;
		BufferedReader br = null;
		//StringBuilder sb = new StringBuilder();
		ArrayList<Student> students = new ArrayList<Student>();
		try {
			fr = new FileReader(inputfilename);
			br = new BufferedReader(fr);
			String temp = null;
			Student s;
			while((temp = br.readLine()) != null) {
				s = processStudents(temp);
				for (int counter = 0; counter < students.size(); counter++) { 
					Student tempstudent = students.get(counter);
					if(tempstudent.id == s.id) {
						throw new CustomException("Duplicate student in the file.please provide the correct file.");
					}
				}
				students.add(s);
			}
		} catch(FileNotFoundException ex) {
			System.out.println("File not found exception for " + inputfilename + ex);
			System.exit(1);
		} catch (IOException ex) {
			ex.printStackTrace();
			System.exit(1);
		} finally {
			try {
				br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
				System.exit(1);
			}
		}
		return students;
	}
	
	public ArrayList<Course> readInputFileCourse() throws CustomException {
		FileReader fr = null;
		BufferedReader br = null;
		//StringBuilder sb = new StringBuilder();
		ArrayList<Course> courses = new ArrayList<Course>();
		try {
			fr = new FileReader(inputfilename);
			br = new BufferedReader(fr);
			String temp = null;
			Course c;
			while((temp = br.readLine()) != null) {
				c = processCourses(temp);
				for (int counter = 0; counter < courses.size(); counter++) { 
					Course tempcourse = courses.get(counter);
					if(tempcourse.course.equals(c.course)) {
						throw new CustomException("Duplicate course in the file.please provide the correct file.");
					}
				}
				courses.add(c);
			}
		} catch(FileNotFoundException ex) {
			System.out.println("File not found exception for " + inputfilename + ex);
			System.exit(1);
		} catch (IOException ex) {
			ex.printStackTrace();
			System.exit(1);
		} finally {
			try {
				br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
				System.exit(1);
			}
		}
		return courses;
	}
	
	public Student processStudents(String studentin) throws CustomException {
		
		String[] temp = studentin.split(" ");
		
		//exception handling for ids
		if(temp[0].length() != 3) {
			throw new CustomException("id length is not equal to 3.please provide the valid id."); 
		}else if(temp[0].matches(".*[A-Za-z].*")) {
			throw new CustomException("Invalid alphanumeric id for the student.please provide the valid id.");
		}else if(temp[0].startsWith("0")){
			throw new CustomException("Id starting with 0.please provide the valid id.");
		}
		
		int id = Integer.parseInt(temp[0]);
		
		temp = temp[1].split("::");
		String[] preferences = temp[0].split(",");

		String level = temp[1];
		Student s = new Student(id,preferences,level);
		
		return s;
		
	}
	
   public Course processCourses(String coursein) {
		
		String[] temp = coursein.split(" ");
		
		String course = temp[0];
		temp = temp[1].split(";");
		int capacity = Integer.parseInt(temp[0].split(":")[1]);
		int classtiming = Integer.parseInt(temp[1].split(":")[1]);
		Course c = new Course(course,capacity,classtiming);
		
		return c;
		
	}
   
   
	
	
}

class CustomException extends Exception{
  public CustomException(String message)
  {
    super(message);
  }
}
