
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
public class App extends SimpleCalculator{

    
    public static void main(String[] args){
        
        String answer;
        float sum;
        
        SimpleCalculator calc= new SimpleCalculator();
        SimpleCalculator.add addi = calc.new add();
        SimpleCalculator.sub subi= calc.new sub();
        SimpleCalculator.multi multi = calc.new multi();
        SimpleCalculator.div divi= calc.new div();
        
        Scanner userinput = new Scanner(System.in);
        System.out.println("Simple Math Calculator!");
        System.out.println("What Operation would you like to perform? ");
        System.out.println("Addition?: A  Subtraction?: S  \nMultiplication?: M  Division?: D");
        
        answer = userinput.nextLine();
        
        System.out.println("You have selected "+answer+".\nPlease enter 2 numbers:");
        
         if(answer.equals("Addition")||answer.equals("A")){
            sum = addi.addition(userinput.nextInt(), userinput.nextInt());
            System.out.println("Answer is: "+ sum);
        }
        else if(answer.equals("Subtraction")||answer.equals("S")){
            sum = subi.subtraction(userinput.nextInt(), userinput.nextInt());
            System.out.println("Answer is: "+ sum);
        }
        else if(answer.equals("Multiplication")||answer.equals("M")){
            sum = multi.multiplication(userinput.nextInt(), userinput.nextInt());
            System.out.println("Answer is: "+ sum);
        }
        else if(answer.equals("division")||answer.equals("D")){
            sum = divi.division(userinput.nextInt(), userinput.nextInt());
            System.out.println("Answer is: "+ sum);
        }
        }
          
    }

