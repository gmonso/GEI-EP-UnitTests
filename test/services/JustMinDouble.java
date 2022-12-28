package services;

import data.DigitalSignature;
import data.Goal;
import exceptions.*;
import publicadministration.Citizen;
import publicadministration.*;

import java.net.ConnectException;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class JustMinDouble implements JusticeMinistry{
    private final Set<CriminalRecordCertf> crimCertfs;
    public JustMinDouble(){
        crimCertfs = new HashSet<>();
    }
    @Override
    public CriminalRecordCertf getCriminalRecordCertf(Citizen pers, Goal g) throws ConnectException, DigitalSignatureException {
        for(CriminalRecordCertf crimCerf : this.crimCertfs){
            if(crimCerf.getNif() == pers.getNif() && crimCerf.getGoal() == g && Objects.equals(crimCerf.getName(), pers.getName())){
                return crimCerf;
            }
            if(crimCerf.getDigSign().getSignature().length <= 0 || crimCerf.getDigSign() == null){
                throw new DigitalSignatureException();
            }
        }
        throw new ConnectException();
    }
    public void add_CrimCertf(CriminalRecordCertf cer){
        this.crimCertfs.add(cer);
    }
}
