/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Viktorija
 */

public class House {
    
   public class GPSHouse {
    private String address;
    private String coordinates;
    private String area;
    
    // Constructor that takes paramenters as arguments to set the
    // address for this particular house
    public GPSHouse(String address, String coordinates, String area) {
        this.address= address;
        this.coordinates = coordinates;
        this.area = area;
    }
    
    // accessor/getter. Returns the value requested, allows data hiding
    public String getaddress() {
        return address;
    }
    public String getcoordinates() {
        return coordinates;
    }
    public String getarea() {
        return area;
    }
    
    // we don’t want users of the gps to be able to change particular house
    // address etc as could lead to incorrect info. Want it to be read only
    public String location() {
        return address + coordinates + area;
    }
}
   
   public class ModelHouse {
    private float width;
    private float height;
    private float length;
    
    // Constructor that takes paramenters as arguments to set the
    // width, height, and length for this particular object
    public ModelHouse(float widthIn, float heightIn, float lengthIn) {
        this.width = widthIn;
        this.height = heightIn;
        this.length = lengthIn;
    }
    
    // accessor/getter. Returns the value requested, allows data hiding
    public float getWidth() {
        return width;
    }
    public float getHeight() {
        return height;
    }
    public float getLength() {
        return length;
    }
    
    // modifier/setter. Allows the changing of properties while data hiding
    // type void as it doesn’t return a value
    // this and dot allows accessing the properties of this particular object
    public void setWidth(float width) {
        this.width = width;
    }
    public void setHeight(float height) {
        this.height = height;
    }
    public void setLength(float length) {
        this.width = length;
    }
    
    // unsure of how to procede, can’t access width etc due to data hiding?
    // need to get?
    public float area() {
        return getWidth()*getLength();
    }
    public float volume() {
        return getWidth()*getHeight()*getLength();
    }
}

               
}


