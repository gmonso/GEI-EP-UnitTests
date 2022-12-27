package services;
import data.*;
import exceptions.*;
import publicadministration.*;

public interface JusticeMinistry { // External service for the Justice Ministry
    CriminalRecordCertf getCriminalRecordCertf (Citizen persD, Goal g)
            throws DigitalSignatureException,ConnectException;
}
