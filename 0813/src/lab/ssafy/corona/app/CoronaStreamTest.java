package lab.ssafy.corona.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class CoronaStreamTest {

	public static void main(String[] args) {

		Random r = new Random();
		long sum = 0;
		
		for( int i=0; i<100; i++) {
			
			List<Corona> list = new ArrayList<Corona>();
			
			for( int j=0; j<10000; j++ ) {
				int spreadSpeed = r.nextInt(1000);
				list.add( new Corona("", 0, spreadSpeed) );
			}

			Stream<Corona> stream = list.stream().parallel();
			stream = stream.filter( (c)-> { return c.getSpreadSpeed() > 500; });
			long count = stream.count();
			
			System.out.println(count);
			sum += count;
		}
		
		System.out.println("평균 전파 속도 : " + sum / 100 );		
	}
}
