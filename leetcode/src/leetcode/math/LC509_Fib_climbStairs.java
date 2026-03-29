package leetcode.math;

public class LC509_Fib_climbStairs {
    public static void main(String[] args){
        int n = 3;
        int res = climbStairsPlus(n);
        System.out.println(res);
    }
    public static int fib(int n) {
        int res = 0;
        if(n<2) return n;
        // res = fib(n-1)+fib(n-2);
        // return res;

        int a = 0, b = 1;
        for(int i = 2;i <= n; i++){
            int sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
    //斐波那契数和爬楼梯都只2依赖前两步状态，递推关系相同，只是初始条件不同
    // 每次只能走一步或两步
    public static int climbStairs(int n){
        if(n<=2) return n;
        int[] dp = new int [n+1];
        dp[1]=1;
        dp[2]=2;
        for(int i = 3;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    //每次只走一步或两步，但不能连续走两步
    public static int climbStairsPlus(int n){
        if(n==1) return 1;
        int[][] dp = new int[n+1][2];
        dp[1][0]=1;
        dp[1][1]=0;
        dp[2][0]=1;
        dp[2][1]=1;
        for(int i = 3; i<=n;i++){
            dp[i][0]=dp[i-1][0]+dp[i-1][1];
            dp[i][1]=dp[i-2][0];
        }
        return dp[n][0]+dp[n][1];
    }
}
