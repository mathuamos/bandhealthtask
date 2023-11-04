package com.example.taskorg;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TopThreeElvesCalories {

    public static void main(String[] args) {
        try {
            File inputFile = new File("input.txt"); // Change "input.txt" to the actual filename
            Scanner scanner = new Scanner(inputFile);

            TreeMap<Integer, Integer> elfCalories = new TreeMap<>(Collections.reverseOrder());

            int currentElfCalories = 0;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();

                if (line.isEmpty()) {
                    if (currentElfCalories > 0) {
                        elfCalories.put(currentElfCalories, elfCalories.getOrDefault(currentElfCalories, 0) + 1);
                        currentElfCalories = 0; // Reset for the next Elf
                    }
                } else {
                    int calories = Integer.parseInt(line);
                    currentElfCalories += calories;
                }
            }

            if (currentElfCalories > 0) {
                elfCalories.put(currentElfCalories, elfCalories.getOrDefault(currentElfCalories, 0) + 1);
            }

            int totalCalories = 0;
            int elvesCounted = 0;

            for (Map.Entry<Integer, Integer> entry : elfCalories.entrySet()) {
                int calories = entry.getKey();
                int count = entry.getValue();

                while (count > 0 && elvesCounted < 3) {
                    totalCalories += calories;
                    elvesCounted++;
                    count--;
                }

                if (elvesCounted >= 3) {
                    break;
                }
            }

            System.out.println(totalCalories);
            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found. Please make sure the input file exists.");
        }
    }
}
