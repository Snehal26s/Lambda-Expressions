package OnlineShoppingfCart;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MainApp {
public static void main(String[] args) {
	
	List<Product> cart = Arrays.asList(
            new Product(1, "Laptop", 65000),
            new Product(2, "Phone", 35000),
            new Product(3, "Tablet", 25000),
            new Product(4, "Headphones", 2000),
            new Product(5, "Smartwatch", 15000)
        );
	
    // 1. Filter products above a given price (e.g., > 20000)

	 cart.stream().filter(c->c.price>20000).forEach(System.out::println);
	 
	 
	 System.out.println("\n-------------------------------------------------------\n");
	 
     // 2. Sort products by name

	 cart.stream()
     .sorted((p1, p2) -> p1.name.compareTo(p2.name))
     .forEach(System.out::println);
	 
	 System.out.println("\n-------------------------------------------------------\n");

     // 3. Sort products by price

	  cart.stream()
      .sorted((p1, p2) -> Double.compare(p1.price, p2.price))
      .forEach(System.out::println);

      System.out.println("\n-------------------------------------------------------\n");

	  
      // 4. Apply 10% discount using map(Function)

	  
	  Function<Product, Product> applyDiscount = p->new Product(p.id,p.name,p.price*0.9); 
	  
	  List<Product>discountProducts = cart.stream().map(applyDiscount).collect(Collectors.toList());

      System.out.println("\n-------------------------------------------------------\n");
   
      
      // 5. Print final cart using forEach

      
      discountProducts.stream().forEach(System.out::println);









}

}
