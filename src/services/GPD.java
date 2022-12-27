package services;
import exceptions.*;
import data.*;
import publicadministration.*;
public interface GPD {// External service that represents the General Police Direction
    boolean verifyData(Citizen persData, Goal goal)
            throws IncorrectVerificationException, ConnectException;
}
