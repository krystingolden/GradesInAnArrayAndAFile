package com.pluralsight;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;

public class ReportCard {

    private Scanner keyboard = new Scanner(System.in);

    //Create a variable to store the the filename specified by the student
    private String fileName;

    //Create an array to hold the grades
    private Integer[] grades = new Integer[5];


    public void determineFile() {
        //Prompt the user for the name of the file
        System.out.println("What should we call the report card file?");
        this.fileName = keyboard.next();

        //Determine if the file name is of the proper format (must end in .txt) and if not, adjust it
        if (!(this.fileName.endsWith(".txt"))) {
            this.fileName = this.fileName + ".txt";
        }
    }

    public void determineGrades() {

        //Initialize a counter and a random number generator
        int index;
        Random r = new Random();

        //Fill the array with random grades between 1 and 100
        for (index = 0; index < grades.length; index++) {
            int number = r.nextInt(100);
            grades[index] = number;
        }
    }

    public void writeOutGrades(String firstName, String lastName) throws IOException {

        //Get the path to the file which will be created/overwritten,
        // read in the student's name, the filename and the grades, then close it
        try (BufferedWriter br = Files.newBufferedWriter(Paths.get(this.fileName))) {

            br.write("Name (last, first): " + lastName + ", " + firstName);
            br.newLine();
            br.write("Filename: " + fileName);
            br.newLine();
            br.newLine();
            br.write("Here are your randomly selected grades. Hope you pass!");
            br.newLine();

            int index;

            //Fill the array with the previously determined random grades between 1 and 100
            for (index = 0; index < grades.length; index++) {
                br.write("Grade " + (index + 1) + ": " + grades[index]);
                br.newLine();
            }

            //If there is an issue creating/opening the file to be written to, it will throw a message
        } catch (IOException e) {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }

}
