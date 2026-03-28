package leetcode.array;

public class LC66_PlusOne {
    public static void main(String[] args){
        LC66_PlusOne p = new LC66_PlusOne();
        int[] digits = {1,9,9};
        int[]res = p.plusOne(digits);
        for(int i :res){
            System.out.println(i);
        }
    }
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for(int i = n-1;i>=0;i--){
            if(digits[i]!=9){
                digits[i]++;
                return digits;
            }
            digits[i]=0;
        }
        int[]ans = new int[n+1];
        ans[0] = 1;
        return ans;
    }
}
