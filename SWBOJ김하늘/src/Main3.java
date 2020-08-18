import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main3 {
    public static void main(String[] args) throws Exception {
        // 데이터입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int tc = 1; tc <= 1; tc++) {
            int x = Integer.parseInt(br.readLine()); // 의미없는 입력값
            char map[][] = new char[100][100];
            for (int i = 0; i < 100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                map[i] = st.nextToken().toCharArray();
            }

            int cnt = 0;
            int result = 0;
            for (int r = 0; r < 100; r++) { // 층
                for (int i = 0; i < 100; i++) { // 왼쪽 시작값
                    int start =i;
                    for (int k = 99; k > start; k--) {
                        if (map[r][start] == map[r][k]) {
                            start++;
                            cnt += 2;
                        }
                        if(map[r][start] != map[r][k]) {
                            start=i;
                        }
                        if (k-start ==1)
                            cnt += 1;

                    }
                }
                result = Math.max(cnt, result);
            }
            System.out.println(result);
        }
        // 각 지점별로 가로 세로 검사를 진행해서
        // 회문 탐색
        // 가로,세로 시작점부터 배열의 끝길이까지 검사했을때
        // 회문을 만족한다면
        // max비교
        // 반복 회문 만족을 하지 않는다면?
        // 끝길이 -1 만큼또 탐색 시작이죠
        // 회문 비교를 하기위해서 또 반복작업이 요구되는거 같아요
        // 반복 반복작업 회문 비교
        // 지금 제가 위에 쓴 방법이 브루스포스
        // 추가적으로 다른 방식이 생각나신다면 한번 추가는 자윱니다 시간이 모자랄꺼에요
        // 이대로 한번 해보시죠!
    }
}