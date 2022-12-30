package services;

import data.Goal;
import exceptions.DigitalSignatureException;
import publicadministration.Citizen;
import publicadministration.CriminalRecordCertf;

import java.io.IOException;
import java.net.ConnectException;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class JustMinDouble implements JusticeMinistry {
    private final Set<CriminalRecordCertf> crimCertfs;

    public JustMinDouble() {
        crimCertfs = new HashSet<>();
    }

    @Override
    public CriminalRecordCertf getCriminalRecordCertf(Citizen pers, Goal g) throws IOException, DigitalSignatureException {
        for (CriminalRecordCertf crimCerf : this.crimCertfs) {
            if (Objects.equals(crimCerf.getNif().getNif(), pers.getNif().getNif()) && Objects.equals(crimCerf.getGoal().getGoal(), g.getGoal()) && Objects.equals(crimCerf.getName(), pers.getName())) {
                return crimCerf;
            }
            if (crimCerf.getDigSign().getSignature().length <= 0 || crimCerf.getDigSign() == null) {
                throw new DigitalSignatureException();
            }
        }
        throw new ConnectException();
    }

    public void add_CrimCertf(CriminalRecordCertf cer) {
        this.crimCertfs.add(cer);
    }
}
