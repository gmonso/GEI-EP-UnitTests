package services;

import data.Goal;
import publicadministration.Citizen;
import publicadministration.CriminalRecordCertf;

import java.net.ConnectException;

public interface JusticeMinistry { // External service for the Justice Ministry
    CriminalRecordCertf getCriminalRecordCertf(Citizen persD, Goal g)
            throws DigitalSignatureException, ConnectException;
}
