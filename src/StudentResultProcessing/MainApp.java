package StudentResultProcessing;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class MainApp {
public static void main(String[] args) {
	List<Student> students = Arrays.asList(
		new Student(1,"Raj",90),
		new Student(2,"Ajit",92),
		new Student(3,"Harsh",88),
		new Student(4,"Shreyash",99),
		new Student(5,"Prajyot",89)
			);
	
	
	  students.stream().filter(m->m.marks>90).forEach(System.out::println);

       System.out.println("\n---------------------------------------------------\n");
	  Function<Integer,String> marksToGrade = marks ->{
		  if(marks>90) return "A";
		  else if(marks>80) return "B";
		  else if(marks>70) return "C";
		  else  if(marks>50) return "D";
		  else return "F";
				  
	  };
	  
	  students.stream().forEach(s->System.out.println(s.name+ "- "+s.marks+"-"+marksToGrade.apply(s.marks)));
	  
      System.out.println("\n---------------------------------------------------\n");

	  Consumer<Student> studentsList = s-> System.out.println(s);
	  students.forEach(studentsList);
	  
      System.out.println("\n---------------------------------------------------\n");

	  
	  Predicate<Student> failed = s ->s.marks<50;
	 long count =  students.stream().filter(failed).count();
	 System.out.println(count);
     System.out.println("\n---------------------------------------------------\n");

}
}
