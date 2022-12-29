package services;

import exceptions.IncorrectFormException;
import exceptions.InsufficientBalanceException;
import exceptions.NotValidPaymentDataException;
import publicadministration.CreditCard;

import java.math.BigDecimal;
import java.net.ConnectException;
import java.util.Date;
import java.util.HashMap;

public class CASdouble implements CAS {

    HashMap<String, BigDecimal> AccBal;
    public CASdouble() {
        AccBal = new HashMap<String, BigDecimal>();
    }
    @Override
    public boolean askForApproval(String nTrans, CreditCard cardData, Date date, BigDecimal imp) throws NotValidPaymentDataException, InsufficientBalanceException, ConnectException, IncorrectFormException {
        if(nTrans == null || cardData == null || date == null || imp == null) throw new IncorrectFormException();
        if(!cardData.CorrectForm() || cardData.getExpirDate().before(date) || !AccBal.containsKey(cardData.getCardNumb())){
            throw new NotValidPaymentDataException();
        }
        if(AccBal.get(cardData.getCardNumb()).compareTo(imp) < 0){
            throw new InsufficientBalanceException();
        }
        return true;
    }
    public void addBalance(CreditCard c, BigDecimal bal){
        AccBal.put(c.getCardNumb(), bal);
    }
}
