import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 소문난칠공주5 {
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	static int N = 5;
	static int cnt;
	static int result;
	static char map[][];
	static boolean chkmap[][];
	static boolean visited[]; 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[5][5];
		result = 0;
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char[] cstr = st.nextToken().toCharArray();
			for(int j=0; j<N; j++) {
				map[i][j] = cstr[j];
			}
		}		
		
		for (int i = 0; i < 25; i++) {
	        visited = new boolean[N*N];
	        chkmap = new boolean[N][N];
	        dfs(i, 1, 0);
	    }
		
		System.out.println(result);
	}
	
	static void dfs(int idx, int cnt, int s) {
		if(map[idx / N][idx % N] == 'S') {
			s++;
		}
		
		visited[idx] = true;
		chkmap[idx / N][idx % N] = true;
		if(cnt == 7) {
			if(s >= 4) {
				find();
			}
		}
		else {
			for(int i=idx+1; i < N*N; i++) {
				if(!visited[i]) {
					dfs(idx, cnt+1, s);
				}
			}
		}
		visited[idx] = false;
		chkmap[idx / N][idx % N] = false;
	}
	
	static void find() {
		for(int i=0; i<N*N; i++) {
			if(visited[i]) {
				int x = i/5;
				int y = i%5;
				boolean visiteddfs[][] = new boolean[N][N];
				visiteddfs[x][y] = true;
				cnt = 1;
				dfs2(x, y, visiteddfs);
				return;
			}
		}
	}
	
	static void dfs2(int x, int y, boolean chked[][]) {
		if(cnt == 7) {
			++result;
		}
		else {
			for(int d=0; d<4; d++) {
				int cr = x + dr[d];
				int cc = y + dc[d];
				
				if(cr < 0 || cc < 0 || cr >= N || cc >= N)
					continue;
				
				if(chkmap[cr][cc] && !chked[cr][cc]) {
					chked[cr][cc] = true;
					++cnt;
					dfs2(cr, cc, chked);
				}
			}
		}
	}
}
