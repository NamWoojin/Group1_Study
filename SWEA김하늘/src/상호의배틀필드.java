import java.util.Arrays;
import java.util.Scanner;

public class 상호의배틀필드 {
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			int H = sc.nextInt();
			int W = sc.nextInt();
			
			char maps[][] = new char[H][W];
			
			int currentr=0;
			int currentc=0;
			char currentt = '0';
			
			for(int i=0; i<H; i++) {
				maps[i] = sc.next().toCharArray();
				for(int j=0; j<W; j++) {
					if(maps[i][j] == '<' || maps[i][j] == '^' || 
							maps[i][j] == 'v' || maps[i][j] == '>') {
						currentr = i;
						currentc = j;
						currentt = maps[i][j];
					}
				}
			}
			
			int N = sc.nextInt();
			char order[] = new char[N]; 
			
			order = sc.next().toCharArray();
			
			for(int i=0; i<N; i++) {
				
				switch(order[i]) {
				case 'U':
					if(currentt != '^') {
						currentt = '^';
						maps[currentr][currentc] = '^';
					}
					
					if(currentr-1 >=0 && maps[currentr-1][currentc]=='.') {
						maps[currentr][currentc] = '.';
						maps[currentr-1][currentc] = '^';
						currentr += dr[0];
						currentc += dc[0];
					}
					break;
				case 'D':
					
					if(currentt != 'v') {
						currentt = 'v';
						maps[currentr][currentc] = 'v';
					}
					
					if(currentr+1 < H && maps[currentr+1][currentc]=='.') {
						maps[currentr][currentc] = '.';
						maps[currentr+1][currentc] = 'v';
						currentr += dr[1];
						currentc += dc[1];
					}
					break;
				case 'L':
					
					if(currentt != '<') {
						currentt = '<';
						maps[currentr][currentc] = '<';
					}
					
					if(currentc-1 >=0 && maps[currentr][currentc-1]=='.') {
						maps[currentr][currentc] = '.';
						maps[currentr][currentc-1] = '<';
						currentr += dr[2];
						currentc += dc[2];
					}
					break;
				case 'R':
					
					if(currentt != '>') {
						currentt = '>';
						maps[currentr][currentc] = '>';
					}
					
					if(currentc+1 < W && maps[currentr][currentc+1]=='.') {
						maps[currentr][currentc] = '.';
						maps[currentr][currentc+1] = '>';
						currentr += dr[3];
						currentc += dc[3];
					}
					break;
				case 'S':
					int shr = currentr;
					int shc = currentc; 
					
					switch(currentt) {
					case '<':
						while(true) {
							if(shc-1 >=0) {
								if(maps[shr][shc-1] == '*' || maps[shr][shc-1] == '#') {
									if(maps[shr][shc-1] == '*') {
										maps[shr][shc-1] = '.';
									}
									break;
								}
								else
									shc--;
							}
							else
								break;
						}
						break;
					case '^':
						while(true) {
							if(shr-1 >=0) {
								if(maps[shr-1][shc] == '*' || maps[shr-1][shc] == '#') {
									if(maps[shr-1][shc] == '*') {
										maps[shr-1][shc] = '.';
									}
									break;
								}
								else
									shr--;
							}
							else
								break;
						}
						break;
					case '>':
						while(true) {
							if(shc+1 < W) {
								if(maps[shr][shc+1] == '*' || maps[shr][shc+1] == '#') {
									if(maps[shr][shc+1] == '*') {
										maps[shr][shc+1] = '.';
									}
									break;
								}
								else
									shc++;
							}
							else
								break;
						}
						break;
					case 'v':
						while(true) {
							if(shr+1 < H) {
								if(maps[shr+1][shc] == '*' || maps[shr+1][shc] == '#') {
									if(maps[shr+1][shc] == '*') {
										maps[shr+1][shc] = '.';
									}
									break;
								}
								else
									shr++;
							}
							else
								break;
						}
						break;
					}
					break;
				}
			}
			
			System.out.print("#"+tc+" ");
			
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					System.out.print(maps[i][j]);
				}
				System.out.println();
			}
		}
	}
}
