package ee.taltech.iti0202.bankmanagement.card;

import ee.taltech.iti0202.bankmanagement.bank.Bank;
import ee.taltech.iti0202.bankmanagement.exceptions.TransactionException;
import ee.taltech.iti0202.bankmanagement.person.Person;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public abstract class BankCard {

    public Bank bank;
    public Person person;
    public BigDecimal balance;
    public static List<DebitCard> debitCards = new ArrayList<>();
    public static List<CreditCard> creditCards = new ArrayList<>();
    public CardType cardType;

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
        bank.removeCustomer(person);
        BankCard bankCard = null;
        if (cardType == CardType.DEBIT) {
            bankCard = new DebitCard();
            bankCard.cardType = cardType;
            debitCards.add((DebitCard) bankCard);
        }
        if (cardType == CardType.CREDIT) {
            bankCard = new CreditCard();
            bankCard.cardType = cardType;
            creditCards.add((CreditCard) bankCard);
        }
        bankCard.bank = bank;
        person.setBankCard(bankCard);
        if (!bank.customers.contains(person)) {
            bank.addCustomer(person);
        }
        return bankCard;
    }

    /**
     * Deposit given amount to the card.
     *
     * @param value Value to be deposited.
     * @throws TransactionException Thrown if given value is zero or less.
     */
    public void deposit(BigDecimal value) throws TransactionException {
//        BigDecimal zero = new BigDecimal("0");
//        if (value.compareTo(zero) > -1) {
//            balance = balance.add(value);
//        }
    }


    /**
     * Withdraw the given amount from the card. Abstract function - implemented in subclasses CreditCard and DebitCard.
     *
     * @param value Value to be withdrawn.
     * @return Amount withdrawn.
     * @throws TransactionException Thrown if given value cannot be withdrawn for
     *                              various reasons - specified in subclasses.
     */
    public abstract BigDecimal withdraw(BigDecimal value) throws TransactionException;

    public Bank getBank() {
        return bank;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public BigDecimal getDebt() {
        return null;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Person getPerson() {
        return person;
    }
}
