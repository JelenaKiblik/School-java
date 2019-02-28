package ee.taltech.iti0202.bankmanagement.card;
import ee.taltech.iti0202.bankmanagement.exceptions.TransactionException;

import java.math.BigDecimal;

public final class DebitCard extends BankCard {

    DebitCard() {
        super.balance = BigDecimal.valueOf(0);
    }

    @Override
    public BigDecimal withdraw(BigDecimal value) throws TransactionException {
        if (value.compareTo(BigDecimal.valueOf(0)) <= 0) {
            throw new TransactionException("Error");
        }
        if (value.compareTo(balance) <= 0) {
            balance = balance.subtract(value);
            throw new TransactionException("Error");
        }
        return value;
    }
}
