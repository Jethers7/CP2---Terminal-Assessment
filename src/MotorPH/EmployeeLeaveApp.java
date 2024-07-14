
package MotorPH;

import java.awt.Component;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeLeaveApp extends javax.swing.JFrame {

    private JTable employeeTable;
    private JTextField txtEmployeeNumber;
    private JTextField txtLastName;
    private JTextField txtFirstName;
    private JTextField txtReason;
    private JTextField txtLeaveDate;
    private JTextField txtApprover;
    private JTextField txtStatus;
    private JButton btnDelete;
    private JButton btnUpdate; 

    // CSV file path
    private static final String CSV_FILE_PATH = "Leave.csv";

    public EmployeeLeaveApp() {
        initComponents();
        loadDataIntoTable(); // Load initial data into the table
    }

    private void initComponents() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Employee Leave Application");

        // Initialize components
        employeeTable = new JTable();
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(employeeTable);

        JLabel lblEmployeeNumber = new JLabel("Employee Number:");
        txtEmployeeNumber = new JTextField(10);

        JLabel lblLastName = new JLabel("Last Name:");
        txtLastName = new JTextField(15);

        JLabel lblFirstName = new JLabel("First Name:");
        txtFirstName = new JTextField(15);

        JLabel lblReason = new JLabel("Reason:");
        txtReason = new JTextField(20);

        JLabel lblLeaveDate = new JLabel("Approver:");
        txtLeaveDate = new JTextField(10);

        JLabel lblApprover = new JLabel("Month:");
        txtApprover = new JTextField(15);

        JLabel lblStatus = new JLabel("Status:");
        txtStatus = new JTextField(15);

        btnDelete = new JButton("Delete");
        btnDelete.setEnabled(false); // Initially disabled until a row is selected
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    deleteSelectedEmployee();
                } catch (IOException ex) {
                    Logger.getLogger(EmployeeLeaveApp.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        btnUpdate = new JButton("Update");
        btnUpdate.setEnabled(false); // Initially disabled until a row is selected
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateLeaveRecord();
            }
        });

        // Layout using GroupLayout
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(lblEmployeeNumber)
                                .addComponent(lblLastName)
                                .addComponent(lblFirstName)
                                .addComponent(lblReason)
                                .addComponent(lblLeaveDate)
                                .addComponent(lblApprover)
                                .addComponent(lblStatus))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(txtEmployeeNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtLastName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtFirstName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtReason, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtLeaveDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtApprover, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtStatus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(btnDelete)
                                .addComponent(btnUpdate))))
                    .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblEmployeeNumber)
                        .addComponent(txtEmployeeNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDelete))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblLastName)
                        .addComponent(txtLastName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblFirstName)
                        .addComponent(txtFirstName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblReason)
                        .addComponent(txtReason, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        )
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblLeaveDate)
                        .addComponent(txtLeaveDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblApprover)
                        .addComponent(txtApprover, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnUpdate))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblStatus)
                        .addComponent(txtStatus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }

    // Method to load data into the table 
    private void loadDataIntoTable() {
        // Read data from CSV file and load into table
        try {
            BufferedReader br = new BufferedReader(new FileReader(CSV_FILE_PATH));

            // Read header
            String headerLine = br.readLine();
            String[] columnNames = headerLine.split(",");

            // Read data lines
            List<Object[]> rows = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                rows.add(data);
            }

            br.close();

            // Populate table model
            DefaultTableModel model = new DefaultTableModel(rows.toArray(new Object[0][0]), columnNames) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false; // Disable table cell editing
                }
            };
            employeeTable.setModel(model);

            // Add selection listener to the table
            employeeTable.getSelectionModel().addListSelectionListener(e -> {
                int selectedRow = employeeTable.getSelectedRow();
                if (selectedRow != -1) {
                    txtEmployeeNumber.setText((String) employeeTable.getValueAt(selectedRow, 0));
                    txtLastName.setText((String) employeeTable.getValueAt(selectedRow, 1));
                    txtFirstName.setText((String) employeeTable.getValueAt(selectedRow, 2));
                    txtReason.setText((String) employeeTable.getValueAt(selectedRow, 3));
                    txtLeaveDate.setText((String) employeeTable.getValueAt(selectedRow, 4));
                    txtApprover.setText((String) employeeTable.getValueAt(selectedRow, 5));
                    txtStatus.setText((String) employeeTable.getValueAt(selectedRow, 6));
                    btnDelete.setEnabled(true); // Enable delete button upon selection
                    btnUpdate.setEnabled(true); // Enable update button upon selection
                    
                    
                    
                     // Disable editing for non-status fields
                    txtEmployeeNumber.setEnabled(false);
                    txtLastName.setEnabled(false);
                    txtFirstName.setEnabled(false);
                    txtReason.setEnabled(false);
                    txtLeaveDate.setEnabled(false);
                    txtApprover.setEnabled(false);
                    txtStatus.setEnabled(true); // Enable editing for status field
                    
                }
            });

        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading data from CSV file.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Method to delete selected employee record 
    private void deleteSelectedEmployee() throws IOException {
        int selectedRow = employeeTable.getSelectedRow();
        if (selectedRow != -1) {
            DefaultTableModel model = (DefaultTableModel) employeeTable.getModel();
            model.removeRow(selectedRow);

            // Update the CSV file after deletion
            updateCSVFile(model);

            // After deletion, clear text fields and disable delete/update buttons
            clearFields();
            btnDelete.setEnabled(false); // Disable delete button again
            btnUpdate.setEnabled(false); // Disable update button again
        }
    }
    

    // Method to append new record to the CSV file
    private void appendToCSVFile(String[] data) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(CSV_FILE_PATH, true)); // Append mode

            // Append new record
            for (int i = 0; i < data.length; i++) {
                bw.write(data[i]);
                if (i < data.length - 1) {
                    bw.write(",");
                }
            }
            bw.newLine();

            bw.close();

        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error updating CSV file.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateLeaveRecord() {
        int selectedRow = employeeTable.getSelectedRow();
        if (selectedRow != -1) {
            String newStatus = txtStatus.getText();
            String newApprover = txtLeaveDate.getText(); // Assuming this is the approver field

            if (newStatus.isEmpty() || newApprover.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Status and Approver fields cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            DefaultTableModel model = (DefaultTableModel) employeeTable.getModel();

            model.setValueAt(newStatus, selectedRow, 6); // Status
            model.setValueAt(newApprover, selectedRow, 4); // Approver

            try {
                updateCSVFile(model);
                JOptionPane.showMessageDialog(this, "Leave record updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);

                clearFields();
                btnDelete.setEnabled(false);
                btnUpdate.setEnabled(false);
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error updating CSV file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Method to update the CSV file with the current table data
    private void updateCSVFile(DefaultTableModel model) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(CSV_FILE_PATH, false))) {
            // Write header
            for (int i = 0; i < model.getColumnCount(); i++) {
                bw.write(model.getColumnName(i));
                if (i < model.getColumnCount() - 1) {
                    bw.write(",");
                }
            }
            bw.newLine();

            // Write data
            for (int row = 0; row < model.getRowCount(); row++) {
                for (int col = 0; col < model.getColumnCount(); col++) {
                    Object value = model.getValueAt(row, col);
                    bw.write(value != null ? value.toString() : "");
                    if (col < model.getColumnCount() - 1) {
                        bw.write(",");
                    }
                }
                bw.newLine();
            }
        }
    }

    // Method to clear input fields
    private void clearFields() {
        txtEmployeeNumber.setText("");
        txtLastName.setText("");
        txtFirstName.setText("");
        txtReason.setText("");
        txtLeaveDate.setText("");
        txtApprover.setText("");
        txtStatus.setText("");
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeLeaveApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeLeaveApp().setVisible(true);
            }
        });
    }

    private boolean isValidStatus(String trim) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
