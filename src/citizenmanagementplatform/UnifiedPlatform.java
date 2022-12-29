package citizenmanagementplatform;

import exceptions.*;
import services.*;
import publicadministration.*;
import data.*;

import java.math.BigDecimal;
import java.net.ConnectException;
import java.nio.Buffer;
import java.util.Date;
import java.util.HashMap;
public class UnifiedPlatform {

    public CertAuthDouble cerAuth;
    public CASdouble CAS;
    public GPDdobule GPD;
    public JustMinDouble justMin;

    public Citizen citizen;
    public CreditCard CCard;
    public CardPayment CPay;
    public CrimConviction CrimConv;
    public CrimConvictionsColl CrimColl;

    public String AuthMethod;
    public PDFDocument pdfD;
    public HashMap<String, SmallCode> usersPins;
    public Goal g;
    public UnifiedPlatform(JusticeMinistry jus, CAS cas, GPD police, CertificationAuthority cerAuth) {
        this.justMin = (JustMinDouble) jus;
        this.CAS = (CASdouble) cas;
        this.GPD = (GPDdobule) police;
        this.cerAuth = (CertAuthDouble) cerAuth;
    }
    public void selectJusMin(){
        System.out.println("User select the Justice Ministry");
    }
    public void selectProcedures () {
        System.out.println("User select procedures");
    }
    public void selectCriminalReportCertf () {
        System.out.println("User select get the Criminal Record Certificate");
    }
    public void selectAuthMethod (byte opc) {
        if(opc == 0){
            this.AuthMethod = "CLAVE_PIN";
        }else if(opc == 1){
            this.AuthMethod = "CLAVE_PERMANENTE";
        }else{
            this.AuthMethod = "CERTIFICADO_DIGITAL";
        }
    }
    public void enterNIFandPINobt (Nif nif, Date valDate) throws IncorrectValDateException, NifNotRegisteredException, AnyMobileRegisteredException, NullArgumentException, ConnectException, WrongFormatException {
        if(this.cerAuth.sendPIN(nif, valDate)) System.out.println("Pin sent successfully!");
        SmallCode pin = this.cerAuth.getUserPin(nif);
        usersPins.put(nif.getNif(), pin);
    }
    public void enterPIN (SmallCode pin) throws NotValidPINException, NifNotRegisteredException, ConnectException {
        String userDni;
        if(usersPins.containsValue(pin)) {
            boolean x = this.cerAuth.checkPIN(citizen.getNif(), pin);
            if (x) System.out.println("PIN correct by user. Needs verification with police and make form");
        }
    }
    private void enterForm (Citizen citz, Goal goal) throws IncorrectVerificationException, ConnectException, IncorrectFormException {
        if(citz == null || goal == null){
            throw new IncorrectFormException();
        }
        if(this.GPD.verifyData(citz, goal))
            System.out.println("Form entered and data verified.");
    }
    private void realizePayment () {
        System.out.println("User is ready for card payment.");
    }
    private void enterCardData (CreditCard cardD) throws NotValidPaymentDataException, InsufficientBalanceException, ConnectException, IncorrectFormException {
        boolean x = this.CAS.askForApproval("Tranferece", cardD, new Date(2,2,2), new BigDecimal(20));
        if(x) System.out.println("Card data introduced and verified successifully");
        if(!x) System.out.println("Failed Card payment");
    }
    private void obtainCertificate () throws DigitalSignatureException, ConnectException {
        CriminalRecordCertf doc = this.justMin.getCriminalRecordCertf(citizen, g);
    }
    private void printDocument () {
        System.out.println("user wants to print eh document recibed,");
    }
    private void registerPayment () {
        System.out.println("Payment registered.");
    }
    private void openDocument (DocPath path) {

    }
    private void printDocument (DocPath path) {

    }
    public void setCitizen(Citizen ci){
        this.citizen = ci;
    }

}
