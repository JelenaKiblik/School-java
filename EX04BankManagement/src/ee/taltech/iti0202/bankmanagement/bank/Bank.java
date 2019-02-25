package ee.taltech.iti0202.bankmanagement.bank;
import ee.taltech.iti0202.bankmanagement.card.CreditCard;
import ee.taltech.iti0202.bankmanagement.card.DebitCard;
import ee.taltech.iti0202.bankmanagement.person.Person;

import java.util.*;

public class Bank {

    private String name;
    private Set<Person> customers = new HashSet<>();
    private List<DebitCard> debitCards = new ArrayList<>();
    private List<CreditCard> creditCards = new ArrayList<>();

    public Bank(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<Person> getCustomers() {
        return null;
    }

    public Boolean addCustomer(Person person) {
        return null;
    }

    public Boolean removeCustomer(Person person) {
        return null;
    }

    public double getAverageCustomerMonthlyIncome() {
        return 0.0;
    }

    public double getAverageCustomerMonthlyIncome(int maxAge) {
        return 0.0;
    }

    public double getAverageCustomerMonthlyIncome(int minAge, int maxAge) {
        return 0.0;
    }

    public double getAverageCustomerMonthlyIncome(Person.Gender gender) {
        return 0.0;
    }

    public Set<Person> getAllCustomersWithCreditCards() {
        return null;
    }

    public Set<Person> getAllCustomersWithDebitCards() {
        return null;
    }

    public Optional<Person> getRichestCustomerByGender(Person.Gender gender) {
        return Optional.empty();
    }

    @Override
    public String toString() {
        return getName();
    }
}
