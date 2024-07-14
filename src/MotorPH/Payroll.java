package MotorPH;

import com.opencsv.CSVReader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.IOException;

public class Payroll extends JFrame {

    private JTextField txtEmployeeNumber;
    private JTextField txtPayCoverage;
    private JLabel lblBasicSalary;
    private JLabel lblRiceSubsidy;
    private JLabel lblPhoneAllowance;
    private JLabel lblClothingAllowance;
    private JLabel lblGrossSemiMonthlyRate;
    private JLabel lblHourlyRate;

    public Payroll() {
        setTitle("Employee Salary Calculator");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel for input fields
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Input Details"));
        
        inputPanel.add(new JLabel("Employee Number:"));
        txtEmployeeNumber = new JTextField();
        inputPanel.add(txtEmployeeNumber);
        
      

        inputPanel.add(new JLabel("Pay Coverage (MM-yyyy):"));
        txtPayCoverage = new JTextField();
        inputPanel.add(txtPayCoverage);

        JButton btnCalculate = new JButton("Calculate");
        inputPanel.add(new JLabel()); // Placeholder for grid alignment
        inputPanel.add(btnCalculate);

        // Panel for result fields
        JPanel resultPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        resultPanel.setBorder(BorderFactory.createTitledBorder("Salary Details"));
        
        resultPanel.add(new JLabel("Basic Salary:"));
        lblBasicSalary = new JLabel();
        resultPanel.add(lblBasicSalary);

        resultPanel.add(new JLabel("Rice Subsidy:"));
        lblRiceSubsidy = new JLabel();
        resultPanel.add(lblRiceSubsidy);

        resultPanel.add(new JLabel("Phone Allowance:"));
        lblPhoneAllowance = new JLabel();
        resultPanel.add(lblPhoneAllowance);

        resultPanel.add(new JLabel("Clothing Allowance:"));
        lblClothingAllowance = new JLabel();
        resultPanel.add(lblClothingAllowance);

        resultPanel.add(new JLabel("Gross Semi-monthly Rate:"));
        lblGrossSemiMonthlyRate = new JLabel();
        resultPanel.add(lblGrossSemiMonthlyRate);

        resultPanel.add(new JLabel("Hourly Rate:"));
        lblHourlyRate = new JLabel();
        resultPanel.add(lblHourlyRate);

        // Add panels to frame
        add(inputPanel, BorderLayout.NORTH);
        add(resultPanel, BorderLayout.CENTER);

        btnCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateSalary();
            }
        });

        setVisible(true);
    }

    private void calculateSalary() {
        try {
            int employeeNumber = Integer.parseInt(txtEmployeeNumber.getText());
          
            String payCoverage = txtPayCoverage.getText();
            String[] employeeData = loadData(employeeNumber);

            if (employeeData != null) {
                double[] salaryComponents = calculateSalaryComponents(employeeData);
                lblBasicSalary.setText(String.format("%.2f", salaryComponents[0]));
                lblRiceSubsidy.setText(String.format("%.2f", salaryComponents[1]));
                lblPhoneAllowance.setText(String.format("%.2f", salaryComponents[2]));
                lblClothingAllowance.setText(String.format("%.2f", salaryComponents[3]));
                lblGrossSemiMonthlyRate.setText(String.format("%.2f", salaryComponents[4]));
                lblHourlyRate.setText(String.format("%.2f", salaryComponents[5]));
            } else {
                JOptionPane.showMessageDialog(this, "Employee not found", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input for Employee Number or Pay Coverage", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private String[] loadData(int employeeNumber) {
        String csvFile = "Payroll.csv";
        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            // Skip the header row
            reader.readNext();
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                if (Integer.parseInt(nextLine[0]) == employeeNumber) {
                    return nextLine;
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return null;
    }

    private double[] calculateSalaryComponents(String[] employeeData) {
        double basicSalary = Double.parseDouble(employeeData[1]);
        double riceSubsidy = Double.parseDouble(employeeData[2]);
        double phoneAllowance = Double.parseDouble(employeeData[3]);
        double clothingAllowance = Double.parseDouble(employeeData[4]);
        double grossSemiMonthlyRate = basicSalary + riceSubsidy + phoneAllowance + clothingAllowance;
        double hourlyRate = grossSemiMonthlyRate / 160; // Assuming 160 working hours in a month

        return new double[]{basicSalary, riceSubsidy, phoneAllowance, clothingAllowance, grossSemiMonthlyRate, hourlyRate};
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 756, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 455, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    public static void main(String args[]) {
  
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Payroll().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
