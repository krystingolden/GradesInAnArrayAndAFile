package com.pluralsight;

public class Main {

    /*
    https://programmingbydoing.com/
    Grades in an array and a file - Assignment #143
     */

    public static void main(String[] args) throws Exception{

        //Create a new student
        Student student = new Student();

        //Determine which student's report card should be filled.
        student.determineStudent();

        //Create a new report card
        ReportCard reportCard = new ReportCard();

        //Determine the name of the file to which the data will be stored
        reportCard.determineFile();

        //Determine grades
        reportCard.determineGrades();

        //Write grades to the specified file
        reportCard.writeOutGrades(student.getFirstName(), student.getLastName());

    }
}
