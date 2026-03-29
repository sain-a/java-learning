package leetcode.math;
import java.util.Scanner;
public class LC09_Palindrome {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        boolean res = isPalindrome(x);
        System.out.println(res);
    }
    public static boolean isPalindrome(int x) {
        // if(x<0){return false;}
        // int old = x;
        // int rev = 0;
        // while(x>0){
        //     int tail = x%10;
        //     rev = rev*10+tail;
        //     x = x/10;
        // }
        // if(old==rev){return true;}
        // else{return false;}
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int rev = 0;
        while(x>rev){
            int tail = x%10;
            rev = rev*10+tail;
            x=x/10;
        }
        return (x==rev||rev/10==x);
    }
}
