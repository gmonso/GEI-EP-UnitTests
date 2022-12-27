package services;
import exceptions.*;
public interface GPD {// External service that represents the General Police Direction
    boolean verifyData(Citizen persData, Goal goal)
            throws IncorrectVerificationException, ConnectException;
}
