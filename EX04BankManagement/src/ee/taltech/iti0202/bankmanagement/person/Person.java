package ee.taltech.iti0202.bankmanagement.person;

import ee.taltech.iti0202.bankmanagement.card.BankCard;
import ee.taltech.iti0202.bankmanagement.exceptions.PersonException;
import java.util.Optional;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double monthlyIncome;
    private BankCard bankCard;
    private Gender gender;

    public enum Gender { MALE, FEMALE }

    public Person(String firstName, String lastName, int age, Gender gender, double monthlyIncome) {
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        } else {
            throw new PersonException("error");
        }
    }

    public int getAge() {
        return age;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Gender getGender() {
        return gender;
    }

    public void setMonthlyIncome(double monthlyIncome) {
        if (monthlyIncome >= 0) {
            this.monthlyIncome = monthlyIncome;
        } else {
            throw new PersonException("error");
        }
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
