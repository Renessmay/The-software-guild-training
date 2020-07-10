
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
public class BiggerBetterAdder {
        public static void main(String[] args){
        
        String int1;
        String int2;
        String int3;
        
        float nr1;
        float nr2;
        float nr3;
        
        Scanner inputReader = new Scanner(System.in);
        
        System.out.println("Please enter 1st numnber: ");
        int1 = inputReader.next();
        nr1 = Float.parseFloat(int1);
        
        System.out.println("Please enter 2nr number: ");
        int2 = inputReader.next();
        nr2 = Float.parseFloat(int2);
        
        System.out.println("Please enter 3rd number: ");
        int3 = inputReader.next();
        nr3 = Float.parseFloat(int3);
        
        float nr4 = nr1 + nr2 + nr3;
        
        System.out.println(nr1 + " + " + nr2 + " + " + nr3 + " = " + nr4);
    
}
}
