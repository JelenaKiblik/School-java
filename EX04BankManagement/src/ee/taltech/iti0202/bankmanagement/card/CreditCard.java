package ee.taltech.iti0202.bankmanagement.card;
import ee.taltech.iti0202.bankmanagement.exceptions.TransactionException;

import java.math.BigDecimal;

public final class CreditCard extends BankCard {

    CreditCard() {

    }

    @Override
    public BigDecimal withdraw(BigDecimal value) throws TransactionException {
        return null;
    }

    @Override
    public BigDecimal getBalance() {
        return null;
    }

    public BigDecimal getDebt() {
        return null;
    }
}
