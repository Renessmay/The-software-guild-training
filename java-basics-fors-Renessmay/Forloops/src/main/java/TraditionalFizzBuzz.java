
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
public class TraditionalFizzBuzz {
    public static void main(String[] args){
        
        String userin;
        int user;
        
        Scanner in = new Scanner(System.in);
        
        System.out.print("How many units of fizzing and buzzing do you need in your life? ");
        userin=in.next();
        user=Integer.parseInt(userin);

        
        for (int i = 1; i <= user; i++) 
        {
            if (i%15==0){ 
                System.out.println("fizz buzz");
            user+=2;}
  
            else if (i % 3 == 0){ 
                System.out.println("fizz");
                    user++;}
            else if (i%5==0){ 
                System.out.println("buzz");
                    user++;}
            else
                System.out.println(i); 
    }
        System.out.println("TRADITION!");
}
}
