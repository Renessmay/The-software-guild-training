/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Viktorija
 */
public class Square extends Shape{
    private int area;
    private int perimeter;
    
   @Override
    public int getArea(){
        return area*area;
        }
    public void setArea(int area){
        this.area=area;
    }
    
    @Override
    public int getPerimeter(){
        return perimeter*4;
    }
    public void setPerimeter(int perimeter){
        this.perimeter=perimeter;
    }
    
    }
    

