package services;

import data.Nif;
import data.SmallCode;
import exceptions.*;

import java.awt.*;
import java.net.ConnectException;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class CertAuthDouble implements CertificationAuthority{

    HashMap<String, SmallCode> userPins;
    public CertAuthDouble(){
        userPins = new HashMap<>();
    }
    @Override
    public boolean sendPIN(Nif nif, Date date) throws NifNotRegisteredException, IncorrectValDateException, AnyMobileRegisteredException, ConnectException, NullArgumentException, WrongFormatException {
        SmallCode small = null;
        int b = (int)(Math.random()*(999-101+1)+101);
        small = new SmallCode(small.toString());
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
}
