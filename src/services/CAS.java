package services;

import java.math.BigDecimal;

public interface CAS {// External service that represents the Credit Authorization Service
    boolean askForApproval(String nTrans, CreditCard cardData,
                           Date date, BigDecimal imp) throws NotValidPaymentDataException,
            InsufficientBalanceException, ConnectException;
}

