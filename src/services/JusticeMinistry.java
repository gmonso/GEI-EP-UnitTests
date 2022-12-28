package services;

import data.Goal;
import exceptions.DigitalSignatureException;
import publicadministration.Citizen;
import publicadministration.CriminalRecordCertf;

import java.net.ConnectException;

import exceptions.*;
import publicadministration.*;
import data.*;
public interface JusticeMinistry { // External service for the Justice Ministry
    CriminalRecordCertf getCriminalRecordCertf (Citizen pers, Goal g)
            throws DigitalSignatureException,ConnectException;
}
