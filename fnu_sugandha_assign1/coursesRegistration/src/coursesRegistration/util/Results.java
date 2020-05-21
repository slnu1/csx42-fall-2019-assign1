package coursesRegistration.util;

import java.util.ArrayList;
import coursesRegistration.scheduler.Student;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.File;

public class Results implements FileDisplayInterface, StdoutDisplayInterface {
	
	ArrayList<Student> students;
	float avgscore;
	String filename;
	
	public Results(ArrayList<Student> studentsin, float avgscorein, String filenamein) {
		students = studentsin;
		avgscore = avgscorein;
		filename = filenamein;
	}
	
	public void displayStdoutResults() {
		ArrayList<String> temp = new ArrayList<String>();
		for (int i=0; i<students.size(); i++) {
			temp.clear();
        	Student s = students.get(i);
        	System.out.print(s.id+":");
        	for (int j=0; j<s.courseassigned.length; j++) {
        		if(s.courseassigned[j] == 1) {
        			temp.add(s.courseprefrence[j]);
        		}
        	}
        	System.out.print(String.join(",", temp));
        	System.out.println("::SatisfactionRating="+s.satisfactionrating);
        }
		System.out.println("AverageSatisfactionRating="+avgscore);
	}
	
	/**
	 * write output to file passed in a command line argument
	 * @return void
	 * @param null
	 *  */
	public void displayResults() {
		 try {
	         File file = new File(filename);
	         if (!file.exists()) {
	            file.createNewFile();
	         } 
	         FileWriter fw = new FileWriter(file.getAbsoluteFile());
	         BufferedWriter bw = new BufferedWriter(fw);
	         ArrayList<String> temp = new ArrayList<String>();
	 		 for (int i=0; i<students.size(); i++) {
	 			temp.clear();
	         	Student s = students.get(i);
	         	bw.write(s.id+":");
	         	for (int j=0; j<s.courseassigned.length; j++) {
	         		if(s.courseassigned[j] == 1) {
	         			temp.add(s.courseprefrence[j]);
	         		}
	         	}
	         	bw.write(String.join(",", temp));
	         	bw.write("::SatisfactionRating="+s.satisfactionrating);
	         	bw.newLine();
	         }
	 		 bw.write("AverageSatisfactionRating="+avgscore);
	         bw.close();
	      } catch (IOException e) {
	         e.printStackTrace();
	      } 
	}
}
