package week2_day05_String;

public class StringUtils {
    // 1. 反转字符串
    public static String reverse(String str){
        if(str==null){
            return null;
        }
        return new StringBuilder(str).reverse().toString();
    }

    // 2. 判断是否回文（aba）
    public static boolean isPalindrome(String str){
        if (str == null) {
            return false;
        }
//        return str.equals(new StringBuilder(str).reverse().toString());
        int left = 0,right = str.length()-1;
        while(left<right){
            if(str.charAt(left)!=str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    // 3. 拼接字符串（用StringBuilder）
    public static String join(String[] arr){
        if (arr == null || arr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length ; i++) {
            sb.append(arr[i]);
            if (i != arr.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
    //4.
    public static boolean isBlank(String str){
        return str == null || str.trim().isEmpty();
    }
}
