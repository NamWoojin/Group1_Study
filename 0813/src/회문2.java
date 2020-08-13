import java.util.*;

public class 회문2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1; tc<=10; tc++) {
			int N = sc.nextInt();
			char map[][] = new char[8][8]; 
			for(int i=0; i<8; i++) {
				char str[] = sc.next().toCharArray();
				for(int j=0; j<8; j++) {
					map[i][j] = str[j];
				}
			}
			int cnt=0;
			for(int i=0; i<8; i++) {
				for(int j=0; j<8; j++) {
					//본인부터 오른쪽
					if(j<8-N+1) {
						boolean b = true;
						for(int k=0; k<N; k++) {
							if(map[i][j+k] != map[i][j+N-k-1] ) {
								b = false;
							}
						}
						if(b)
							cnt++;
					}
					if(i<8-N+1) {
						boolean b = true;
						for(int k=0; k<N; k++) {
							if(map[i+k][j] != map[i+N-k-1][j] ) {
								b = false;
							}
						}
						if(b)
							cnt++;
					}
				}
			}	
			System.out.println("#"+tc+" "+cnt);
		}
	}
}
