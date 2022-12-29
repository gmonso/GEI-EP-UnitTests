package citizenmanagementplatform;

import data.DocPath;
import data.Goal;
import data.Nif;
import data.SmallCode;
import exceptions.OpenDocumentException;
import publicadministration.*;
import services.CAS;
import services.CertificationAuthority;
import services.GPD;
import services.JusticeMinistry;

import java.awt.*;
import java.io.File;
import java.io.IOException;
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

    //v---- SETTERS OF ALL INVOLVED SERVICES AND ELEMENT----v
    public void setJustMin(JusticeMinistry min) { //Select ministeri de justicia
        this.justMin = min;
    }

    public void setCAS(CAS cas) {
        this.CAS = cas;
    }

    public void setGPD(GPD gpd) {
        this.GPD = gpd;
    }

    public void setCertAuth(CertificationAuthority auth) {
        this.cerAuth = auth;
    }

    public void setNif(Nif nif) {
        this.userNif = nif;
    }

    //Mètodes que s'han de aplicar
    public void selectJusMin() {

    }

    public void selectProcedures() {

    }

    public void selectCriminalReportCertf() {

    }

    public void selectAuthMethod(byte opc) {

    }

    public void enterNIFandPINobt(Nif nif, Date valDate) {

    }

    public void enterPIN(SmallCode pin) {

    }

    private void enterForm(Citizen citz, Goal goal) {

    }

    private void realizePayment() {

    }

    private void enterCardData(CreditCard cardD) {

    }

    private void obtainCertificate() {

    }

    private void printDocument() {

    }

    private void registerPayment() {

    }

    private void openDocument(DocPath path) throws OpenDocumentException {
        try {
            Desktop.getDesktop().open(new File(String.valueOf(path)));
        } catch (IOException e) {
            throw new OpenDocumentException("Error opening document");
        }

    }

    private void printDocument(DocPath path) {

    }

}
