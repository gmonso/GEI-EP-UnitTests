package services;

import data.Goal;
import exceptions.BadPathException;
import exceptions.DigitalSignatureException;
import publicadministration.Citizen;
import publicadministration.CriminalRecordCertf;

import java.io.IOException;

public interface JusticeMinistry { // External service for the Justice Ministry
    CriminalRecordCertf getCriminalRecordCertf(Citizen pers, Goal g)
            throws DigitalSignatureException, IOException, BadPathException;
}
