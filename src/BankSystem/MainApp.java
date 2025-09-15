package BankSystem;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class MainApp {
public static void main(String[] args) {
	List<Transaction> Transcations = Arrays.asList(
			  new Transaction(1, "deposit", 5000),
	            new Transaction(2, "withdrawal", 2000),
	            new Transaction(3, "deposit", 12000),
	            new Transaction(4, "withdrawal", 7000),
	            new Transaction(5, "deposit", 8000)
			);
	
    // 1. Filter deposits

	Transcations.stream().filter(s->s.type.equals("deposit")).forEach(System.out::println);
	
	//Transcations.stream().filter(s->s.type.equals("deposit")).forEach(System.out::println);
	
	System.out.println("\n-------------------------------------------\n");
	
    // 2. Filter withdrawals

	Transcations.stream().filter(t->t.type.equals("withdrawal")).forEach(System.out::println);
	
	//Transcations.stream().filter(t->t.type.equals("withdrawal")).forEach(System.out::println);
	
	
	System.out.println("\n-------------------------------------------\n");

    // 3. Sum deposits using reduce
   
	double totaldeposits = Transcations.stream().filter(d->d.type.equals("deposit")).map(t->t.amount).reduce(0.0, Double::sum);
	System.out.println("TotalDeposits-"+totaldeposits);
	
	
	//double totaldeposits = Transcations.stream().filter(d->d.type.equals("withdrawal")).map(t->t.amount).reduce(0.0, Double::sum);
	

	
	double totalWithdrawal = Transcations.stream().filter(w->w.type.equals("withdrawal")).map(a->a.amount).reduce(0.0, Double::sum);
	System.out.println("TotalWithdrawal-"+totalWithdrawal);
	
	
	System.out.println("\n----------------------------------------------------------------\n");

    // 4. Print transaction history with Consumer

	
	Consumer<Transaction> transcationList = t -> System.out.println(t);
	Transcations.forEach(transcationList);	
	
	
	System.out.println("\n----------------------------------------------------------\n");

    // 5. Find highest withdrawal

	
	 Transaction highestWithdrawal = Transcations.stream()
	            .filter(t -> t.type.equals("withdrawal"))
	            .max(Comparator.comparingDouble(t -> t.amount))
	            .orElse(null);
	 
    System.out.println(highestWithdrawal);

	System.out.println("\n---------------------------------------------------------\n");

    // 6. Find lowest withdrawal

	
	Transaction lowestWithdrawal = Transcations.stream()
            .filter(t -> t.type.equals("withdrawal"))
            .min(Comparator.comparingDouble(t -> t.amount))
            .orElse(null);
     System.out.println(lowestWithdrawal);
     
     
 	System.out.println("\n---------------------------------------------------------\n");


}
}
