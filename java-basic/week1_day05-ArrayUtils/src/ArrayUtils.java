public class ArrayUtils {
    public static void printArray(int[] arr){
        for(int i = 0; i < arr.length; i++){  //for(int i:arr)
            System.out.print(arr[i]);
        }

        System.out.println();
    }
    public  static void printArray(int[][] arr){
        for(int[]row:arr){
            for(int val:row){
                System.out.print(val+" ");
            }
            System.out.println();
        }
    }
    public static int getMax(int[] arr){
        int max = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }
        return max;
    }
    public static void reverse(int[] arr){
        for(int i = 0; i < arr.length/2; i++){
            int temp = arr[i];
            arr[i] = arr[arr.length-1-i];
            arr[arr.length-1-i] = temp;
        }
    }
}
