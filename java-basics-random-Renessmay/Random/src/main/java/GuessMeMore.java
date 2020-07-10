
import java.util.Random;
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
public class GuessMeMore {
     public static void main(String[] args) {
        
        
        String usernumber;
        int usernr;
        
        Random mynumber = new Random();

        int nr = mynumber.nextInt(100 + 100) - 100;
        
        Scanner inputReader = new Scanner(System.in);
        
        System.out.print("I've chosen a number between -100 and 100. Betcha can't guess it!\n");
        System.out.print("Your guess: ");
        usernumber = inputReader.next();
        usernr = Integer.parseInt(usernumber);
        
        if(usernr<nr){
            System.out.println("Ha, nice try - too low! I chose "+nr+ ".");
           
        }
        if(usernr==nr){
            System.out.println("Wow, nice guess! That was it!");
        }
        if(usernr>nr){
            System.out.println("Too bad, way too high. I chose " +nr+".");
        }
    }
}
