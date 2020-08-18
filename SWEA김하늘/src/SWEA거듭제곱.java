import java.util.Scanner;

public class SWEA거듭제곱 {
	static int N, M;
	static int recur(int num, int res) {
		if(num == M) {
			return res;
		}
		
		return recur(num+1, res * N);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc=1; tc<=10; tc++) {
			int T = sc.nextInt();
			N = sc.nextInt();
			M = sc.nextInt();
			
			int result = recur(0, 1);
			
			System.out.println("#"+tc+" "+result);
		}
	}
}