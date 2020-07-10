
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
public class StayPositive {
    public static void main(String[] args){
        
        String usernr;
        int number;
        
        Scanner input = new Scanner(System.in);
        
        System.out.print("Please enter starting value: ");
        usernr= input.next();
        number=Integer.parseInt(usernr);
        if(number>=0){
            System.out.println("Counting down...\n");

            while (number>=0){
                System.out.println(number);

                number--;
            }

            System.out.println("\nBlast off!");

    }
        else{
            System.out.println("The number is invalid");
        }
    }
    
}
