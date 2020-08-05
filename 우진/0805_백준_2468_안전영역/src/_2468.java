import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2468 {

	static class Node {	//r,c 보관하는 클래스 객체
		int r;
		int c;

		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

	static int[][] arr;
	static boolean[][] visited;
	static int N;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(in.readLine());	// N 개수 읽기
		arr = new int[N][N];
		int min = 100;
		int max = 0;
		int maxIsland = 0;
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(in.readLine()); 	// 한 줄 읽기(띄어쓰기 단위로 자름)
			for (int j = 0; j < N; ++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				min = min > arr[i][j] ? arr[i][j] : min; // 최솟값 찾기
				max = max < arr[i][j] ? arr[i][j] : max; // 최댓값 찾기
			}
		}
		if (min == max) {	//최소, 최대가 동일하면 안전영역은 1
			maxIsland = 1;
		} else {
			for (int border = min; border < max; ++border) {	//최소 ~ 최대까지
				visited = new boolean[N][N];
				int countIsland = 0;	//영역 개수 카운트 변수
				for (int i = 0; i < N; ++i) {
					for (int j = 0; j < N; ++j) {
						if (!visited[i][j] && arr[i][j] > border) {	//방문하지 않았고, 경계보다 위에 있을 때
							++countIsland;							//영역 카운트 + 1
							CountIsland(i, j, border);				//현 위치, 경계 수위를 파라미터로 전달
						}
					}
				}

				if (maxIsland <= countIsland) {	//안전 영역의 개수가 최대인지 판단
					maxIsland = countIsland;
				}
			}
		}

		System.out.println(maxIsland);

	}

	private static void CountIsland(int r, int c, int border) {	//한 영역의 범위 체크
		Queue<Node> queue = new LinkedList<>();
		visited[r][c] = true;	//방문여부 true
		queue.offer(new Node(r, c));	//현 위치 큐에 저장

		while (!queue.isEmpty()) {
			Node node = queue.poll();
			int rr, cc;
			for (int i = 0; i < 4; ++i) {	//사방 검사
				rr = node.r + dr[i];
				cc = node.c + dc[i];
				if (rr < 0 || cc < 0 || rr >= N || cc >= N)
					continue;
				if (!visited[rr][cc] && arr[rr][cc] > border) {	//방문하지 않았고, 경계보다 위에 있을 때
					visited[rr][cc] = true;			//방문여부 true
					queue.offer(new Node(rr, cc));	//해당 위치 큐에 저장
				}
			}
		}
	}
}
