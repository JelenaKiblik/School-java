package ee.taltech.iti0202.bankmanagement.card;

import ee.taltech.iti0202.bankmanagement.exceptions.TransactionException;
import java.math.BigDecimal;

public final class DebitCard extends BankCard {

    DebitCard() {
        super.balance = BigDecimal.valueOf(0);
    }

    @Override
    public BigDecimal withdraw(BigDecimal value) throws TransactionException {
        BigDecimal zero = new BigDecimal("0");
        if (balance.subtract(value).compareTo(zero) < 0 || value.compareTo(zero) < 1) { //newBalance < 0 or value <= 0
            throw new TransactionException("Error");
        } else {
            balance = balance.subtract(value);
        }
        return zero;
    }
}
