/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Viktorija
 */
public class IceCream {

        private String flavor;
        private String shape;
        private float price;
        
        public IceCream(){
            this.flavor=flavor;
            this.shape=shape;
            this.price=price;
            
        }
        public String setflavor(){
            return flavor;
        }
        public String setshape(){
            return shape;
        }
        public float setprice(){
            return price;
        }
        
        
        public void getflavor(String flavor){
            this.flavor=flavor;
            
        }
        public void getshape(String shape){
            this.shape=shape;
            
        }
        public void getprice(float price){
            this.price=price;
        }
        
        public String make(){
            return flavor+shape;
        }
        public String store(){
            return flavor+shape+price;
        }
    
}
           

