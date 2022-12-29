package services;

import data.Goal;
import exceptions.IncorrectVerificationException;
import publicadministration.Citizen;

import java.net.ConnectException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class GPDdobule implements GPD {
    Set<Citizen> citizens;
    HashMap<String, String> citNgoals;
    public GPDdobule() {
        citizens = new HashSet<>();
        citNgoals = new HashMap<>();
    }
    @Override
    public boolean verifyData(Citizen persData, Goal goal) throws IncorrectVerificationException, ConnectException {
        if(persData == null || goal == null) throw new IncorrectVerificationException();
        for (Citizen c : this.citizens){
            if(persData.getNif() == c.getNif()){
                citNgoals.put(persData.getNif().getNif(), goal.getGoal());
                return true;
            }
        }
        throw new IncorrectVerificationException();
    }

    public void addCitizen(Citizen c){
        this.citizens.add(c);
    }
}
