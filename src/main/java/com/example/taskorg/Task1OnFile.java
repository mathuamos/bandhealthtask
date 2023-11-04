package com.example.taskorg;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task1OnFile {


    public static void main(String[] args) {
        try {
            File inputFile = new File("input.txt");
            Scanner scanner = new Scanner(inputFile);
            int maxCalories = 0;
            int currentElfCalories = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();

                if (line.isEmpty()) {
                    // End of an Elf's inventory
                    maxCalories = Math.max(maxCalories, currentElfCalories);
                    currentElfCalories = 0; // Reset for the next Elf
                } else {
                    // Parse the calories and add to the current Elf's total
                    int calories = Integer.parseInt(line);
                    currentElfCalories += calories;
                }
            }

            // Ensure we account for the last Elf's calories
            maxCalories = Math.max(maxCalories, currentElfCalories);

            System.out.println(maxCalories);
            scanner.close();
        }  catch (FileNotFoundException e) {
            System.err.println("File not found. Please make sure the input file exists.");

            throw new RuntimeException(e);

        }
    }
}
