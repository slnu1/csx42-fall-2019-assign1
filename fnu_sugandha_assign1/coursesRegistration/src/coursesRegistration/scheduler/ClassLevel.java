package coursesRegistration.scheduler;

public enum ClassLevel {
	FIRST_YEAR,
	SECOND_YEAR,
	THIRD_YEAR;
	
	public String toString() {
		switch(this){
        case FIRST_YEAR :
            return "FIRST_YEAR";
        case SECOND_YEAR :
            return "SECOND_YEAR";
        case THIRD_YEAR :
            return "THIRD_YEAR";
        }
        return null;
	}
}
