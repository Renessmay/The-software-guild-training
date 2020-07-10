/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Viktorija
 */
public class Triangle extends Shape{
    private int area;
    private int perimeter;
    private int basis;
    private int height;
    private int len1;
    private int len2;
    private int len3;
    
    @Override
    public int getArea() {
        return basis/height*2;
    }
    public void setArea(int area){
        this.area=area;
    }
    @Override
    public int getPerimeter() {
        return len1+len2+len3;
        
    }
    public void setPerimeter(int perimeter){
        this.perimeter=perimeter;
    }
    
}
    

