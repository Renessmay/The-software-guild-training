/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Viktorija
 */
public class Book {
  private String name;
  private String author;
  private int pages;
  private String release;
  
  public Book(){
      this.name=name;
      this.author=author;
      this.pages=pages;
      this.release=release;
  }
  public String setname(){
      return name;
  }
  public String setauthor(){
      return author;
      
  }
  public String setrelease(){
      return release;
      
  }
  public int setpages(){
      return pages;
  }
  
  public void getname(String name){
      this.name=name;
  }
  public void getauthor(String author){
      this.author=author;
      
  }
  public void getrelease(String release){
      this.release=release;
  }
  public void getpages(int pages){
      this.pages=pages;
  }
  public String publish(){
      return name+author+pages+ release;
  }
  public String library(){
      return name+author+pages;
  }
}
