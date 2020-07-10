/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Viktorija
 */
public class Circle extends Shape{
    private int area;
    private int perimeter;
     @Override
    public int getArea() {
        return area*area*3;
    }
    public void setArea(int area){
        this.area=area;
    }
    
    @Override
    public int getPerimeter() {
        return perimeter*perimeter;
        
    }
    public void setPerimeter(int perimeter){
        this.perimeter=perimeter;
    }
}
