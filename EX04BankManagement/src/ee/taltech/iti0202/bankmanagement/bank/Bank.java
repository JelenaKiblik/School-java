package ee.taltech.iti0202.bankmanagement.bank;
import ee.taltech.iti0202.bankmanagement.person.Person;

import java.util.Optional;
import java.util.Set;

public class Bank {

    public Bank(String name) {

    }

    public String getName() {
        return null;
    }

    public Set<Person> getCustomers() {
        return null;
    }

    public Boolean addCustomer(Person person) {
        return null;
    }

    public Boolean removeCustomer(Person person){
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
