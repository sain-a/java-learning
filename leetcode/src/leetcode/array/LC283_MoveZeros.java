package leetcode.array;

public class LC283_MoveZeros {
    public static void main(String[] args){
        LC283_MoveZeros m =new LC283_MoveZeros();
        int[] nums = {1,0,1,2,0,5};
        m.moveZeroes(nums);
        for(int i:nums){
            System.out.println(i);
        }
    }
    public void moveZeroes(int[] nums) {
        int s = 0,j=0;
        while(j<nums.length){
            if(nums[j]!=0){
                int temp = nums[s];
                nums[s] = nums[j];
                nums[j] = temp;
                s++;
            }
            j++;
        }
    }
}
