package coursesRegistration.scheduler;

public class Course {
	
	public String course;
	public int capacity;
	public int classtiming;
	public int currentcapacity;
	
	
	public Course(String coursein,int capacityin,int classtimingin) {
		course = coursein;
    	capacity = capacityin;
    	currentcapacity = capacityin;
    	classtiming = classtimingin;    	
    } 
    
	public void checkOutputCourses() {
    	System.out.println(course);
    	System.out.println("capacity" + capacity);
    	System.out.println("currentcapacity" + currentcapacity);
    	System.out.println(classtiming);
    }
}
