package services;

import data.Goal;
import exceptions.IncorrectVerificationException;
import publicadministration.Citizen;

import java.net.ConnectException;
import java.util.HashSet;
import java.util.Set;

public class GPDdobule implements GPD {
    Set<Citizen> citizens;
    public GPDdobule() {
        citizens = new HashSet<>();
    }
    @Override
    public boolean verifyData(Citizen persData, Goal goal) throws IncorrectVerificationException, ConnectException {
        if(persData == null || goal == null) throw new IncorrectVerificationException();
        for (Citizen c : this.citizens){
            if(persData.getNif() == c.getNif()){
                return true;
            }
        }
        throw new IncorrectVerificationException();
    }

    public void addCitizen(Citizen c){
        this.citizens.add(c);
    }
}
