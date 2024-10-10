package Lab9_2;

public class Student {
	
	private String name;
	private String grade;
	
	



	public Student(String name, String grade) {
		this.name = name;
		this.grade = grade;
	}
	
	public class IncompleteException extends Exception{

		   public IncompleteException(String grade){

		          super(grade);
		   }

	}
	
	public class DigitException extends Exception{

		   public DigitException(String name){

		          super(name);
		   }

	}
	
	public class SpaceException extends Exception{

		   public SpaceException(String name){

		          super(name);
		   }

	}
	
	public class GradeException extends Exception{

		   public GradeException(String grade){

		          super(grade);
		   }

	}
	
	double calgpa() throws IncompleteException, DigitException ,SpaceException,GradeException  {
        if (grade.contains("I")) {
            throw new IncompleteException("IncompleteException : (grade I is incomplete) can not display.");
        }
        

        if (name.matches(".*\\d.*")) {
            throw new DigitException("DigitException : (digit is not allowed in name) can not display.");
        }
        

        if (name.contains(" ")) {
            throw new SpaceException("SpaceException : (space is not allowed in name) can not display. ");
        }
        
        if (!grade.matches("[ABCDEF]*")) {
            throw new GradeException("GradeException : (grade must be A B C D E F) can not display.");
        }
        
        
        else {
        	int sum=0,i=0,fall=0,gpa=0;
        	for(i = 0; i < grade.length();i++){
        		if(grade.charAt(i)=='A') gpa=4;
        		if(grade.charAt(i)=='B') gpa=3;
        		if(grade.charAt(i)=='C') gpa=2;
        		if(grade.charAt(i)=='D') gpa=1;
        		if(grade.charAt(i)=='E') gpa=0;
        		if(grade.charAt(i)=='F') {
        			fall++;
        			continue;
        		}
        		sum+=gpa;
          }
        	
        	System.out.println(name + " registered " + grade.length() + " subjects and got GPA " + sum/i);
        	if(fall>0)
        	System.out.println(fall + " subjects is fall");
        }
		return 0;
	}


    public void show() {
        try {
        	calgpa();
            
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
        
    }
		

	

}
