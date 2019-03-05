package ee.taltech.iti0202.bankmanagement.bank;

import ee.taltech.iti0202.bankmanagement.card.BankCard;
import ee.taltech.iti0202.bankmanagement.card.CreditCard;
import ee.taltech.iti0202.bankmanagement.card.DebitCard;
import ee.taltech.iti0202.bankmanagement.person.Person;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Bank {
    public String name;
    public Set<Person> customers = new HashSet<>();
    public Person person;
    public CreditCard creditCard;
    public DebitCard debitCard;
    public BankCard bankCard;

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
        if (customers.contains(person)) {
            return false;
        } else {
            customers.add(person);
            return true;
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
            Double averageMonthlyIncome = customers.stream()
                    .mapToInt(person -> (int) person.getMonthlyIncome())
                    .average().getAsDouble();
            return averageMonthlyIncome;
        }
    }

    public double getAverageCustomerMonthlyIncome(int maxAge) {
        if (customers.size() == 0) {
            return 0.0;
        } else {
            Double averageMonthlyIncome = customers.stream()
                    .filter(person -> person.getAge() <= maxAge)
                    .mapToInt(person -> (int) person.getMonthlyIncome())
                    .average().getAsDouble();
            return averageMonthlyIncome;
        }
    }

    public double getAverageCustomerMonthlyIncome(int minAge, int maxAge) {
        if (customers.size() == 0) {
            return 0.0;
        } else {
            Double averageMonthlyIncome = customers.stream()
                    .filter(p -> person.getAge() <= maxAge  && person.getAge() >= minAge)
                    .mapToInt(person -> (int) person.getMonthlyIncome())
                    .average().getAsDouble();
            return averageMonthlyIncome;
        }
    }

    public double getAverageCustomerMonthlyIncome(Person.Gender gender) {
        if (customers.size() == 0) {
            return 0.0;
        } else {
            if (gender.equals(Person.Gender.FEMALE)) {
                Double averageMonthlyIncomeGender = customers.stream()
                        .filter(person -> person.getGender() == Person.Gender.FEMALE)
                        .mapToInt(person -> (int) person.getMonthlyIncome())
                        .average().getAsDouble();
                return averageMonthlyIncomeGender;
            } else {
                Double averageMonthlyIncomeGender = customers.stream()
                        .filter(person -> person.getGender() == Person.Gender.MALE)
                        .mapToInt(person -> (int) person.getMonthlyIncome())
                        .average().getAsDouble();
                return averageMonthlyIncomeGender;
            }
        }
    }

    public Set<Person> getAllCustomersWithCreditCards() {
        Set<Person> customersWithCreditCard = new HashSet<>();
        for (Person person : customers) {
            if (person.getBankCard().get() instanceof CreditCard) {
                customersWithCreditCard.add(person);
            }
        }
        return customersWithCreditCard;
    }

    public Set<Person> getAllCustomersWithDebitCards() {
        Set<Person> customersWithDebitCard = new HashSet<>();
        for (Person person : customers) {
            if (person.getBankCard().get() instanceof DebitCard) {
                customersWithDebitCard.add(person);
            }
        }
        return customersWithDebitCard;
    }

    public Optional<Person> getRichestCustomerByGender(Person.Gender gender) {
            if (gender.equals(Person.Gender.FEMALE)) {
                Optional<Person> richestCustomer = customers.stream()
                        .filter(person -> person.getGender() == Person.Gender.FEMALE)
                        .max(Comparator.comparing(p -> p.bankCard.getBalance()));
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
