package javaconcepts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Products {

	int id;
	String name;
	Double price;

	Products(int id, String name, Double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product Id " + id + " Product Name " + name + " Product Price " + price;
	}
}

public class PracticeStreams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> myList = Arrays.asList("Rocket", "Mars", "Neptune", "Earth", "Pluto");

		myList.stream().filter(str -> str.length() > 6).forEach(System.out::println);
		List<String> out1 = myList.stream().filter(str -> str.length() > 6).collect(Collectors.toList());
		System.out.println(out1);

		Products products = new Products(0, "Asus", 65000.0);

		System.out.println(products.toString());

		List<Products> prodList = Arrays.asList(
				new Products(1, "HP", 75000.0),
				new Products(2, "Lenovo", 60000.0),
				new Products(3, "Dell", 55000.0),
				new Products(4, "MAC", 95000.0));


		// Find the name of product whose price is more than 75000
		prodList.stream().filter(p -> p.price > 75000.0).forEach(str -> System.out.println(str.name));
		
		List<String> prodName= prodList.stream().filter(p->p.price>55000.0).map(p->p.name).collect(Collectors.toList());
		System.out.println(prodName);
		
		List<String> teamA = Arrays.asList("Sachin","Zak","Ganguly");
		List<String> teamB = Arrays.asList("Dravid","Yuvraj","Kumble");
		List<String> teamC = Arrays.asList("Sehwag","Dhoni","Kohli","Rohit");	
		
		List<List<String>> playersList = Arrays.asList(teamA,teamB,teamC);
		
		System.out.println(playersList);
		
		List<Products> prodList2 = Arrays.asList(new Products(5, "Lenovo", 75000.0),new Products(6, "ChromeBook", 35000.0));
		List<List<Products>> combinedList = Arrays.asList(prodList,prodList2);
		
		combinedList.stream().flatMap(p->p.stream()).map(p->p.name).forEach(System.out::println);
		
		List<String> myList2 = Arrays.asList("apple","samsung","apple","nokia");
		long count =myList2.stream().distinct().count();
		//myList2.stream().limit(3).forEach(System.out::println);
		System.out.println(count);
		
		//Reduce
		System.out.println(prodList.stream().map(p->p.price).reduce(0.0d,(sum,price)->sum+price));
		
		//Min
		Products p=prodList.stream().min((p1,p2)->p1.price.compareTo(p2.price)).get();
		System.out.println(p.price);
		
		//Product list to map
		Map<Integer,String> productPriceMap= prodList.stream().collect(Collectors.toMap(p1->p1.id,p2->p2.name));
		System.out.println(productPriceMap);
		
		//AnyMatch, allMatch, noneMatch, findAny, findFrist, concat
		Boolean matchResult = myList2.stream().anyMatch(value->{return value.startsWith("a");});
		System.out.println(matchResult);
		
		int [] nums = {0,0,1,1,1,2,2,3,3,4};
		
		Arrays.stream(nums).distinct().forEach(System.out::print);
	   
		

	}

}
