import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SWEA시험 {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=TC; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); //시험 참가자 수
            int T = Integer.parseInt(st.nextToken()); //시험 문제 수
            int P = Integer.parseInt(st.nextToken()); //지학이의 번호

            int resultScore[] = new int[N];
            int solvedCnt[] = new int[N];
            int notSolved[] = new int[T];
            int score[][] = new int[N][T];
            int count=1;

            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<T; j++) {
                    score[i][j] = Integer.parseInt(st.nextToken());
            		if(score[i][j] == 0)
            			notSolved[j]++;	
            		else
            			solvedCnt[i]++; 
            	}
            }
            for(int i=0; i<N; i++) {
            	for(int j=0; j<T; j++) {
            		if(score[i][j] == 1) {
            			resultScore[i] += notSolved[j]; 
            		}
            	}
            }
            
            int cnt=1;
            for(int i=0; i<N; i++) {
            	if(i != P-1) {
	            	if(resultScore[P-1] < resultScore[i]) {
	            		cnt++;
	            	}
	            	else if( resultScore[P-1] == resultScore[i] ) {
	            		if( solvedCnt[P-1] < solvedCnt[i]) {
	            			cnt++;
	            		}
	            		else if( solvedCnt[P-1] == solvedCnt[i] ) {
	            			if( P-1 > i) {
	            				cnt++;
	            			}
	            		}
	            	}
            	}
            }
            System.out.println("#"+tc+" "+ resultScore[P-1] + " " + cnt);
        }
    }
}