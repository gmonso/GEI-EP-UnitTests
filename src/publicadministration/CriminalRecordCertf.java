package publicadministration;

import data.DigitalSignature;
import data.DocPath;
import data.Goal;
import data.Nif;
import exceptions.GoalTypeException;
import exceptions.NullArgumentException;
import exceptions.WrongFormatException;

import java.io.File;
import java.util.Date;

public class CriminalRecordCertf extends PDFDocument { // Represents the Criminal Record Certificate

    private final Nif nif;
    private final String name;
    private final Goal goal;
    private final DigitalSignature digSign;
    private final CrimConvictionsColl crimConvs;

    public CriminalRecordCertf (Nif nif, String name, Goal g, DigitalSignature ds, CrimConvictionsColl crmC) throws NullArgumentException, WrongFormatException, GoalTypeException {
        super();
        this.nif = nif;
        this.name = name;
        this.goal = new Goal("123", Goal.GoalType.OTHER);
        this.digSign = new DigitalSignature(new byte[4]);
        this.crimConvs = new CrimConvictionsColl();
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
