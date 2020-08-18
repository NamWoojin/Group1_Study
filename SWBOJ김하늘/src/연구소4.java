import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 연구소4 {
	static int N;
	static int M;
	static int max;
	static int lab[][];
	static int copylab[][];
	static Point virus[];
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	
	static void print() {
		System.out.println();
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(copylab[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	static int countlab() {
		int count = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(copylab[i][j] == 0)
					count++;
			}
		}
		return count;
	}
	
	static void wallbuild(int cnt) {
		if(cnt == 3) {
			//벽이 3개니까 virus체크 함수로 빼야함
			
			return;
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(copylab[i][j] == 0) {
					copylab[i][j] = 1;
					wallbuild(cnt + 1);
					copylab[i][j] = 0;
				}
			}
		}
	}
	
	static class Point{
		int r, c;
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static void copy() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				copylab[i][j] = lab[i][j];
			}
		}
	}
	public static void main(String[] args) {
		//1.연구소 입력(데이터 입력)
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		lab = new int[N][M];
		copylab = new int[N][M];
		virus = new Point[10];
		max = 0;
		int idx = 0;
		Queue<Point> queue = new LinkedList<>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				lab[i][j] = sc.nextInt();
				if(lab[i][j] == 2) {
					virus[idx++] = new Point(i, j);
				}
			}
		}
		for(int i1=0; i1<N; i1++) {
			for(int j1=0; j1<M; j1++){
				copy();
				copylab[i1][j1] = 1;
				wallbuild(1);
				copylab[i1][j1] = 0;
			}
		}
		System.out.println(max);
	}
}