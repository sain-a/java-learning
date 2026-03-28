public class LoopDemo {
    public  static void main(String[] args){
        for(int i = 0; i < 5; i++){
            System.out.print(i);
        }
        System.out.println();
        int i = 0;
        while(i<5){
            System.out.print(i);
            i++;
        }
        System.out.println();
        for(int j = 0;j < 10;j++) {
            if (j == 5) break;
            System.out.print(j);
        }
        System.out.println();
        for(int j=0;j<5;j++){
            if(j==2) continue;
            System.out.print(j);
        }
    }
}
