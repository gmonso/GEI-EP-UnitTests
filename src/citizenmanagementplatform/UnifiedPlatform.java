package citizenmanagementplatform;

import exceptions.*;
import services.*;
import publicadministration.*;
import data.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.ConnectException;
import java.util.Date;
import java.util.HashMap;
public class UnifiedPlatform {
    public CertAuthDouble cerAuth;
    public CASdouble CAS;
    public GPDdobule GPD;
    public JustMinDouble justMin;

    public Citizen citizen;
    public String AuthMethod;
    public HashMap<String, SmallCode> usersPins;
    public CriminalRecordCertf doc;
    public Goal g;
    public boolean sent = false;
    public UnifiedPlatform(JusticeMinistry jus, CAS cas, GPD police, CertificationAuthority cerAuth) {
        this.justMin = (JustMinDouble) jus;
        this.CAS = (CASdouble) cas;
        this.GPD = (GPDdobule) police;
        this.cerAuth = (CertAuthDouble) cerAuth;
        this.usersPins = new HashMap<>();
    }
    public void selectJusMin(){
        System.out.println("User select the Justice Ministry");
    }
    public boolean registered = false;
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
        if(usersPins.containsValue(pin)) {
            boolean x = this.cerAuth.checkPIN(citizen.getNif(), pin);
            if (x) {
                System.out.println("PIN correct by user. Needs verification with police and make form");
                sent = true;
            }
        }
    }
    public boolean sentTrue(){
        return sent;
    }
    public void executeEnterForm(Citizen citz, Goal g) throws IncorrectVerificationException, IncorrectFormException, ConnectException {
        enterForm(citz, g);
    }
    private void enterForm (Citizen citz, Goal goal) throws IncorrectVerificationException, ConnectException, IncorrectFormException {
        if(citz == null || goal == null){
            throw new IncorrectFormException();
        }
        if(this.GPD.verifyData(citz, goal)){
            System.out.println("Form entered and data verified.");
        }

    }
    private void realizePayment () {
        System.out.println("User is ready for card payment.");
    }
    public void setGoal() throws NullArgumentException, WrongFormatException, GoalTypeException {
        this.g = new Goal("Thesdfgoal", Goal.GoalType.STUDENT);
    }
    Date y = new Date(2024,2,2);
    private void enterCardData (CreditCard cardD) throws NotValidPaymentDataException, InsufficientBalanceException, ConnectException, IncorrectFormException {
        boolean x = this.CAS.askForApproval("Tranferece", cardD, y, new BigDecimal(20));
        if(x){
            registerPayment();
            System.out.println("Card data introduced and verified successifully");
        }
        if(!x) System.out.println("Failed Card payment");
    }
    public void executeEnterCardData(CreditCard card) throws NotValidPaymentDataException, InsufficientBalanceException, IncorrectFormException, ConnectException {
        enterCardData(card);
    }
    public void executeObtainCer() throws DigitalSignatureException, IOException, BadPathException {
        obtainCertificate();
    }
    private void obtainCertificate () throws DigitalSignatureException, IOException, BadPathException {
        doc = this.justMin.getCriminalRecordCertf(citizen, g);
        doc.openDoc(doc.getPath());
    }
    private void printDocument () {
        printDocument(doc.getPath());
    }
    private void registerPayment () {
        registered = true;
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
