
package MotorPH;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.Duration;

public class CSVUtils {

    // Method to read employees.csv and return the hourly rate for a given employee number
    public static double getHourlyRate(String employeeNumber) {
        String line;
        String csvFile = "employees.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values[0].equals(employeeNumber)) {
                    return Double.parseDouble(values[3]); // Assuming hourly rate is at column index 3
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0.0;
    }

    // Method to read attendance.csv and return the total hours worked for a given employee number
    public static double getHoursWorked(String employeeNumber) {
        String line;
        String csvFile = "attendance.csv";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        double totalHoursWorked = 0.0;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values[0].equals(employeeNumber)) {
                    LocalTime timeIn = LocalTime.parse(values[1], formatter);
                    LocalTime timeOut = LocalTime.parse(values[2], formatter);
                    Duration duration = Duration.between(timeIn, timeOut);
                    totalHoursWorked += duration.toHours() + (double) duration.toMinutesPart() / 60.0;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return totalHoursWorked;
    }
}
