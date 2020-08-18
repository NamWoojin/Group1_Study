import java.util.Scanner;
import java.util.Stack;

public class SWEA괄호짝짓기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc=1; tc<=10; tc++) {
			int N = sc.nextInt();
			char c[] = new char[N];
			c = sc.next().toCharArray();
			boolean chk = true;
			Stack<Character> stack = new Stack<>();
			
			if(c[0] == '<' || c[0] == '(' || c[0] == '[' || c[0] == '{') {
				stack.push(c[0]);
				for(int i=1; i<c.length; i++) {
					if(c[i] == '<' || c[i] == '(' || c[i] == '[' || c[i] == '{') {
						stack.push(c[i]);
					}
					else {
						char compare = stack.pop();
						switch(compare) {
						case '<':
							if('>' != c[i])
								chk = false;
							break;
						case '(':
							if(')' != c[i])
								chk = false;
							break;
						case '[':
							if(']' != c[i])
								chk = false;
							break;
						case '{':
							if('}' != c[i])
								chk = false;
							break;
						}
						if(!chk)
							break;
					}
				}
			}
			else
				chk = false;
			
			if(chk)
				System.out.println("#"+tc+" 1");
			else
				System.out.println("#"+tc+" 0");
		}
	}
}
