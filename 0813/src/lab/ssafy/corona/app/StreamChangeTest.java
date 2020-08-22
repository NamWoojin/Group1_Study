package lab.ssafy.corona.app;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamChangeTest {

	public static void main(String[] args) {

		String[] strArray = {"A", "B", "C", "B", "D", "C"};
		Stream<String> stream = Arrays.stream(strArray);
		Stream<String> stream2 = stream.map( c -> c + 1 );
		stream = stream.distinct();
		print(stream);
	}
	
	public static void print(Stream<?> stream) {
		stream.forEach( a -> System.out.print(a + " "));
		System.out.println();
	}
}