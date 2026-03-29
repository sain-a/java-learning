public class PrimeNumber {
    public static void main(String[] args){
        int  count =0;
        for (int i=2;i<100;i++) {
            boolean isPrime  = true;
            for(int j=2;j*j<=i;j++){
                if(i%j==0) {
                     isPrime = false;
                     break;
                }
            }
            if(isPrime){
                count++;
                System.out.println(i);
            }
        }
        System.out.println(count);
    }
}
