package citizenmanagementplatform;

import services.*;
import publicadministration.*;
import data.*;

import java.util.Date;
public class UnifiedPlatform {
    public CertificationAuthority cerAuth;
    public CAS CAS;
    public GPD GPD;
    public JusticeMinistry justMin;
    public Nif userNif;
    public Citizen citizen;
    public CreditCard CCard;
    public CardPayment CPay;
    public CrimConviction CrimConv;
    public CrimConvictionsColl CrimColl;
    public CriminalRecordCertf CrimCertf;
    public PDFDocument pdfD;
    public UnifiedPlatform(JusticeMinistry jus, CAS cas, GPD police, CertificationAuthority cerAuth) {
        this.justMin = jus;
        this.CAS = cas;
        this.GPD = police;
        this.cerAuth = cerAuth;
    }
    public void selectProcedures () {

    }
    public void selectCriminalReportCertf () {

    }
    public void selectAuthMethod (byte opc) {

    }
    public void enterNIFandPINobt (Nif nif, Date valDate) {

    }
    public void enterPIN (SmallCode pin) {

    }
    private void enterForm (Citizen citz, Goal goal) {

    }

    private void realizePayment () {

    }
    private void enterCardData (CreditCard cardD) {

    }

    private void obtainCertificate () {

    }
    private void printDocument () {

    }
    private void registerPayment () {

    }
    private void openDocument (DocPath path) {

    }
    private void printDocument (DocPath path) {

    }

}
