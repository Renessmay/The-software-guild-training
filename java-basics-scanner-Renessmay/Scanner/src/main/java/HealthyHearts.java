
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
public class HealthyHearts {
    public static void main(String[] args){

        String age;
        float age1;
        float maximum;
        float target1 = 85;
        float target2 = 145;
        
        Scanner inputReader = new Scanner(System.in);
        
        System.out.println("What is your age? ");
        age = inputReader.next();
        age1 = Float.parseFloat(age);
        
        maximum = 220-age1;
        
        System.out.println("Your maximum heart rate should be "+maximum+" beats per minute.");
        System.out.println("Your target HR zone is "+target1+" - "+target2+" beats per minute.");
                
             
    
}
}