package services;

import data.Nif;
import data.SmallCode;
import exceptions.AnyMobileRegisteredException;
import exceptions.IncorrectValDateException;
import exceptions.NifNotRegisteredException;
import exceptions.NotValidPINException;

import java.net.ConnectException;
import java.util.Date;

public interface CertificationAuthority {// External service that represents the different trusted certification entities

    boolean sendPIN(Nif nif, Date date) throws NifNotRegisteredException,
            IncorrectValDateException, AnyMobileRegisteredException,
            ConnectException;

    boolean checkPIN(Nif nif, SmallCode pin) throws NotValidPINException,
            ConnectException;
}

