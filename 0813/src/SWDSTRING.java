import java.util.*;

public class SWDSTRING {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1; tc<=10; tc++) {
			int N = sc.nextInt();
			char chk[] = sc.next().toCharArray();
			char str[] = sc.next().toCharArray();
			int cnt=0;
			for(int i=0; i<str.length; i++) {
				//System.out.print(str[i]);
				boolean b = false;
				if(chk[0] == str[i]) {
					for(int j=0; j<chk.length; j++) {
						if(i+j < str.length && chk[j] == str[i+j]) {
							b = true;
						}
						else {
							b = false;
							break;
						}
					}
					if(b)
						cnt++;
				}
			}
			System.out.println("#"+tc+" "+cnt);
		}
	}
}
