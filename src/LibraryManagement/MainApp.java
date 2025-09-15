package LibraryManagement;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class MainApp {
public static void main(String[] args) {
	 List<Book> books = Arrays.asList(
             new Book(1, "Effective Java", "Joshua Bloch", 2018),
             new Book(2, "Clean Code", "Robert C. Martin", 2008),
             new Book(3, "Java Concurrency in Practice", "Brian Goetz", 2015),
             new Book(4, "Spring in Action", "Craig Walls", 2021),
             new Book(5, "Head First Java", "Kathy Sierra", 2019)
     );
	 
     // 1️⃣ Filter books by author

	 books.stream().filter(s->s.author.equalsIgnoreCase("Joshua Bloch")).forEach(System.out::println);
	 
	 System.out.println("\n---------------------------------------------\n");
	 
     // 2️⃣ Sort by title
     books.stream().sorted(Comparator.comparing(a->a.title)).forEach(System.out::println);
	 
	 System.out.println("\n---------------------------------------------\n");

     // 3️⃣ Sort by year
     
	 books.stream().sorted(Comparator.comparing(y->y.year)).forEach(System.out::println);
	 
	 
	 System.out.println("\n---------------------------------------------\n");

     // 4️⃣ Count books published after 2015
     
	 long count = books.stream().filter(b->b.year<2015).count();
	 System.out.println(count);
	 
	 System.out.println("\n---------------------------------------------\n");

     // 5️⃣ Print details using Consumer
     
	 
	  System.out.println("\nPrinting all book details using Consumer:");
      Consumer<Book> bookPrinter = b -> System.out.println(
              "📘 " + b.title + " by " + b.author + " (" + b.year + ")");
      books.forEach(bookPrinter);	 
}

}
