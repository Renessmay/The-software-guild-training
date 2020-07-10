
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Viktorija
 */
public class TriviaNight {
    public static void main(String[] args) {
        
        String ans1;
        String ans2;
        String ans3;
        int ans11;
        int ans22;
        int ans33;
        int correct=0;
        
        Scanner inputReader = new Scanner(System.in);
        
        System.out.println("It's TRIVIA NIGHT! Are you ready?!\n");
        System.out.print("FIRST QUESTION!\n" +
                            "What is the Lowest Level Programming Language?\n" +
                            "1) Source Code		2) Assembly Language\n" +
                            "3) C#			4) Machine Code\n" +
                            "\n" +
                            "YOUR ANSWER: ");
        ans1 = inputReader.nextLine();
        ans11= Integer.parseInt(ans1);
        
        System.out.print("SECOND QUESTION!\n" +
                            "Website Security CAPTCHA Forms Are Descended From the Work of?\n" +
                            "1) Grace Hopper		2) Alan Turing\n" +
                            "3) Charles Babbage		4) Larry Page\n" +
                            "\n" +
                            "YOUR ANSWER: ");
        
        ans2 = inputReader.nextLine();
        ans22 = Integer.parseInt(ans2);
        
        System.out.print("LAST QUESTION!\n" +
                            "Which of These Sci-Fi Ships Was Once Slated for a Full-Size Replica in Las Vegas?\n" +
                            "1) Serenity		2) The Battlestar Galactica\n" +
                            "3) The USS Enterprise	4) The Millennium Falcon\n" +
                            "\n" +
                            "YOUR ANSWER: ");
        ans3 = inputReader.nextLine();
        ans33 = Integer.parseInt(ans3);
        
        
        if(ans11==4){
            correct++;
        }
        else{
            ;
        }
        if(ans22==2){
            correct++;
        }
        else{
            ;
        }
        if(ans33==3){
            correct++;
        }
        else{
            ;
        }
        
        if(correct>0){
            System.out.println("Nice job - you got "+correct+ " correct!");
        }
        else{
            System.out.println("Sadly, you got "+correct+" correct...");
        }
    }
}
