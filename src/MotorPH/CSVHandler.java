 
    package MotorPH;

 
    import java.io.*;
    import java.nio.file.Files;
    import java.nio.file.Paths;
    import java.util.ArrayList;
    import java.util.List;

    public class CSVHandler {
        private static final String CSV_FILE_PATH = "employees.csv";

   public void saveEmployee(
        String employeeNumber, String lastName, String firstName, String birthday, String address, 
        String phoneNumber, String position, String sssNumber, String philHealthNumber, String tin, 
        String pagIbigNumber, String employmentStatus, String jobTitle, 
        String basicSalary, String riceSubsidy, String phoneAllowance, String clothingAllowance
    ) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CSV_FILE_PATH, true))) {
            String line = String.join(",", employeeNumber, lastName, firstName, birthday, address, 
                phoneNumber, position, sssNumber, philHealthNumber, tin, pagIbigNumber, employmentStatus, 
                jobTitle, basicSalary, riceSubsidy, phoneAllowance, clothingAllowance);
            
            System.out.println("Writing to CSV: " + line); // Debug print statement
            
            writer.write(line);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error writing to CSV file: " + e.getMessage());
            e.printStackTrace();
        }
    }


        public List<String[]> readAllEmployees() {
            List<String[]> employees = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] employeeDetails = line.split(",");
                    employees.add(employeeDetails);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return employees;
        }

            public void deleteEmployee(String employeeName) {
            List<String[]> employees = readAllEmployees();
            List<String[]> updatedEmployees = new ArrayList<>();

            for (String[] employee : employees) {
                if (!employee[1].equals(employeeName)) { // Assuming lastName is the second element
                    updatedEmployees.add(employee);
                }
            }

            try (FileWriter writer = new FileWriter(CSV_FILE_PATH)) {
                for (String[] employee : updatedEmployees) {
                    StringBuilder sb = new StringBuilder();
                    for (String detail : employee) {
                        sb.append(detail).append(",");
                    }
                    sb.append("\n");
                    writer.append(sb.toString());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    public void deleteEmployeeByNumber(String employeeNumber) {
        try {
            // Read the original CSV file
            List<String> lines = Files.readAllLines(Paths.get(CSV_FILE_PATH));

            // Create a new list to store updated lines
            List<String> updatedLines = new ArrayList<>();

            // Remove the employee record with the specified employee number
            for (String line : lines) {
                String[] parts = line.split(",");
                if (!parts[0].equals(employeeNumber)) { // Assuming employee number is the first element
                    updatedLines.add(line);
                }
            }

            // Write the updated lines back to the CSV file
            Files.write(Paths.get(CSV_FILE_PATH), updatedLines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Udpate Employee
 public boolean updateEmployee(String originalEmployeeNumber, String updatedEmployeeNumber,
            String updatedLastName, String updatedFirstName, String updatedSssNumber,
            String updatedPhilHealthNumber, String updatedTin, String updatedPagIbigNumber) {
        List<String[]> employees = readAllEmployees();
        boolean found = false;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CSV_FILE_PATH))) {
            for (String[] employee : employees) {
                if (employee[0].equals(originalEmployeeNumber)) {
                    employee[0] = updatedEmployeeNumber;
                    employee[1] = updatedLastName;
                    employee[2] = updatedFirstName;
                    employee[3] = updatedSssNumber;
                    employee[4] = updatedPhilHealthNumber;
                    employee[5] = updatedTin;
                    employee[6] = updatedPagIbigNumber;
                    found = true;
                }
                writer.write(String.join(",", employee));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return found;
    
}

    boolean updateEmployee(String updatedEmployeeNumber, String updatedLastName, String updatedFirstName, String updatedSssNumber, String updatedPhilHealthNumber, String updatedTin, String updatedPagIbigNumber) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    }
    



