package publicadministration;

import exceptions.NullArgumentException;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class CrimConvictionsColl { // Represents the total criminal convictions registered for a citizen
    // Its components, that is, the set of criminal convictions
    private final Set<CrimConviction> crimConvs;


    public CrimConvictionsColl() {
        this.crimConvs = new HashSet<>();
    } // Initializes the object

    // the getters --V

    public Set<CrimConviction> getCrimConvs() {
        return this.crimConvs;
    }

    public int getNumConvs() {
        return this.crimConvs.size();
    }

    public void addCriminalConviction(CrimConviction crmC) throws NullArgumentException {
        if (crmC == null) throw new NullArgumentException("Crim Conv Coll value Is null");
        if (correctFOrm(crmC))
            this.crimConvs.add(crmC);
    }

    private boolean correctFOrm(CrimConviction crmC) throws NullArgumentException {
        if (crmC.getDate() == null || crmC.getOffense() == null || crmC.getSentence() == null) {
            throw new NullArgumentException("Element a CrimConv null");
        }
        return true;
    }

    // Adds a criminal conviction
    public CrimConviction getCriminalConviction(Date date) throws NullArgumentException {
        if (date == null) throw new NullArgumentException("Date value Is null");
        for (CrimConviction crim : this.crimConvs) {
            if (crim.getDate().equals(date)) {
                return crim;
            }
        }
        return null;
    }

    // Gets a specific criminal conviction by date

    @Override
    public String toString() {
        return "CrimConvictionsColl{" +
                "crimConvs=" + crimConvs +
                ", numConvs=" + this.crimConvs.size() +
                '}';
    }
}

