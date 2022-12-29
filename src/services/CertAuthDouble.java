package services;

import data.Nif;
import data.PhoneNumber;
import data.SmallCode;
import exceptions.*;
import publicadministration.*;

import java.awt.*;
import java.net.ConnectException;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class CertAuthDouble implements CertificationAuthority{

    HashMap<String, SmallCode> userPins;
    Set<Citizen> citi;
    HashMap<String, PhoneNumber> citizensPhones;
    public CertAuthDouble(){
        userPins = new HashMap<>();
        citi = new HashSet<>();
        citizensPhones = new HashMap<>();
    }
    @Override
    public boolean sendPIN(Nif nif, Date date) throws NifNotRegisteredException, IncorrectValDateException, AnyMobileRegisteredException, ConnectException, NullArgumentException, WrongFormatException {
        checkNif(nif);
        checkValDate(date);
        if(!citizensPhones.containsKey(nif.getNif())) throw new AnyMobileRegisteredException();
        SmallCode small = null;
        int b = (int)(Math.random()*(999-101+1)+101);
        small = new SmallCode(String.valueOf(b));
        userPins.put(nif.getNif(), small);
        return true;
    }
    @Override
    public boolean checkPIN(Nif nif, SmallCode pin) throws NotValidPINException, ConnectException, NifNotRegisteredException {
        if(!userPins.containsKey(nif.getNif())){
            throw new NifNotRegisteredException();
        }
        if(userPins.get(nif.getNif()) != pin){
            throw new NotValidPINException();
        }
        return true;

    }

    public SmallCode getUserPin(Nif nif) throws NifNotRegisteredException {
        if(!userPins.containsKey(nif.getNif())){
            throw new NifNotRegisteredException();
        }else{
            return userPins.get(nif.getNif());
        }
    }
    public void addCitizen(Citizen c){
        citi.add(c);
    }
    public void addPhoneNumer(PhoneNumber ph, Nif nif){
        citizensPhones.put(nif.getNif(), ph);
    }
    public void checkValDate(Date date) throws IncorrectValDateException {
        boolean correct = false;
        for(Citizen c : this.citi){
            if(c.getnifDate() == date){
                correct = true;
            }
        }
        if(!correct) throw new IncorrectValDateException();
    }

    public void checkNif(Nif nif) throws NifNotRegisteredException {
        boolean exists = false;
        for(Citizen c : this.citi){
            if(c.getNif() == nif){
                exists = true;
            }
        }
        if(!exists) throw new NifNotRegisteredException();
    }

}
