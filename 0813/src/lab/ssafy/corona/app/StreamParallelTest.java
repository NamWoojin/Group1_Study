package lab.ssafy.corona.app;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamParallelTest {

	public static void main(String[] args) {
		String[] strArray = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
		
		// parallel
		Stream<String> stream = Arrays.stream(strArray).parallel();
		stream.forEach( s -> System.out.print(s) );
		
		System.out.println();
		
		// sequential
		stream = Arrays.stream(strArray);
		stream.forEach( s -> System.out.print(s) );
	}
}