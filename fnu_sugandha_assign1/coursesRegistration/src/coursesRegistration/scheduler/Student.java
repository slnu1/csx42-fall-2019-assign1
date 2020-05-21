package coursesRegistration.scheduler;

import coursesRegistration.scheduler.ClassLevel;

public class Student {
	
	public int id;
	public String[] courseprefrence=new String[9];
	public ClassLevel level;
	public int[] courseassigned = new int[9]; 
	public int noofcoursesassigned;
	public int satisfactionrating;
	
	public Student(int idin,String[] courseprefrencein,String levelin) {
    	id = idin;
    	courseprefrence = courseprefrencein;
    	level = ClassLevel.valueOf(levelin);  
    	for(int i = 0;i < courseassigned.length;i++) {
    		courseassigned[i] = 0;
    	}
    	noofcoursesassigned= 0;
    	satisfactionrating = 0;
    } 
    
    public void checkOutput() {
    	System.out.println(id);
    	for(int i = 0;i < courseprefrence.length;i++) {
    		System.out.print(courseprefrence[i]);
    	}	
    	System.out.println(" ");
    	for(int i = 0;i < courseassigned.length;i++) {
    		System.out.print(courseassigned[i]);
    	}	
    	System.out.println(" ");
    	System.out.println(level);
    	System.out.println("noofcoursesassigned"+noofcoursesassigned);
    	System.out.println("satisfactionrating"+satisfactionrating);
    }
}
