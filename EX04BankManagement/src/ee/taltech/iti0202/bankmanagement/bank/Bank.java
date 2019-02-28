package ee.taltech.iti0202.bankmanagement.bank;
import ee.taltech.iti0202.bankmanagement.card.CreditCard;
import ee.taltech.iti0202.bankmanagement.card.DebitCard;
import ee.taltech.iti0202.bankmanagement.person.Person;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Optional;


public class Bank {

    private String name;
    public Set<Person> customers = new HashSet<>();
    private List<DebitCard> debitCards = new ArrayList<>();
    private List<CreditCard> creditCards = new ArrayList<>();
    private Person person;

    public Bank(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<Person> getCustomers() {
        return customers;
    }

    public Boolean addCustomer(Person person) {
        if (!customers.contains(person)) {
            customers.add(person);
            return true;
        } else {
            return false;
        }
    }

    public Boolean removeCustomer(Person person) {
        if (customers.contains(person)) {
            customers.remove(person);
            person.setBankCard(null);
            return true;
        } else {
            return false;
        }
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
