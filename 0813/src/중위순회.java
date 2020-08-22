import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
 
public class 중위순회{
 
    public static class Node {
        String num;
        int left;
        int right;
 
        public Node(String num, int left, int right) {
            this.num = num;
            this.left = left;
            this.right = right;
        }
    }
    
    public static void middle(int n) {
        if(num[n].left!=0) {
            middle(num[n].left);
        }
        
        System.out.print(num[n].num);
        
        if(num[n].right!=0) {
            middle(num[n].right);
        }
    }
    
    static Node num[];
    static int res, N;
    static String input;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int tc=1; tc<=10; tc++) {
            N = sc.nextInt();
            num = new Node[N+1];
            
            res = 0;
            sc.nextLine();
            for (int i = 1; i <= N; i++) {
                input =sc.nextLine();
                String str[];
                str=input.split(" ");
                
                if(str.length==4) {
                    num[i] = new Node(str[1], Integer.parseInt(str[2]),Integer.parseInt(str[3]));
                }
                else if(str.length==3) {
                    num[i] = new Node(str[1], Integer.parseInt(str[2]),0);
                }
                else {
                    num[i] = new Node(str[1], 0, 0);
                }
            }
            System.out.print("#"+tc+" ");
            middle(1);
            System.out.println();
        }
    }
 
   
}