package services;

import data.Goal;
import exceptions.DigitalSignatureException;
import publicadministration.Citizen;
import publicadministration.CriminalRecordCertf;

import java.net.ConnectException;

public interface JusticeMinistry { // External service for the Justice Ministry
    CriminalRecordCertf6 getCriminalRecordCertf (Citizen persD, Goal g)
            throws DigitalSignatureException,ConnectException;
}
