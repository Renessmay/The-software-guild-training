
import java.util.Collection;
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
public class StateCapitals {
    

    public void App(){
        
        Map<String, String> states = new HashMap<>();
        
        states.put("Alabama","Montgomery");
        states.put("Alaska","Juneau");
        states.put("Arizona","Pheonix");
        states.put("Arkansas","Little Rock");
        

        String Alabamacap=states.get("Alabama");
        String Alaskacap=states.get("Alaska");
        String Arizonacap=states.get("Arizona");
        String Arkansascap=states.get("Arkansas");
        
        System.out.println("STATES:\n======");
        
        Set<String> keys = states.keySet();
        
        for (String k : keys) {
            System.out.println(k);
}
        System.out.println("\nCAPITALS:\n======");
        Collection<String> capitals = states.values();
        
        for(String p: capitals){
            System.out.println(p);
        }
        
        System.out.println("\nSTATE/CAPITAL PAIRS:\n============");
        
        for (String k : keys) {
            System.out.println(k+" - "+states.get(k));
        
    }
    
    }
}

