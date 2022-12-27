package publicadministration;

import data.DigitalSignature;
import data.DocPath;
import data.Goal;
import data.Nif;

import java.io.File;
import java.util.Date;

public class CriminalRecordCertf extends PDFDocument { // Represents the Criminal Record Certificate

    private final Nif nif;
    private final String name;
    private final Goal goal;
    private final DigitalSignature digSign;
    private final CrimConvictionsColl crimConvs;

    public CriminalRecordCertf(Date creatDate, DocPath path, File file, Nif nif, String name, Goal goal, DigitalSignature digSign, CrimConvictionsColl crimConvs) {
        super(creatDate, path, file);
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
