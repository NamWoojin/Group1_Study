import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 주사위쌓기 {

public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[][] map = new int[N][6];
    int[] bottom =  new int[N];
    int[] top = new int[N];
    int result =0;
    
    for(int i=0;i<N;i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int j=0;j<6;j++) {
            map[i][j] = Integer.parseInt(st.nextToken());
        }
    }
    
    for(int i=1;i<=6;i++) { // bottom주사위값
        for(int j=0; j<6;j++) { 
            if(map[0][j]==i) {
                switch(j) {
                    case 0:
                        bottom[0] = 0;
                        top[0] = 5;
                        break;
                    case 1:
                        bottom[0] = 1;
                        top[0] = 3;
                        break;
                    case 2:
                        bottom[0] = 2;
                        top[0] = 4;
                        break;
                    case 3:
                        bottom[0] = 3;
                        top[0] = 1;
                        break;
                    case 4:
                        bottom[0] = 4;
                        top[0] = 2;
                        break;
                    case 5:
                        bottom[0] = 5;
                        top[0] = 0;
                        break;
                }
            }
        }
    
     // for(i)
    

    //1층 맥스값
    int max=0;
    for(int j=1;j<=6;j++) {
        if(!((map[0][bottom[0]] == j) || map[0][top[0]]==j)) {
            max = Math.max(max, j);
        }    
    }
    for(int j=1;j<N;j++) { // 주사위 층수
        for(int k=0;k<6;k++) { // 인덱스
            if(map[j][k]==map[j-1][top[j-1]]) {
                switch(k) {
                case 0:
                    bottom[j] = 0;
                    top[j] = 5;
                    break;
                case 1:
                    bottom[j] = 1;
                    top[j] = 3;
                    break;
                case 2:
                    bottom[j] = 2;
                    top[j] = 4;
                    break;
                case 3:
                    bottom[j] = 3;
                    top[j] = 1;
                    break;
                case 4:
                    bottom[j] = 4;
                    top[j] = 2;
                    break;
                case 5:
                    bottom[j] = 5;
                    top[j] = 0;
                    break;
                }
            }
        }
    }
    
    
    for(int j=1;j<N;j++) {
        if((map[j][bottom[j]]==6 && map[j][top[j]]==5)||(map[j][bottom[j]]==5 && map[j][top[j]]==6) ) {
            max +=4;
        }
        else if((map[j][bottom[j]]==6 || map[j][top[j]]==6)) {
            max += 5;
        }else {
            max += 6;
        }
    }
    
    
    result = Math.max(result, max);
    
    }
    System.out.println(result);
	}// main
} // class