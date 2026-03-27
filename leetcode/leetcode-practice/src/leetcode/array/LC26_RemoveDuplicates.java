package leetcode.array;

public class LC26_RemoveDuplicates {
        public static void main(String[] args) {
            int[] numbs = new int[]{0, 0, 1, 1, 3, 4, 4};
            int len = delete(numbs);
            System.out.println(len);

            for(int i = 0; i < len; ++i) {
                System.out.print(numbs[i]);
            }

        }
        public static int delete(int[] numbs) {
            int slow = 1;

            for(int fast = 1; fast < numbs.length; ++fast) {
                if (numbs[fast] != numbs[fast - 1]) {
                    numbs[slow] = numbs[fast];
                    ++slow;
                }
            }

            return slow;
        }
}
