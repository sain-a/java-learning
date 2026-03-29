package leetcode.array;

public class LC01_TwoSum {
        public static void main(String[] args) {
            int[] numbs = new int[]{2, 7, 11, 15};
            int target = 9;
            int[] result = twoSum(numbs, target);
            System.out.println(result[0] + "," + result[1]);
        }
        public static int[] twoSum(int[] numbs, int target) {
            for (int i = 0; i < numbs.length; ++i) {
                for (int j = i + 1; j < numbs.length; ++j) {
                    if (numbs[i] + numbs[j] == target) {
                        return new int[]{i, j};
                    }
                }
            }
            return new int[0];
        }
}
