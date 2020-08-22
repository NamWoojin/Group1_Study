import java.util.Arrays;
import java.util.Scanner;

public class SWEA길찾기 {
	static int arr1[];
	static int arr2[];
	static boolean visited1[];
	static boolean visited2[];
	static boolean res;
	
	static void dfs(int idx) {
		if(arr1[idx] == 99 || arr2[idx] == 99) {
			res = true;
			return;
		}
		if(!visited1[idx] && arr1[idx] != 0) {
			visited1[idx] = true;
			dfs(arr1[idx]);
			visited1[idx] = false;
		}
		if (!visited2[idx] && arr2[idx] != 0) {
			visited2[idx] = true;
			dfs(arr2[idx]);
			visited2[idx] = false;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc=1; tc<=10; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			arr1 = new int[100];
			arr2 = new int[100];
			visited1 = new boolean[100];
			visited2 = new boolean[100];
			res = false;
			
			for(int i=0; i<M; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				
				if(arr1[from] == 0) {
					arr1[from] = to;
				}
				else
					arr2[from] = to;
			}
			dfs(arr1[0]);
			
			if(res)
				System.out.println("#"+tc+" 1");
			else
				System.out.println("#"+tc+" 0");
		}
	}
}
