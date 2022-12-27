package publicadministration;

import data.DigitalSignature;
import data.Goal;
import data.Nif;

public class CriminalRecordCertf { // Represents the Criminal Record Certificate

    private final Nif nif;
    private final String name;
    private final Goal goal;
    private final DigitalSignature digSign;
    private final CrimConvictionsColl crimConvs;

    public CriminalRecordCertf(Nif nif, String name, Goal goal, DigitalSignature digSign, CrimConvictionsColl crimConvs) {
        this.nif = nif;
        this.name = name;
        this.goal = goal;
        this.digSign = digSign;
        this.crimConvs = crimConvs;
    }

    public Nif getNif() {
        return nif;
    }

    public String getName() {
        return name;
    }

    public Goal getGoal() {
        return goal;
    }

    public DigitalSignature getDigSign() {
        return digSign;
    }

    public CrimConvictionsColl getCrimConvs() {
        return crimConvs;
    }

    @Override
    public String toString() {
        return "CriminalRecordCertf{" +
                "nif=" + nif +
                ", name='" + name + '\'' +
                ", goal=" + goal +
                ", digSign=" + digSign +
                ", crimConvs=" + crimConvs +
                '}';
    }
}
