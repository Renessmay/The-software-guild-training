
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
public class BirthStones {
    public static void main(String[] args) {
        
        String usernumber;
        int usernr;
        
        Scanner inputReader = new Scanner(System.in);
        
        System.out.print("What month's birthstone do you want to know? ");
        usernumber = inputReader.next();
        usernr = Integer.parseInt(usernumber);
        
        if(usernr==1){
            System.out.println("January's birthstone is Garnet.");
        }
        else if(usernr==2){
            System.out.println("February's birthstone is Amethyst.");
        }
        else if(usernr==3){
            System.out.println("March's birthstone is Aquamarine.");
        }
        else if(usernr==4){
            System.out.println("April's birthstone is Diamond.");
        }
        else if(usernr==5){
            System.out.println("May's birthstone is Emerald.");
        }
        else if(usernr==6){
            System.out.println("June's birthstone is Pearl.");
        }
        else if(usernr==7){
            System.out.println("July's birthstone Ruby.");
        }
        else if(usernr==8){
            System.out.println("August's birthstone Peridot.");
        }
        else if(usernr==9){
            System.out.println("September's birthstone Sapphire.");
        }
        else if(usernr==10){
            System.out.println("October's birthstone Opal.");
        }
        else if(usernr==11){
            System.out.println("November's birthstone Topaz.");
        }
        else if(usernr==12){
            System.out.println("December's birthstone Turquoise.");
        }
        else{
            System.out.println("I think you must be confused, "+usernr+" doesn't match a month.");
        }
    }
}
