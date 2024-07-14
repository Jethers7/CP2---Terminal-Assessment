package MotorPH;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProfileEmp {

    // Path to your employees.csv file
    private static final String CSV_FILE_PATH = "employees.csv";

    // Method to read data from CSV file
    public static List<String[]> readEmployeesCSV() {
        List<String[]> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                data.add(row);
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Handle exception as needed (e.g., log error, show message)
        }
        return data;
    }

    // Method to display all data based on account criteria
    public static void displayEmployeesByAccount(String accountNumber) {
        List<String[]> employees = readEmployeesCSV();
        boolean found = false;

        // Iterate through the employees and filter/display based on account number
        for (String[] employee : employees) {
            if (employee.length > 0 && employee[0].equals(accountNumber)) { // Assuming account number is the first column
                found = true;
                System.out.println("Employee Details:");
                for (int i = 0; i < employee.length; i++) {
                    System.out.println("Column " + i + ": " + employee[i]);
                }
                System.out.println("----------------------");
            }
        }

        if (!found) {
            System.out.println("No employee found with account number: " + accountNumber);
        }
    }

    public static void main(String[] args) {
        // Example usage:
        String accountNumber = "123"; // Replace with actual account number
        displayEmployeesByAccount(accountNumber);
    }
}
