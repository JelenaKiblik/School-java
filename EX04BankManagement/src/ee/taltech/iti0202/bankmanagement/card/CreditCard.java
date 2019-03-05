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
//        BigDecimal zero = new BigDecimal("0");
//        if (balance.subtract(value).compareTo(zero) < -5000 || value.compareTo(zero) < 1) {
//            throw new TransactionException("Error!!!");
//        } else {
//            balance = balance.subtract(value);
//        }
//        return zero;
        return value;
    }

    @Override
    public BigDecimal getBalance() {
//        if (balance.compareTo(BigDecimal.valueOf(0)) < 0) {
//            return BigDecimal.valueOf(0);
//        } else {
//            return super.getBalance();
//        }
        return null;
    }

    public BigDecimal getDebt() {
        if (balance.compareTo(BigDecimal.valueOf(0)) < 0) {
            return balance.negate();
        }
        return BigDecimal.valueOf(0);
    }
}