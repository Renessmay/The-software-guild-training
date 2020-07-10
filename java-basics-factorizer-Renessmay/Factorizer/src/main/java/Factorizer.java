
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
public class Factorizer {
    public void Fact(){
        
        Scanner in=new Scanner(System.in);
        
        String userin;
        int user;
        int factors=0;
        int sum=0;
        boolean flag=false;
        
        System.out.print("What number would you like to factor? ");
        userin = in.next();
        user = Integer.parseInt(userin);
        
        System.out.println("The factors of "+user+" are:");
        
        for(int loop =1; loop < user; loop++){
            if  (user % loop ==0){
                factors++;
                System.out.print(loop+" ");
                sum = sum +loop;
                flag=true;
         
            }
        }
        
        System.out.println("\n"+user+" has "+factors+" factors.");
        
        if (sum == user) {
			System.out.println(user+" is a Perfect Number");
		}
	else {
		System.out.println(user+" is NOT a Perfect Number");
		}
        
        if(!flag){
          System.out.println(user + " is a prime number.");
        }
          else{
            System.out.println(user + " is not a prime number.");
        }
    }
}
    

