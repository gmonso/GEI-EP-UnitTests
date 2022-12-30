package publicadministration;

import exceptions.NullArgumentException;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class CrimConvictionsColl {
    // Represents the total criminal convictions registered for a citizen
    private final Set<CrimConviction> crimConvs;


    public CrimConvictionsColl() {
        this.crimConvs = new HashSet<>();
        this.numConvs = 0;
    }

    public int getNumConvs() {
        return this.numConvs;
    }

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


    public void addCriminalConviction(CrimConviction crmC) {
        this.crimConvs.add(crmC);
        this.numConvs++;
    }

    public CrimConviction getCriminalConviction(Date date) {

        for (CrimConviction crim : this.crimConvs) {
            if (crim.getDate().equals(date)) {
                return crim;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "CrimConvictionsColl{" +
                "crimConvs=" + crimConvs +
                ", numConvs=" + this.crimConvs.size() +
                '}';
    }
}

