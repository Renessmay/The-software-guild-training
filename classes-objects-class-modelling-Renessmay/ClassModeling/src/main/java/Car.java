/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Viktorija
 */
public class Car {
        
        private String model;
        private String color;
        private String carmake;
        private int horsepower;
        private int numberofcars;
        private int speed;

        
        public Car(){
            this.model=model;
            this.color=color;
            this.horsepower=horsepower;
            this.numberofcars=numberofcars;
            this.speed=speed;
            this.carmake=carmake;
        }

        public String setmodel(){
        return model;
    }
        public String setcolor(){
            return color;
        }
        public String setcarmake(){
            return carmake;
        }
        public int sethorsepower(){
            return horsepower;
        }
        public int setnumberofcars(){
            return numberofcars;
        }
        public int setspeed(){
            return speed;
        }
        
        //****
        public void getmodel(String model){
            this.model=model;
        }
        public void getcolor(String color){
            this.color=color;
        }
        public void getcarmake(String carmake){
            this.carmake=carmake;
        }
        public void sethorsepower(int horsepower){
            this.horsepower=horsepower;
        }
        public void setnumberofcars(int setnumberofcars){
            this.numberofcars=numberofcars;
        }
        public void setspeed(int speed){
            this.speed=speed;
        }
            public String dealership(){
                return carmake+model+horsepower+numberofcars;
            }
            public String gamecar(){
                return model+color+speed;
            }
        }
    

