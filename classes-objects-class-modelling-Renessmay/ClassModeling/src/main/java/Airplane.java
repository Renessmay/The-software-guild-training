/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Viktorija
 */
public class Airplane {

       private String planemodel;
       private String arrival;
       private String departure;
       private int speed;
       private String color;
       private String size;
   
   public Airplane(){
       this.planemodel = planemodel;
       this.arrival = arrival;
       this.departure = departure;   
       this.speed = speed;
       this.color=color;
       this.size=size;
             
   }
    public String getplanemodel(){
        return planemodel;
    }
    public String getarrival(){
        return arrival;
    }
    public String getdeparture(){
        return departure;
    }
    public int getspeed(){
        return speed;
    }
    public String getcolor(){
        return color;
    }
    public String getsize(){
        return size;
    }
    
     // ***
    public void setplanemodel(String planemodel){
        this.planemodel = planemodel;
    }
    public void setarrival(String arrival){
        this.arrival = arrival;
    }
    public void setdeparture(String departure){
        this.departure = departure;
    }
    public void setspeed(int speed){
        this.speed=speed;
    }
    public void setcolor(String color){
        this.color=color;
    }
    public void setsize(String size){
        this.size=size;
    }
    
    // ***
        public String info(){
         return planemodel+arrival+departure;
     }
        
        public String aircraft(){
            return planemodel+color+size+speed;
        }
    }

