package ee.taltech.iti0202.bankmanagement.person;

import ee.taltech.iti0202.bankmanagement.card.BankCard;
import ee.taltech.iti0202.bankmanagement.exceptions.PersonException;
import java.util.Optional;

public class Person {

    private String firstName;
    private String lastName;
    private int age;
    private Gender gender;
    private double monthlyIncome;
    private BankCard bankCard;


    public enum Gender { MALE, FEMALE }

    public Person(String firstName, String lastName, int age, Gender gender, double monthlyIncome) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.monthlyIncome = monthlyIncome;
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        if (age > 0) {
            return age;
        } else {
            throw new PersonException("Error");
        }
    }

    public Gender getGender() {
        return gender;
    }

    public double getMonthlyIncome() {
        if (monthlyIncome > 0) {
            return monthlyIncome;
        } else {
            throw new PersonException("Error");
        }
    }

    /**
     * Return Optional.empty() if person has no bankcard.
     * @return Optional of BankCard
     */
    public Optional<BankCard> getBankCard() {
        return Optional.ofNullable(bankCard);
    }

    public void setBankCard(BankCard bankCard) {
        this.bankCard = bankCard;
    }

    @Override
    public String toString() {
        return String.format("%s %s", firstName, lastName);
    }
}
