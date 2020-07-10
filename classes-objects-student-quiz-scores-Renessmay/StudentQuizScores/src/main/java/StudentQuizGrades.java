
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Viktorija
 */
public class StudentQuizGrades {
    public static void main(String[] args){
    int min;
    UserIO userIO = new IO();
    
    Map<String, Double> grades= new HashMap();
        grades.put("Ester",9.0);
        grades.put("Judy",5.9);
        grades.put("Jaydan",10.0);
        grades.put("Greg",7.5);
    
        userIO.print("Welcome to Student Quiz Scores App!");
        for(;;){
        userIO.print("Please choose one of the following options(1-6):");
        int userin=userIO.readInt("1.List of students\n2.Add a student\n3.Remove a student\n4.List of quiz scores for a student\n5.Average score for a student\n6.Exit");
        if (userin==1){
            Set<String> keys = grades.keySet();
            for (String k : keys) {
                 System.out.println(k);
        }
            userIO.print("");
        }
        else if (userin==2){
            String user=userIO.readString("\nPlease enter Student name: ");
            grades.put(user,null);
            Set<String> keys = grades.keySet();
            userIO.print("Updated student list: ");
            for (String k : keys) {
                 System.out.println(k);
        }
            userIO.print("");
        }
        else if(userin==3){
            String user=userIO.readString("\nPlease enter Student name you wish to remove: ");
            grades.remove(user);
            Set<String> keys = grades.keySet();
             userIO.print("Updated student list: ");
            for (String k : keys) {
                 System.out.println(k);
            
        }
        userIO.print("");}
        
        else if(userin==4){
            String user=userIO.readString("\nPlease enter Student name you wish to see quiz scores of: ");
            double grade= grades.get(user);
            userIO.print("Grades of student "+user+" is: "+grade);
        }
        //else if (userin==5){
       //     String user=userIO.readString("\nPlease enter student name you wish to see average quiz score for: ");

        //}
        else if(userin==6){
            System.exit(0);
        }
        
        }
                }}
