package ee.taltech.iti0202.bankmanagement.card;
import ee.taltech.iti0202.bankmanagement.exceptions.TransactionException;
import java.math.BigDecimal;

public final class CreditCard extends BankCard {

    private final BigDecimal startingMoney = BigDecimal.valueOf(10000);
    private final BigDecimal debtLimit = BigDecimal.valueOf(5000);

    CreditCard() {
        super.balance = startingMoney;
    }

    @Override
    public BigDecimal withdraw(BigDecimal value) throws TransactionException {
        if (value.compareTo(BigDecimal.ZERO) == 0) {
            throw new TransactionException("Error!!");
        } else {
            if (value.compareTo(BigDecimal.valueOf(0)) <= 0) {
                throw new TransactionException("Error!!");
            }

            if (value.compareTo(balance.add(debtLimit)) <= 0) {
                balance = balance.subtract(value);
            }
            return value;
        }
    }

    @Override
    public BigDecimal getBalance() {
        if (balance.compareTo(BigDecimal.valueOf(0)) < 0) {
            return BigDecimal.valueOf(0);
        } else {
            return balance;
        }
    }

    public BigDecimal getDebt() {
        if (balance.compareTo(BigDecimal.valueOf(0)) < 0) {
            return balance.negate();
        }
        return BigDecimal.valueOf(0);
    }

}
