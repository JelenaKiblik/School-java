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
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        if (age > 0) {
            return age;
        } else {
            throw new PersonException("Error");
        }
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public double getMonthlyIncome() {
        if (monthlyIncome > 0) {
            return monthlyIncome;
        } else {
            throw new PersonException("Error");
        }
    }

    public void setMonthlyIncome(double monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
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
