import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//1231. 중위순회
public class 중위순회 {
	
	static int N;	//트리가 갖는 정점의 총 수
	static char[] tree;	//정점마다 들어있는 문자 담을 배열
	
	//중위순회
	static void inOrder(int idx) {
		if(idx > N) return;	//idx가 정점의 총 수보다 크면 종료
		
		inOrder(idx*2);	// 왼쪽 자식의 인덱스 = idx*2
		System.out.print(tree[idx]);
		inOrder(idx*2 +1);	//오른쪽 자식의 인덱스 = idx*2 + 1
	}
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t = 1; t<=10; t++) {
			N = Integer.parseInt(br.readLine());	//트리가 갖는 정점의 총 수
			tree = new char[N+1];
			
			for(int i=1; i<=N; i++) {
				StringTokenizer s = new StringTokenizer(br.readLine());
				s.nextToken();
				tree[i] = s.nextToken().charAt(0);
			}
		
			System.out.println("#" + t + " " );
			inOrder(1);
			System.out.println();
		}
	}
}
