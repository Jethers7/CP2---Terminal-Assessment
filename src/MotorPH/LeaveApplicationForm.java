package MotorPH;


import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LeaveApplicationForm extends JFrame {

    private JTextField txtEmployeeNumber;
    private JTextField txtLastName;
    private JTextField txtFirstName;
    private JTextArea txtReason;
    private JTextField txtApprover;
    private JButton btnSubmit;
    private JDateChooser startDateChooser;
    private JDateChooser endDateChooser;

    private static final String LEAVE_CSV_FILE = "Leave.csv";

    public LeaveApplicationForm(String employeeNumber) {
        initComponents(employeeNumber);
        txtEmployeeNumber.setText(employeeNumber);
        txtEmployeeNumber.setEditable(false);
        populateEmployeeDetails(employeeNumber);
    }

    private void populateEmployeeDetails(String employeeNumber) {
        try (BufferedReader br = new BufferedReader(new FileReader(LEAVE_CSV_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data[0].equals(employeeNumber)) {
                    txtLastName.setText(data[1]);
                    txtFirstName.setText(data[2]);
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error reading employee data.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        txtLastName.setEditable(false);
        txtFirstName.setEditable(false);
    }
    
    private void initComponents(String employeeNumber) {
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Leave Application");

        JLabel lblEmployeeNumber = new JLabel("Employee Number:");
        txtEmployeeNumber = new JTextField(10);
        txtEmployeeNumber.setText(employeeNumber);
        txtEmployeeNumber.setEditable(false);

        JLabel lblLastName = new JLabel("Last Name:");
        txtLastName = new JTextField(15);

        JLabel lblFirstName = new JLabel("First Name:");
        txtFirstName = new JTextField(15);

        JLabel lblStartDate = new JLabel("Start Date:");
        startDateChooser = new JDateChooser();
        startDateChooser.setDateFormatString("yyyy-MM-dd");

        JLabel lblEndDate = new JLabel("End Date:");
        endDateChooser = new JDateChooser();
        endDateChooser.setDateFormatString("yyyy-MM-dd");

        JLabel lblReason = new JLabel("Reason for Leave:");
        txtReason = new JTextArea(5, 20);
        JScrollPane reasonScrollPane = new JScrollPane(txtReason);

        JLabel lblApprover = new JLabel("Approver:");
        txtApprover = new JTextField(15);

        btnSubmit = new JButton("Submit");
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submitLeaveApplication();
            }
        });

        // Layout using GroupLayout
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(lblEmployeeNumber)
                                                        .addComponent(lblLastName)
                                                        .addComponent(lblFirstName)
                                                        .addComponent(lblStartDate)
                                                        .addComponent(lblEndDate)
                                                        .addComponent(lblReason)
                                                        .addComponent(lblApprover))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(txtEmployeeNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtLastName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtFirstName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(startDateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(endDateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(reasonScrollPane)
                                                        .addComponent(txtApprover, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(btnSubmit))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblEmployeeNumber)
                                        .addComponent(txtEmployeeNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblLastName)
                                        .addComponent(txtLastName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblFirstName)
                                        .addComponent(txtFirstName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(lblStartDate)
                                        .addComponent(startDateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(lblEndDate)
                                        .addComponent(endDateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(lblReason)
                                        .addComponent(reasonScrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblApprover)
                                        .addComponent(txtApprover, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSubmit)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }
    
    private void submitLeaveApplication() {
        String employeeNumber = txtEmployeeNumber.getText();
        String lastName = txtLastName.getText();
        String firstName = txtFirstName.getText();
        String reason = txtReason.getText();
        String approver = txtApprover.getText();
        String status = "Pending";

        LocalDate startDate = startDateChooser.getDate().toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
        LocalDate endDate = endDateChooser.getDate().toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();

        if (lastName.isEmpty() || firstName.isEmpty() || reason.isEmpty() ||  approver.isEmpty() || startDate == null || endDate == null) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (endDate.isBefore(startDate)) {
            JOptionPane.showMessageDialog(this, "End date cannot be before start date.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String submissionDate = now.format(formatter);

        String month = startDate.getMonth().toString();

        String[] data = {employeeNumber, lastName, firstName, reason, approver, month, status, startDate.toString(), endDate.toString(), submissionDate};

        File file = new File(LEAVE_CSV_FILE);
        boolean fileExists = file.exists();
        
        try (FileWriter fw = new FileWriter(file, true);
         BufferedWriter bw = new BufferedWriter(fw)) {
        
        if (!fileExists) {
            // If the file doesn't exist, write the header
            bw.write("Employee Number,Last Name,First Name,Reason,Approver,Month,Status,Start Date,End Date,Submission Date");
            bw.newLine();
        }

        // Write the new leave application data
        bw.write(String.join(",", data));
        bw.newLine();

            JOptionPane.showMessageDialog(this, "Leave application submitted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            
            this.dispose();

        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error submitting leave application.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Method to pre-fill employee details:
    public void setEmployeeDetails(String lastName, String firstName) {
        txtLastName.setText(lastName);
        txtFirstName.setText(firstName);
    }
}