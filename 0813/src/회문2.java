import java.util.*;

public class 회문2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1; tc<=10; tc++) {
			int N = sc.nextInt();
			char map[][] = new char[100][100]; 
			for(int i=0; i<100; i++) {
				char str[] = sc.next().toCharArray();
				for(int j=0; j<100; j++) {
					map[i][j] = str[j];
				}
			}
			int max = 0;
			for(int i=0; i<100; i++) {
				for(int j=0; j<100; j++) {
					int cnt=1;
					//본인부터 오른쪽
					boolean b = true;
					for(int k=2; k<100; k++) {
						if(map[i][j] == map[i][k]) {
							cnt++;
						}
						else {
							b = false;
							break;
						}
					}
					max = Math.max(max, cnt);
					if(b)
						cnt++;
					
					b = true;
					for(int k=2; k<100; k++) {
						if(map[j][i] == map[k][i]) {
							cnt++;
						}
						else {
							b = false;
							break;
						}
					}
					max = Math.max(max, cnt);
					if(b)
						cnt++;
					
				}
			}
			System.out.println("#"+tc+" "+max);
		}
	}
}
