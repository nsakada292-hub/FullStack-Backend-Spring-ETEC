package Exercise;

import java.util.Random;
import java.util.Scanner;

public class Exercise7 {
    static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Random random=new Random();

        while(true){
            int random_num;
            int guess_num;

            random_num= random.nextInt(10);

            System.out.print("Enter guess number from (1-9): ");
            guess_num=sc.nextInt();

            if (random_num==guess_num){
                System.out.println("Congratulation! The number is: "+ random_num);break;
            }else{
                System.out.println("You wrong! The number is: "+ random_num);
            }
        }
    }
}
