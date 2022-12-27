package publicadministration;

import java.util.*;

public class CrimConvictionsColl { // Represents the total criminal convictions registered for a citizen
        // Its components, that is, the set of criminal convictions
    private Set<CrimConviction> crimConvs;
    private int numConvs;
    public CrimConvictionsColl (){
        this.crimConvs = new HashSet<>();
        this.numConvs = 0;
    } // Initializes the object

    // the getters --V
    public int getNumConvs(){
        return this.numConvs;
    }
    public Set<CrimConviction> getCrimConvs(){
        return this.crimConvs;
    }
    public void addCriminalConviction (CrimConvictionsColl crmC){
        this.crimConvs.addAll(crmC.crimConvs);
        this.numConvs = this.numConvs + crmC.numConvs;
    }
    // Adds a criminal conviction
    public CrimConviction getCriminalConviction (Date date){
        for(CrimConviction crim : this.crimConvs){
            if(crim.getDate().equals(date)){
                return crim;
            }
        }
        System.out.println("There's no crim convection with that date.\n");
        return null;
    }
    // Gets a specific criminal conviction by date
    public String toString () {
        return("He has: " + this.numConvs + "Criminal convictions" + "which are" + this.crimConvs);
    } // Converts to String
}

