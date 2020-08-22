import java.util.*;

public class 회문2 {
	public static void main(String[] args) {
		//데이터입력
		Scanner sc = new Scanner(System.in);
		for(int tc=1; tc<=10; tc++) {
			int T = sc.nextInt();
			char map[][] = new char[100][100];
			for(int i=0; i<100; i++) {
				map[i] = sc.next().toCharArray();
			}
			
			int max = 0;
			for(int i=0; i<100; i++) {
				for(int j=0; j<100; j++) {
					
					for(int k=99; k>=j; k--) {
						int cnt = 0;
						boolean chkh = true;
						for(int l=0; l<=k-j; l++) {
							//System.out.println("i = " + i + " j = " + j + "k = " + k + "l = " + l);
							if(map[i][j+l] != map[i][k-l]) {
								chkh = false;
								break;
							}
							cnt++;
						}
						if(chkh) {
							if(max < cnt) {
								max = Math.max(max, cnt);
								break;
							}
						}
					}
					for(int k=99; k>=i; k--) {
						int cnt = 0;
						boolean chkh = true;
						for(int l=0; l<=k-i; l++) {
							if(map[i+l][j] != map[k-l][j]) {
								chkh = false;
								break;
							}
							cnt++;
						}
						if(chkh) {
							if(max < cnt) {
								max = Math.max(max, cnt);
								break;
							}				
						}
					}
				}
			}
			System.out.println("#"+tc+" "+max);
		}
	}
}
//회문찾기 시작
//100 * 100 평면 모두를 보는 2중반복문
//각 지점별로 가로 세로 검사를 진행해서
//회문 탐색
//가로,세로 시작점부터 배열의 끝길이까지 검사했을때
//회문을 만족한다면
//max비교
//반복 	회문 만족을 하지 않는다면?
//		끝길이 -1 만큼또 탐색 시작이죠
//      회문 비교를 하기위해서 또 반복작업이 요구되는거 같아요
//		반복 반복작업 회문 비교
//지금 제가 위에 쓴 방법이 브루스포스
//추가적으로 다른 방식이 생각나신다면 한번 추가는 자윱니다 시간이 모자랄꺼에요
//이대로 한번 해보시죠!