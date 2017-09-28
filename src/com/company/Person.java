package com.company;

public abstract class Person {
    private String firstName;
    private String lastName;
    private int birthYear;
    private boolean gender; // true = male, false = female

    // Constructor
    public Person(String firstName, String lastName, int birthYear, boolean gender) {
        setFirstName(firstName);
        setLastName(lastName);
        setBirthYear(birthYear);
        setGender(gender);
    }

    // Setters
    public void setFirstName(String firstName) {
        // Check name contains more than one character.
        if (firstName.length() > 1) {
            this.firstName = firstName;
        } else {
            System.out.println("Error: name too short");
        }
    }

    public void setLastName(String lastName) {
        // Check last name contains more than one character.
        if (lastName.length() > 1) {
            this.lastName = lastName;
        } else {
            System.out.println("Error: last name too short");
        }
    }

    public void setBirthYear(int birthYear) {
        // Check age is reasonable.
        if (birthYear > 1000 && birthYear < 9999) {
            this.birthYear = birthYear;
        } else {
            System.out.println("Error: birth year not reasonable");
        }
    }

    public void setGender(boolean gender) {
        // true = male, false = female
        this.gender = gender;
    }

    // Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public boolean isGender() {
        return gender;
    }

    @Override
    public String toString() {
        return getFirstName() + " " + getLastName();
    }
}
