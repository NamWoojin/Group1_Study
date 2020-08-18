import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 맥주마시기4BFS {
	static class Point{
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			Point map[] = new Point[N+2];
			boolean visited[] = new boolean[N+2];
			for(int i=0; i<N+2; i++) {
				map[i] = new Point(sc.nextInt(), sc.nextInt());
			}	// 입력 끝
			// 끝장소 기억
			Point end = new Point(map[N+1].x, map[N+1].y);
			Queue<Point> queue = new LinkedList<>();
			// 시작장소
			queue.offer(new Point(map[0].x, map[0].y));
			visited[0] = true;
			boolean res = false;
			while(!queue.isEmpty()) {
				Point np = queue.poll();
				// 끝장소와 같다면
				if(Math.abs(np.x - end.x) + Math.abs(np.y - end.y) <= 1000) {
					res = true;
					break;
				}
				
				for(int i=1; i<N+1; i++) {
					if(!visited[i] && Math.abs(np.x - map[i].x) + Math.abs(np.y - map[i].y) <= 1000) {
						queue.offer(new Point(map[i].x, map[i].y));
						visited[i] = true;
					}
				}
			}
			if(res) {
				System.out.println("happy");
			}
			else
				System.out.println("sad");
		}
	}
}
