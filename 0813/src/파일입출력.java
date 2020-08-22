import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class 파일입출력 {
	public static void main(String[] args) {
		try {
			FileOutputStream fo = new FileOutputStream("file.dat");
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
