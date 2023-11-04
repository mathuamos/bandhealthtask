package com.example.taskorg;

import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxCalories = 0;
        int currentElfCalories = 0;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();

            if (!line.isEmpty()) {
                int calories = Integer.parseInt(line);
                currentElfCalories += calories;
            } else {
                if (currentElfCalories > maxCalories) {
                    maxCalories = currentElfCalories;
                }
                currentElfCalories = 0;
            }
        }

        if (currentElfCalories > maxCalories) {
            maxCalories = currentElfCalories;
        }
        System.out.println(maxCalories);
    }

}
