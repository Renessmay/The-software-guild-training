
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
public class AllTheTrivia {
    public static void main(String[] args){
        
        String Question1;
        String Question2;
        String Question3;
        String Question4;
        
        Scanner inputReader = new Scanner(System.in);
        
        System.out.print("What unit is equivalent to 1,024 Gigabytes? ");
        Question1 = inputReader.next();
        
        System.out.print("Which planet is the only one that rotates clockwise in our Solar System? ");
        Question2 = inputReader.next();
        
        System.out.print("The largest volcano ever discovered in our Solar System is located on which planet? ");
        Question3 = inputReader.next();
        
        System.out.print("What is the most abundant element in the earth's atmosphere? ");
        Question4 = inputReader.next();
        
        System.out.println("\nWow, 1,024 Gigabytes is a "+Question3+"!");
        System.out.println("I didn't know that the largest ever volcano was discovered on "+Question1+"!");
        System.out.println("That's amazing that "+Question2+" is the most abundant element in the atmosphere...");
        System.out.println(Question4+" is the only planet that rotates clockwise, neat!");
    }
    
}
