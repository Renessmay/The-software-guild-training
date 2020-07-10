
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Viktorija
 */
public class LazyTeenager {
        public static void main(String[] args) {

      int clean=1;
              
        while(clean <= 7){
            
            System.out.println("Clean your room!! x"+clean);
            
            Random time = new Random();
            
            int rtime = time.nextInt();
            
            if(rtime < 7){
                System.out.println("FINE! I'LL CLEAN MY ROOM. BUT I REFUSE TO EAT MY PEAS.");
                break;
            }
            else if(clean==7){
                System.out.println("Clean your room!! That's IT, I'm doing it!!! YOU'RE GROUNDED AND I'M TAKING YOUR XBOX!");
                break;
            }
           clean++;
    
}
        }}
