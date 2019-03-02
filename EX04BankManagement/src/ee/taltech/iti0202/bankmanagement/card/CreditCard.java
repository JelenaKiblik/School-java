package ee.taltech.iti0202.bankmanagement.card;

import ee.taltech.iti0202.bankmanagement.exceptions.TransactionException;
import java.math.BigDecimal;

public final class CreditCard extends BankCard {

    final BigDecimal startingBalance = BigDecimal.valueOf(10000);
    final BigDecimal allowedDebt = BigDecimal.valueOf(5000);
    BigDecimal balance;

    CreditCard() {
        super.balance = startingBalance;
    }

    @Override
    public BigDecimal withdraw(BigDecimal value) throws TransactionException {
        if (value.compareTo(BigDecimal.valueOf(0)) <= 0) {
            throw new TransactionException("Error");
        }

        if (value.compareTo(balance.add(allowedDebt)) <= 0) {
            balance = balance.subtract(value);
            throw new TransactionException("Error");
        }
        return value;
    }

    @Override
    public BigDecimal getBalance() {
        if (balance.compareTo(BigDecimal.valueOf(0)) < 0) {
            return BigDecimal.valueOf(0);
        } else {
            return super.getBalance();
        }
    }

    public BigDecimal getDebt() {
        if (balance.compareTo(BigDecimal.valueOf(0)) < 0) {
            return balance.negate();
        }
        return BigDecimal.valueOf(0);
    }
}
