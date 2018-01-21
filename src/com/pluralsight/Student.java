package com.pluralsight;

import java.util.Scanner;

public class Student {

    private String firstName;
    private String lastName;
    private Scanner keyboard = new Scanner(System.in);

    public void determineStudent() {
        //Prompt the user for their first and last names
        System.out.println("What is your first name?");
        this.firstName = keyboard.next();
        System.out.println("What is your last name?");
        this.lastName = keyboard.next();
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }
}
