import java.util.Scanner;
public class ScoreJudge {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入成绩（0-100）：");
        int score = sc.nextInt();
        if(score>=90&&score<=100){
            System.out.println("A");
        }else if(score>=80){
            System.out.println("B");
        }else if(score>=70){
            System.out.println("C");
        }else if(score>=60){
            System.out.println("D");
        }else if(score>=0){
            System.out.println("E");
        }else {
            System.out.println("输入不合法");
        }
        sc.close();
    }
}
