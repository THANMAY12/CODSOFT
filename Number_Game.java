package Codesoft;
import java.util.*;
public class Number_Game{
    public static void main(String[] args) {
        Boolean flag=true,flag1;
        int count=0;
        int score=0;
        int c=0;
        while(flag){
            Random rand=new Random();
            int n=rand.nextInt(1,100);
            Scanner sc=new Scanner(System.in);
                flag1=true;
                while(flag1){
                    if(count<3){
                    System.out.println("Enter Number Between 1 to 100.");
                    System.out.println((3-count)+" attempts left.");
                    count++;
                    c++;
                    int a=sc.nextInt();
                    if(a>0){
                        if(a==n){
                            System.out.println("correct guess.");
                            score++;
                            System.out.println("If you want to play again press 1 else 2.");
                            int choice=sc.nextInt();
                                if(choice==2){
                                    flag=false;
                                    flag1=false;
                                    System.out.println(" Total attempts: "+c);
                                    System.out.println(" Total score: "+score);
                                }
                                else if(choice==1){
                                    flag1=false;
                                    count=0;
                                }
                        }
                        else if((a>n)&&a<=(n+20)){
                            System.out.println("Little high.");
                        }
                        else if((a<n)&&a>=(n-20)){
                            System.out.println("Little low.");
                        }
                        else if(a>n){
                            System.out.println("Too high.");
                        }
                        else{
                            System.out.println("Too low.");
                        }   
                    }
                    else{
                        System.out.println("Enter valid number.");
                    }
                }
            
                else{
                    System.out.println("maximum attempts reached game restarting again.");
                    flag1=false;
                    count=0;
                }
            }
        }
    }
}