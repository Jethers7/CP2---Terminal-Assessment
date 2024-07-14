

package MotorPH;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PayslipApp extends JFrame {
    private JTextField txtEmployeeNumber;
    private JTextField txtLastName;
    private JTextField txtFirstName;
    private JTextField txtHourlyRate;
    private JTextField txtHoursWorked;
    private JTextField txtOvertime;
    private JTextField txtRiceSubsidy;
    private JTextField txtPhoneAllowance;
    private JTextField txtClothingAllowance;
    private JButton btnCompute;

    // CSV file path
    private static final String CSV_FILE_PATH = "Payslip.csv";

    public PayslipApp() {
        initComponents();
        loadDataIntoFields(); 
    }

    private void initComponents() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
        setTitle("Employee Payslip");
        setResizable(false);

        // Initialize components
        JPanel panel = new JPanel(new GridLayout(10, 2, 10, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel lblEmployeeNumber = new JLabel("Employee Number:", SwingConstants.RIGHT);
        txtEmployeeNumber = new JTextField(10);
        panel.add(lblEmployeeNumber);
        panel.add(txtEmployeeNumber);

        JLabel lblLastName = new JLabel("Last Name:", SwingConstants.RIGHT);
        txtLastName = new JTextField(15);
        panel.add(lblLastName);
        panel.add(txtLastName);

        JLabel lblFirstName = new JLabel("First Name:", SwingConstants.RIGHT);
        txtFirstName = new JTextField(15);
        panel.add(lblFirstName);
        panel.add(txtFirstName);

        JLabel lblHourlyRate = new JLabel("Hourly Rate:", SwingConstants.RIGHT);
        txtHourlyRate = new JTextField(10);
        panel.add(lblHourlyRate);
        panel.add(txtHourlyRate);

        JLabel lblHoursWorked = new JLabel("Hours Worked:", SwingConstants.RIGHT);
        txtHoursWorked = new JTextField(10);
        panel.add(lblHoursWorked);
        panel.add(txtHoursWorked);

        JLabel lblOvertime = new JLabel("Overtime:", SwingConstants.RIGHT);
        txtOvertime = new JTextField(10);
        panel.add(lblOvertime);
        panel.add(txtOvertime);

        JLabel lblRiceSubsidy = new JLabel("Rice Subsidy:", SwingConstants.RIGHT);
        txtRiceSubsidy = new JTextField(10);
        panel.add(lblRiceSubsidy);
        panel.add(txtRiceSubsidy);

        JLabel lblPhoneAllowance = new JLabel("Phone Allowance:", SwingConstants.RIGHT);
        txtPhoneAllowance = new JTextField(10);
        panel.add(lblPhoneAllowance);
        panel.add(txtPhoneAllowance);

        JLabel lblClothingAllowance = new JLabel("Clothing Allowance:", SwingConstants.RIGHT);
        txtClothingAllowance = new JTextField(10);
        panel.add(lblClothingAllowance);
        panel.add(txtClothingAllowance);

        btnCompute = new JButton("Compute");
        btnCompute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                computePayroll();
            }
        });
        panel.add(new JLabel()); 
        panel.add(btnCompute);

        getContentPane().add(panel);
        pack();
        setLocationRelativeTo(null);
    }

    // Method to load data from CSV into input fields
    private void loadDataIntoFields() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(CSV_FILE_PATH));
            String headerLine = br.readLine(); // Skip header
            String dataLine = br.readLine(); // Read first data line
            if (dataLine != null) {
                String[] data = dataLine.split(",");
                txtEmployeeNumber.setText(data[0]);
                txtLastName.setText(data[1]);
                txtFirstName.setText(data[2]);
                txtHourlyRate.setText(data[14]); 
                txtHoursWorked.setText(data[8]); 
                txtOvertime.setText(data[9]); 
                txtRiceSubsidy.setText(data[10]); 
                txtPhoneAllowance.setText(data[11]); 
                txtClothingAllowance.setText(data[12]); 
                
            }
            br.close();
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading data from CSV file.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Method to compute total amount based on fields 
    private double computeTotalAmount() {
        double hourlyRate = Double.parseDouble(txtHourlyRate.getText().trim());
        double hoursWorked = parseTimeString(txtHoursWorked.getText().trim());
        double overtime = parseTimeString(txtOvertime.getText().trim());
        double riceSubsidy = Double.parseDouble(txtRiceSubsidy.getText().trim());
        double phoneAllowance = Double.parseDouble(txtPhoneAllowance.getText().trim());
        double clothingAllowance = Double.parseDouble(txtClothingAllowance.getText().trim());

        double grossIncome = hourlyRate * hoursWorked + overtime;
        double totalBenefits = riceSubsidy + phoneAllowance + clothingAllowance;
        double totalEarnings = grossIncome + totalBenefits;

        // Compute deductions
        double philHealth = computePhilHealth(totalEarnings);
        double sss = computeSSS(totalEarnings);
        double pagibig = computePagibig(totalEarnings);

        double totalDeductions = philHealth + sss + pagibig;
        double netPay = totalEarnings - totalDeductions;

        // Display deductions
        JOptionPane.showMessageDialog(this, 
            "PhilHealth: PHP " + String.format("%.2f", philHealth) + 
            "\nSSS: PHP " + String.format("%.2f", sss) +
            "\nPag-IBIG: PHP " + String.format("%.2f", pagibig) +
            "\nTotal Deductions: PHP " + String.format("%.2f", totalDeductions) +
            "\n\nTotal Earnings: PHP " + String.format("%.2f", totalEarnings) +
            "\nNet Pay: PHP " + String.format("%.2f", netPay),
            "Payroll Summary", JOptionPane.INFORMATION_MESSAGE);

        return netPay;
    }

    // Compute PhilHealth deduction
    private double computePhilHealth(double totalEarnings) {
        return totalEarnings * 0.03;
    }

    // Compute SSS deduction based on the provided table
    private double computeSSS(double totalEarnings) {
        double sss = 0;
        if (totalEarnings < 3250) sss = 135;
        else if (totalEarnings <= 3750) sss = 157.5;
        else if (totalEarnings <= 4250) sss = 180;
        else if (totalEarnings <= 4750) sss = 202.5;
        else if (totalEarnings <= 5250) sss = 225;
        else if (totalEarnings <= 5750) sss = 247.5;
        else if (totalEarnings <= 6250) sss = 270;
        else if (totalEarnings <= 6750) sss = 292.5;
        else if (totalEarnings <= 7250) sss = 315;
        else if (totalEarnings <= 7750) sss = 337.5;
        else if (totalEarnings <= 8250) sss = 360;
        else if (totalEarnings <= 8750) sss = 382.5;
        else if (totalEarnings <= 9250) sss = 405;
        else if (totalEarnings <= 9750) sss = 427.5;
        else if (totalEarnings <= 10250) sss = 450;
        else if (totalEarnings <= 10750) sss = 472.5;
        else if (totalEarnings <= 11250) sss = 495;
        else if (totalEarnings <= 11750) sss = 517.5;
        else if (totalEarnings <= 12250) sss = 540;
        else if (totalEarnings <= 12750) sss = 562.5;
        else if (totalEarnings <= 13250) sss = 585;
        else if (totalEarnings <= 13750) sss = 607.5;
        else if (totalEarnings <= 14250) sss = 630;
        else if (totalEarnings <= 14750) sss = 652.5;
        else if (totalEarnings <= 15250) sss = 675;
        else if (totalEarnings <= 15750) sss = 697.5;
        else if (totalEarnings <= 16250) sss = 720;
        else if (totalEarnings <= 16750) sss = 742.5;
        else if (totalEarnings <= 17250) sss = 765;
        else if (totalEarnings <= 17750) sss = 787.5;
        else if (totalEarnings <= 18250) sss = 810;
        else if (totalEarnings <= 18750) sss = 832.5;
        else if (totalEarnings <= 19250) sss = 855;
        else if (totalEarnings <= 19750) sss = 877.5;
        else if (totalEarnings <= 20250) sss = 900;
        else if (totalEarnings <= 20750) sss = 922.5;
        else if (totalEarnings <= 21250) sss = 945;
        else if (totalEarnings <= 21750) sss = 967.5;
        else if (totalEarnings <= 22250) sss = 990;
        else if (totalEarnings <= 22750) sss = 1012.5;
        else if (totalEarnings <= 23250) sss = 1035;
        else if (totalEarnings <= 23750) sss = 1057.5;
        else if (totalEarnings <= 24250) sss = 1080;
        else if (totalEarnings <= 24750) sss = 1102.5;
        else sss = 1125;
        return sss;
    }

    // Compute Pag-IBIG deduction
    private double computePagibig(double totalEarnings) {
        if (totalEarnings >= 1000 && totalEarnings <= 1500) {
            return totalEarnings * 0.01;
        } else if (totalEarnings > 1500) {
            return totalEarnings * 0.02;
        }
        return 0;
    }

    // Parse time string to decimal hours
    private double parseTimeString(String timeString) {
        String[] parts = timeString.split(":");
        if (parts.length == 2) {
            int hours = Integer.parseInt(parts[0]);
            int minutes = Integer.parseInt(parts[1]);
            return hours + (minutes / 60.0);
        }
        return 0;
    }

    // Method to handle the compute button action
    private void computePayroll() {
        double totalAmount = computeTotalAmount();
        // Display total amount in a dialog (optional)
        JOptionPane.showMessageDialog(this, "Net Pay: PHP " + String.format("%.2f", totalAmount), "Payroll Summary", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PayslipApp().setVisible(true);
            }
        });
    }
}
