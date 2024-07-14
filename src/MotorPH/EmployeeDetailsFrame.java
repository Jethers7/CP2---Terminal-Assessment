package MotorPH;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.IOException;
import com.opencsv.CSVReader;
import java.util.Arrays;

public class EmployeeDetailsFrame extends JFrame {
    private JLabel lblEmployeeNumber, lblLastName, lblFirstName, lblSSS, lblPhilhealth, lblTIN, lblPagIbig;
    private JComboBox<String> monthComboBox;
    private JButton computeButton;
    private JTextArea resultArea;

    public EmployeeDetailsFrame(String employeeNumber, String lastName, String firstName, String sss, String philhealth, String tin, String pagibig) {
        setTitle("Employee Details");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel infoPanel = new JPanel(new GridLayout(7, 2, 10, 10));
        infoPanel.setBorder(BorderFactory.createTitledBorder("Employee Information"));

        lblEmployeeNumber = new JLabel(employeeNumber);
        lblLastName = new JLabel(lastName);
        lblFirstName = new JLabel(firstName);
        lblSSS = new JLabel(sss);
        lblPhilhealth = new JLabel(philhealth);
        lblTIN = new JLabel(tin);
        lblPagIbig = new JLabel(pagibig);

        infoPanel.add(new JLabel("Employee Number:"));
        infoPanel.add(lblEmployeeNumber);
        infoPanel.add(new JLabel("Last Name:"));
        infoPanel.add(lblLastName);
        infoPanel.add(new JLabel("First Name:"));
        infoPanel.add(lblFirstName);
        infoPanel.add(new JLabel("SSS No.:"));
        infoPanel.add(lblSSS);
        infoPanel.add(new JLabel("PhilHealth No.:"));
        infoPanel.add(lblPhilhealth);
        infoPanel.add(new JLabel("TIN:"));
        infoPanel.add(lblTIN);
        infoPanel.add(new JLabel("Pagibig No.:"));
        infoPanel.add(lblPagIbig);

        add(infoPanel, BorderLayout.NORTH);

        setVisible(true);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
