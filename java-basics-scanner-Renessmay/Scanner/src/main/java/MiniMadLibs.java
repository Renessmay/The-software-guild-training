
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
public class MiniMadLibs {
    public static void main(String[] args){
        
        String noun;
        String adj;
        String noun2;
        String number;
        String adj2;
        String plurnoun;
        String plurnoun1;
        String plurnoun2;
        String verpres;
        String verbpast;
        
        Scanner inputReader = new Scanner(System.in);
        
        System.out.println("Let's play MAD LIBS!\n");
        System.out.print("I need a noun: ");
        noun = inputReader.next();
        
        System.out.print("Now an adjective: ");
        adj = inputReader.next();
        
        System.out.print("Another noun: ");
        noun2 = inputReader.next();
        
        System.out.print("And a number: ");
        number = inputReader.next();
        
        System.out.print("Another adjective: ");
        adj2 = inputReader.next();
        
        System.out.print("A plural noun: ");
        plurnoun = inputReader.next();
        
        System.out.print("Another one: ");
        plurnoun1 = inputReader.next();
        
        System.out.print("One more: ");
        plurnoun2 = inputReader.next();
        
        System.out.print("A verb (infinitive form): ");
        verpres = inputReader.next();
        
        System.out.print("Same verb (past participle)");
        verbpast = inputReader.next();
        
        
        System.out.println("*** NOW LETS GET MAD (libs) ***\n");
        
        System.out.println(noun+": the "+adj+" frontier. These are the voyages of the starship "+noun2+". Its "+number+"-year mission: to explore strage "+adj2+" "+plurnoun
        +", to seek out "+adj2+" "+plurnoun1+" and "+adj2+ " "+plurnoun2+", to boldly "+verpres+" where no one has "+verbpast+" before.");
        
    }
}
