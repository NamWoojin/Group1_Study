package lab.ssafy.corona.app;

import java.util.Arrays;
import java.util.stream.Stream;


public class StreamFilterMapTest {

	public static void main(String[] args) {
		
		// #1 filtering - distinct()
		{
			String[] strArray = {"A", "B", "C", "B", "D", "C"};
			Stream<String> stream = Arrays.stream(strArray).distinct();
			
			print(stream);
		}
		
		// #2 filtering - filter() with Predicate
		{
			Integer[] intArray = { 1, 2, 3, 4, 5 };
			Stream<Integer> stream = Arrays.stream(intArray).filter( (n)-> { return n > 2;});

			print(stream);
		}
		
		// #3 Cut - limit()
		{
			Integer[] intArray = { 11, 12, 13, 14, 15 };
			Stream<Integer> stream = Arrays.stream(intArray).limit(3);

			print(stream);
		}
		
		// #4 Cut - skip()
		{
			Integer[] intArray = { 1, 2, 3, 3, 4, 5 };
			Stream<Integer> stream = Arrays.stream(intArray).limit(2).skip(3);

			print(stream);
		}
		// #5 Sort - sorted()
		{
			Integer[] intArray = { 4, 3, 5, 1, 2 };
			Stream<Integer> stream = Arrays.stream(intArray).sorted();

			print(stream);
		}
		
		// #6 Sort - sorted(Comparator) customize it like below desc ordering
		{
			
			Integer[] intArray = { 4, 3, 5, 1, 2 };
			Stream<Integer> stream = Arrays.stream(intArray).sorted( (n1, n2) -> { return n2 - n1;} );

			print(stream);
		}
		// #7 mapping - map() 1:1
		{
			Integer[] intArray = { 4, 3, 5, 1, 2 };
			Stream<Integer> stream = Arrays.stream(intArray).map( n -> myMap(n) );
			
			print(stream);
		}
		
		// #8 mapping - map() 1:1
		{
			Virus[] virusArray = { new Virus("V1", 10), new Virus("V2", 20), new Virus("V3", 30) };
			Stream<String> stream = Arrays.stream(virusArray).map( virus -> virus.getName() );
			
			print(stream);
		}
	}
	
	static int myMap(int n) {
		return n * 10;
	}
	
	public static void print(Stream<?> stream) {
		// Stream forEach with functional interface consumer
		stream.forEach( a -> System.out.print(a + " "));
		System.out.println();
	}
}