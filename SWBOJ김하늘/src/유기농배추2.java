import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class 유기농배추2 {
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	static int N, M;
	static int map[][];
	static void dfs(int r, int c) {
		//기저파트에서
		//특정 값을 완료햇잖아요?
		//출력만하구요 더 돌필요가 없으면요
		//exit(0) 종료시키면 실행시간이 단축되겟죠
		//더 필요없는 연산을 안하는거죠 리턴이든 재귀든 돌면서
		map[r][c] = 0;
		for(int d=0; d<4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			//나가리 탐색을 할 필요가 없음 애시당초 배열의 크기를 이미 필드보다 크게 만들었기 때문에								
			//0으로 이미 지정 되어 있어요
			
			if(map[nr][nc]==0)
				continue;
			
			map[nr][nc] = 0; 	//바꾸고 싶은 상태
			dfs(nr, nc);
			// 바꾸기 이전 상태로만 돌려주면 노프라블럼
		}	
	}
	
	static class Point{
		int r,c;
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int M = sc.nextInt();
			int N = sc.nextInt(); 
			int K = sc.nextInt();
			int totalCnt = 0;
			map = new int[N+3][M+3];	// 배열 초기화 값은 default = 0
			for(int i=0; i<K; i++) {
				int nm = sc.nextInt()+1;
				int nn = sc.nextInt()+1;
				map[nn][nm] = 1;
			}
			// 데이터셋 종료
			
			Queue<Point> queue = new LinkedList<Point>();
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=M; j++) {
					if(map[i][j] == 1) {
						totalCnt++;
						dfs(i, j);
					}
				}
			}
			System.out.println(totalCnt);
		}
	}
}