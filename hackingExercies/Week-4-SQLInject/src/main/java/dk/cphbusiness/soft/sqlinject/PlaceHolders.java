/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.soft.sqlinject;

/**
 *
 * @author Bo
 */
public class PlaceHolders {
    
    // De 3 metoder viser primatize forespørgsel
    //Ved hvad tabel navnet skal være
    public static String field(String name, String... whitelist) { //string... betyder kommer ind som array.
        //System.out.println(whitelist[0]);
        
        for (String option : whitelist) { //Denne virker også på collections. Er det samme som for loop.
            if(name.equals(option))
                return name;
        }
        
        // ved runtime exceptin behøver man ikke skrive throws
        throw new IllegalArgumentException("Bad input...");
    }
    //
    // Skal escape ' (tics)
    public static String string(String value) {
        return value.replace("'", "\'");
    }
    
    // Formater input.
    public static String stringList2(String... values) {
        String result = ""; // Første gang den kører er den tom. Derefter først value. Tilføjer komma. Næste value osv.
        for (String value : values) {
            if(result.isEmpty()) result = string(value); // 
            else result += ", " + string(value);
        }
        return "(" + result + ")";
    }
    
}