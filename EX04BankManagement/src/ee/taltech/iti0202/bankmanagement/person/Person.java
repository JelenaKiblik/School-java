package ee.taltech.iti0202.bankmanagement.person;

import ee.taltech.iti0202.bankmanagement.bank.Bank;
import ee.taltech.iti0202.bankmanagement.card.BankCard;
import ee.taltech.iti0202.bankmanagement.exceptions.PersonException;
import java.util.Optional;

public class Person {
    public BankCard bankCard;
    private String firstName;
    private String lastName;
    private int age;
    private double monthlyIncome;
    private Gender gender;
    private Bank bank;

    public enum Gender { MALE, FEMALE }

    public Person(String firstName, String lastName, int age, Gender gender, double monthlyIncome) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;

        if (age <= 0) {
            throw new PersonException("Age is not allowed");
        }
        this.age = age;

        if (monthlyIncome < 0) {
            throw new PersonException("Monthly income can'not ba e negative number");
        }
        this.monthlyIncome = monthlyIncome;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public double getMonthlyIncome() {
        return monthlyIncome;
    }

    /**
     * Return Optional.empty() if person has no bankcard.
     * @return Optional of BankCard
     */
    public Optional<BankCard> getBankCard() {
        if (bankCard == null) {
            return Optional.empty();
        } else {
            return Optional.ofNullable(bankCard);
        }
    }

    public void setBankCard(BankCard bankCard) {
        this.bankCard = bankCard;
    }

    @Override
    public String toString() {
        return String.format("%s %s", firstName, lastName);
    }
}
