package ee.taltech.iti0202.bankmanagement.card;
import ee.taltech.iti0202.bankmanagement.bank.Bank;
import ee.taltech.iti0202.bankmanagement.exceptions.TransactionException;
import ee.taltech.iti0202.bankmanagement.person.Person;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public abstract class BankCard {

    private BankCard bankCard;
    protected BigDecimal balance;
    private Bank bank;
    private Person person;
    private static List<DebitCard> debitCards = new ArrayList<>();
    private static List<CreditCard> creditCards = new ArrayList<>();

    public enum CardType { CREDIT, DEBIT }

    /**
     * Constructor factory. Return a CreditCard or DebitCard object according to parameter cardType.
     *
     * @param cardType Specifies objected type to be returned.
     * @param bank     Specifies the bank of the created card.
     * @param person   Specifies the card owner.
     * @return
     */
    public static BankCard createCard(CardType cardType, Bank bank, Person person) {

        if (cardType == CardType.DEBIT) {
            BankCard bankCard = new DebitCard();
            person.setBankCard(bankCard);
            if (!bank.customers.contains(person)) {
                bank.customers.add(person);
            }
            debitCards.add((DebitCard) bankCard);
            return bankCard;
        }
        if (cardType == CardType.CREDIT) {
            BankCard bankCard = new CreditCard();
            person.setBankCard(bankCard);
            if (!bank.customers.contains(person)) {
                bank.customers.add(person);
            }
            creditCards.add((CreditCard) bankCard);
            return bankCard;
        }
        return null;
    }

//    /**
//     * Deposit given amount to the card.
//     *
//     * @param value Value to be deposited.
//     * @throws TransactionException Thrown if given value is zero or less.
//     */
//    public void deposit(BigDecimal value) throws TransactionException {
//        BigDecimal zero = new BigDecimal("0");
//        if (value.compareTo(zero) > -1) {
//            balance = balance.add(value);
//        }
//    }

//    /**
//     * Withdraw the given amount from the card. Abstract function - implemented in subclasses CreditCard and DebitCard.
//     *
//     * @param value Value to be withdrawn.
//     * @return Amount withdrawn.
//     * @throws TransactionException Thrown if given value cannot be withdrawn for
//     *                              various reasons - specified in subclasses.
//     */
//    public abstract BigDecimal withdraw(BigDecimal value) throws TransactionException;
//

    public Bank getBank() {
        return bank;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public Person getPerson() {
        return person;
    }
}
