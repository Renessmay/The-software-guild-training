import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/**
 *
 * @author Viktorija
 */
public class StateCapitalsApp{
    
    // method to collect input from the user
    // will keep prompting until a valid input is entered, where it will
    // break
    public static float collectUserInput(String prompt) {
        Scanner in = new Scanner(System.in);
        System.out.println(prompt);
        int inputNum;
        do {
            try {
                inputNum = Integer.parseInt(in.nextLine());
                return inputNum;
            }
            catch (NumberFormatException ex) {
                System.out.println("Error, invalid input, please try again: ");
            }
        } while(true);
    }
    
    public static void main(String[] args) throws Exception {
        
        // initialise scanner for user input, and reading of txt file
        Scanner in = new Scanner(System.in);
        Scanner sc = new Scanner(new BufferedReader(new FileReader("MoreStateCapitals.txt")));
        // declares variables to parse int values read in from txt file
        // as well as count of state
        
        int pop;
        float mile;
        int stateCount = 0;
        // declares the object we can use to iterate through
        Capital currentCapital = new Capital();
        // declare array to hold split txt lines
        String[] parts;
        // declares a hashmap to fufill map interface, named stateCapitals
        // must declare the Capital class not generic object
        Map<String, Capital> stateCapitals = new HashMap<>();
        // declares a set which will hold the states (keys) in the hashmap
        Set<String> states = stateCapitals.keySet();
        // declares a collection to hold the capital objects to be passed as values
        // must declare capital class not generic object
        Collection<Capital> capitals = stateCapitals.values();
        // reads the data in from the file, setting capital fields
        
        while (sc.hasNextLine()) {
            String currentLine = sc.nextLine();
            // cleans the txt file, getting rid of metadata(?)
            // and backslash on the end, as well as } on last line
            if (currentLine.contains("::")) {
                String cleanLine = currentLine.replace("\\", "");
                cleanLine = cleanLine.replace("}", "");
                parts = cleanLine.split("::");
                // assigns statename, which will be the key
                String stateName = parts[0];
                Capital cap = new Capital(parts[1]);
                // need to parse integers for pop and sq mileage
                // as well as update state count
                pop = Integer.parseInt(parts[2]);
                mile = Float.parseFloat(parts[3]);
                stateCount ++;
                // setting the pop and square mileage for each
                // Capital object that will be created
                cap.setpop(pop);
                cap.setmile((int) mile);
                // places state name and capital object in the hashmap
                stateCapitals.put(stateName, cap);
            }
        }
        
        System.out.println(stateCount+" STATE/CAPITAL PAIRS LOADED.\n=========================================================");
        // iterates through the states
        // using get method to pull the info from the objects
        for (String s: states) {
           // System.out.println(s);
            currentCapital = stateCapitals.get(s);
            System.out.println(s + " - " + currentCapital.getname()
                    + " | Population: " + currentCapital.getpop()
                    + " | Area: " + currentCapital.getmile());
        }
        // method that collects input from user
        float minpop = collectUserInput("Please enter a minimum pop: ");
        // iterates through the states, getting each states capital
        // using get method to compare pop
        System.out.println("The capitals with more pop than your limit are: ");
        for (String s: states) {
            currentCapital = stateCapitals.get(s);
            if (currentCapital.getpop() > minpop) {
                System.out.println(s + ": " + currentCapital.getname());
            }
        }
        // collcting user input using method
        float maxmile = collectUserInput("Please enter a maximum square mileage: ");
        System.out.println("The capitals with more square mileage "
                + "less than your limit are: ");
        // iterates through the states, using get to get the capital
        // again using get method to get sq mileage and compare
        for (String s: states) {
            currentCapital = stateCapitals.get(s);
            if (currentCapital.getmile() < maxmile) {
                System.out.println(s + ": " + currentCapital.getname());
            }
        }
    }
}