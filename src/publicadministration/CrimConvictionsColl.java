package publicadministration;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class CrimConvictionsColl {
    // Represents the total criminal convictions registered for a citizen
    private final Set<CrimConviction> crimConvs;
    private int numConvs;

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
        System.out.println("There's no crim convection with that date.\n");
        return null;
    }

    @Override
    public String toString() {
        return "CrimConvictionsColl{" +
                "crimConvs=" + crimConvs +
                ", numConvs=" + numConvs +
                '}';
    }
}

