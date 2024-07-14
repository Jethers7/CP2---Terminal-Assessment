
package MotorPH;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class EmployeeLandingPage extends javax.swing.JFrame {
    
    private String currentEmployeeNumber;
    
    public EmployeeLandingPage(String employeeNumber) {
        initComponents();
        this.currentEmployeeNumber = employeeNumber;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        EmployeeProfilebtn = new javax.swing.JButton();
        LeaveRequestbtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Logoutbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 0, 0));

        EmployeeProfilebtn.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        EmployeeProfilebtn.setText("EMPLOYEE PROFILE");
        EmployeeProfilebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmployeeProfilebtnActionPerformed(evt);
            }
        });

        LeaveRequestbtn.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        LeaveRequestbtn.setText("LEAVE REQUEST");
        LeaveRequestbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LeaveRequestbtnActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MotorPH/girlmotor.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Britannic Bold", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Welcome to Employee Dashboard ");

        Logoutbtn.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        Logoutbtn.setText("LOGOUT");
        Logoutbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(EmployeeProfilebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LeaveRequestbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Logoutbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(126, 126, 126)))
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86)
                .addComponent(EmployeeProfilebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(LeaveRequestbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Logoutbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(216, Short.MAX_VALUE))
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    // CSV file path for employee data
    private static final String EMPLOYEES_CSV_FILE = "EmployeeData.csv";

    private void EmployeeProfilebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmployeeProfilebtnActionPerformed

        if (currentEmployeeNumber == null || currentEmployeeNumber.isEmpty()) {
            JOptionPane.showInputDialog(this, "Employee number not available");
            return; 
        }

        // Read CSV file and search for employee number
        try (BufferedReader br = new BufferedReader(new FileReader(EMPLOYEES_CSV_FILE))) {
            String line;
            boolean found = false;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String employeeNumber = data[0]; 

                if (employeeNumber.equals(currentEmployeeNumber)) {
                    found = true;
                    // Display employee profile details
                    displayEmployeeProfile(data);
                    break;
                }
            }

            if (!found) {
                JOptionPane.showMessageDialog(this, "Employee Number not found.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error reading employee data.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void displayEmployeeProfile(String[] data) {
        JFrame frame = new JFrame("Employee Profile");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        JLabel lblEmployeeNumber = new JLabel("Employee Number: " + data[0]);
        JLabel lblLastName = new JLabel("Last Name: " + data[1]);
        JLabel lblFirstName = new JLabel("First Name: " + data[2]);
        JLabel lblSSSNo = new JLabel("SSS No.: " + data[3]);
        JLabel lblPhilHealthNo = new JLabel("PhilHealth No.: " + data[4]);
        JLabel lblTIN = new JLabel("TIN: " + data[5]);
        JLabel lblPagibigNo = new JLabel("Pagibig No.: " + data[6]);

        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(lblEmployeeNumber, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(lblLastName, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(lblFirstName, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(lblSSSNo, constraints);

        constraints.gridx = 0;
        constraints.gridy = 4;
        panel.add(lblPhilHealthNo, constraints);

        constraints.gridx = 0;
        constraints.gridy = 5;
        panel.add(lblTIN, constraints);

        constraints.gridx = 0;
        constraints.gridy = 6;
        panel.add(lblPagibigNo, constraints);

        frame.getContentPane().add(panel, BorderLayout.CENTER);

        frame.pack();
        frame.setLocationRelativeTo(null); // Center align the frame on screen
        frame.setVisible(true);
    
    }//GEN-LAST:event_EmployeeProfilebtnActionPerformed

    private void LogoutbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutbtnActionPerformed
        dispose(); 
        LoginPage loginFrame = new LoginPage(); 
        loginFrame.setVisible(true); 
    }//GEN-LAST:event_LogoutbtnActionPerformed

    private void LeaveRequestbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LeaveRequestbtnActionPerformed
        if (currentEmployeeNumber != null && !currentEmployeeNumber.isEmpty()) {
            LeaveApplicationForm leaveForm = new LeaveApplicationForm(currentEmployeeNumber);
            leaveForm.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Employee number not available. Please log in again.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_LeaveRequestbtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EmployeeLandingPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeLandingPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeLandingPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeLandingPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeLandingPage("dummyEmployeeNumber").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EmployeeProfilebtn;
    private javax.swing.JButton LeaveRequestbtn;
    private javax.swing.JButton Logoutbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
