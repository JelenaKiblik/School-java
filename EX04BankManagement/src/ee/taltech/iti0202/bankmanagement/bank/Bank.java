package ee.taltech.iti0202.bankmanagement.bank;

import ee.taltech.iti0202.bankmanagement.card.CreditCard;
import ee.taltech.iti0202.bankmanagement.card.DebitCard;
import ee.taltech.iti0202.bankmanagement.person.Person;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Bank {

    private String name;
    public Set<Person> customers = new HashSet<>();
    private Person person;
    private CreditCard creditCard;
    private DebitCard debitCard;

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
        if (customers.size() == 0) {
            return 0.0;
        } else {
            Double averageMonthlyIncome = customers
                    .stream()
                    .collect(Collectors.averagingInt(p -> (int) person.getMonthlyIncome()));
            return averageMonthlyIncome;
        }
    }

    public double getAverageCustomerMonthlyIncome(int maxAge) {
        if (customers.size() == 0) {
            return 0.0;
        } else {
            Double averageMonthlyIncomeMaxAge = customers
                    .stream()
                    .filter(p -> p.getAge() <= maxAge)
                    .collect(Collectors.averagingInt(p -> (int) person.getMonthlyIncome()));
            return averageMonthlyIncomeMaxAge;
        }
    }

    public double getAverageCustomerMonthlyIncome(int minAge, int maxAge) {
        if (customers.size() == 0) {
            return 0.0;
        } else {
            Double averageMonthlyIncomeMinMaxAge = customers
                    .stream()
                    .filter(p -> p.getAge() <= maxAge && p.getAge() >= minAge)
                    .collect(Collectors.averagingInt(p -> (int) person.getMonthlyIncome()));
            return averageMonthlyIncomeMinMaxAge;
        }
    }

    public double getAverageCustomerMonthlyIncome(Person.Gender gender) {
        if (customers.size() == 0) {
            return 0.0;
        } else {
            if (gender.equals(Person.Gender.FEMALE)) {
                Double averageMonthlyIncomeGender = customers
                        .stream()
                        .filter(p -> p.getGender() == Person.Gender.FEMALE)
                        .collect(Collectors.averagingInt(p -> (int) person.getMonthlyIncome()));
                return averageMonthlyIncomeGender;
            } else {
                Double averageMonthlyIncomeGender = customers
                        .stream()
                        .filter(p -> p.getGender() == Person.Gender.MALE)
                        .collect(Collectors.averagingInt(p -> (int) person.getMonthlyIncome()));
                return averageMonthlyIncomeGender;
            }
        }
    }

    public Set<Person> getAllCustomersWithCreditCards() {
        return (Set<Person>) customers.stream()
                .filter(p -> person.getBankCard().isPresent())
                .filter(p -> person.getBankCard().get() instanceof CreditCard);
    }

    public Set<Person> getAllCustomersWithDebitCards() {
        return (Set<Person>) customers.stream()
                .filter(p -> person.getBankCard().isPresent())
                .filter(p -> person.getBankCard().get() instanceof DebitCard);
    }

    public Optional<Person> getRichestCustomerByGender(Person.Gender gender) {
        if (gender.equals(Person.Gender.FEMALE)) {
            Optional<Person> richestCustomer = customers.stream()
                    .filter(p -> p.getGender() == Person.Gender.FEMALE)
                    .max(Comparator.comparing(Person::getMonthlyIncome));
            return richestCustomer;
        } else {
            Optional<Person> richestCustomer = customers.stream()
                    .filter(p -> p.getGender() == Person.Gender.MALE)
                    .max(Comparator.comparing(Person::getMonthlyIncome));
            return richestCustomer;
        }
    }

    @Override
    public String toString() {
        return getName();
    }
}
