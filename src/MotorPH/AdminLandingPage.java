
package MotorPH;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;




public class AdminLandingPage extends javax.swing.JFrame {

  private static final String[] 
          displayColumns = {
                     "Employee No.",
                     "Last Name",
                     "First Name", 
                     "SSS No.",
                     "PhilHealth No.",
                     "TIN",
                     "PagIbig No.",
          };

  // Defines a list to store the full employee data
  List<String[]> fullEmployeeData = new ArrayList<>();

  // Method to read full employee data from CSV
    private void readFullEmployeeData() {
        try (BufferedReader br = new BufferedReader(new FileReader("Employees.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] employee = line.split(",");
                fullEmployeeData.add(employee);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

  public AdminLandingPage() {
    // Initialize GUI components 
    initComponents(); 

    // Read the full employee data from CSV
    readFullEmployeeData();

    // Create a DefaultTableModel for the table
    DefaultTableModel model = new DefaultTableModel(AdminLandingPage.displayColumns, 0) {
        @Override
        public Class<?> getColumnClass(int columnIndex) {
            if (columnIndex == 4 || columnIndex == 6) { // PhilHealth and Pag-IBIG columns
                return String.class;
            }
            return super.getColumnClass(columnIndex);
        }
    };
    EmployeeTableList.setModel(model);
    readEmployeeData(model);

    // Add a ListSelectionListener to the table
    EmployeeTableList.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent event) {
            if (!event.getValueIsAdjusting() && EmployeeTableList.getSelectedRow() != -1) {
                int selectedRow = EmployeeTableList.getSelectedRow();
                String employeeNumber = model.getValueAt(selectedRow, 0).toString();
                
                // Find the full employee data by employee number
                for (String[] employee : fullEmployeeData) {
                    if (employee[0].equals(employeeNumber)) {
                        EmployeeNumField.setText(employee[0]);
                        LNameField.setText(employee[1]);
                        FNameField.setText(employee[2]);
                        BdateField.setText(employee[3]);
                        AddressField.setText(employee[4]); 
                        PhoneNumField.setText(employee[5]);
                        SSSField.setText(employee[6]);
                        PhilHealthField.setText(employee[7]);
                        TinField.setText(employee[8]);
                        PagibigField.setText(employee[9]);
                        StatusField.setText(employee[10]);
                        PositionField.setText(employee[11]);
                        BasicSalaryField.setText(employee[12]);
                        RiceSubcidyField.setText(employee[13]);
                        PhoneAllowanceField.setText(employee[14]);
                        ClothingAllowanceField.setText(employee[15]);

                        // Disable the EmployeeNumField
                        EmployeeNumField.setEditable(false);
                        break;
                    }
                }
            }
        }
    });
  }
  
   private int highestEmployeeNumber = 0;
   
   private void readEmployeeData(DefaultTableModel model) {
        try {
          // Open the CSV file
          File file = new File("Employees.csv");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            br.readLine(); // Skip header if present
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Object[] rowData = new Object[7];
                rowData[0] = data[0];  // Employee Number
                rowData[1] = data[1];  // Last Name
                rowData[2] = data[2];  // First Name
                rowData[3] = data[6];  // SSS No.
                rowData[4] = data[7];  // PhilHealth No.
                rowData[5] = data[8];  // TIN
                rowData[6] = data[9];  // PagIbig No.
                model.addRow(rowData);
            
            //Update the highest employee number
            int employeeNumber = Integer.parseInt(data[0]);
            if (employeeNumber > highestEmployeeNumber) {
                highestEmployeeNumber = employeeNumber;
            }
            }
        }
        } catch (IOException e) {
          e.printStackTrace();
        }
    }

   
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        EmployeeNumField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        LNameField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        FNameField = new javax.swing.JTextField();
        BdateField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        AddressField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        EmployeeTableList = new javax.swing.JTable();
        Clearbtn = new javax.swing.JButton();
        Createbtn = new javax.swing.JButton();
        deletebtn = new javax.swing.JButton();
        Updatebtn = new javax.swing.JButton();
        ViewEmpbtn = new javax.swing.JButton();
        LeaveRequestbtn = new javax.swing.JButton();
        Logoutbtn = new javax.swing.JButton();
        Payslipbtn = new javax.swing.JButton();
        SSSField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        PhoneNumField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        PhilHealthField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        TinField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        PagibigField = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        StatusField = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        PositionField = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        BasicSalaryField = new javax.swing.JTextField();
        RiceSubcidyField = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        PhoneAllowanceField = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        ClothingAllowanceField = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 0, 0));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1044, 700));

        jLabel1.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Employee No.");

        jLabel2.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Last Name");

        EmployeeNumField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmployeeNumFieldActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("First Name");

        LNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LNameFieldActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Date of Birth");

        FNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FNameFieldActionPerformed(evt);
            }
        });

        BdateField.setForeground(new java.awt.Color(0, 0, 0));
        BdateField.setText("MM-DD-YYYY");
        BdateField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                BdateFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                BdateFieldFocusLost(evt);
            }
        });
        BdateField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BdateFieldActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("SSS");

        AddressField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddressFieldActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Century Schoolbook", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("MotorPH Employee Database & Payroll");

        EmployeeTableList.setBackground(new java.awt.Color(102, 0, 0));
        EmployeeTableList.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        EmployeeTableList.setForeground(new java.awt.Color(255, 255, 255));
        EmployeeTableList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Employee No.", "Last Name", "First Name", "SSS", "Philhealth", "TIN", "Pag Ibig"
            }
        ));
        jScrollPane1.setViewportView(EmployeeTableList);
        if (EmployeeTableList.getColumnModel().getColumnCount() > 0) {
            EmployeeTableList.getColumnModel().getColumn(0).setResizable(false);
            EmployeeTableList.getColumnModel().getColumn(1).setResizable(false);
            EmployeeTableList.getColumnModel().getColumn(2).setResizable(false);
            EmployeeTableList.getColumnModel().getColumn(3).setResizable(false);
            EmployeeTableList.getColumnModel().getColumn(4).setResizable(false);
            EmployeeTableList.getColumnModel().getColumn(5).setResizable(false);
            EmployeeTableList.getColumnModel().getColumn(6).setResizable(false);
        }

        Clearbtn.setBackground(new java.awt.Color(102, 0, 0));
        Clearbtn.setForeground(new java.awt.Color(255, 255, 255));
        Clearbtn.setText("Clear");
        Clearbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearbtnActionPerformed(evt);
            }
        });

        Createbtn.setBackground(new java.awt.Color(102, 0, 0));
        Createbtn.setForeground(new java.awt.Color(255, 255, 255));
        Createbtn.setText("Create");
        Createbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreatebtnActionPerformed(evt);
            }
        });

        deletebtn.setBackground(new java.awt.Color(204, 0, 0));
        deletebtn.setForeground(new java.awt.Color(255, 255, 255));
        deletebtn.setText("Delete");
        deletebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebtnActionPerformed(evt);
            }
        });

        Updatebtn.setBackground(new java.awt.Color(102, 0, 0));
        Updatebtn.setForeground(new java.awt.Color(255, 255, 255));
        Updatebtn.setText("Update");
        Updatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdatebtnActionPerformed(evt);
            }
        });

        ViewEmpbtn.setBackground(new java.awt.Color(102, 0, 0));
        ViewEmpbtn.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        ViewEmpbtn.setForeground(new java.awt.Color(255, 255, 255));
        ViewEmpbtn.setText("View Employees");
        ViewEmpbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewEmpbtnActionPerformed(evt);
            }
        });

        LeaveRequestbtn.setBackground(new java.awt.Color(102, 0, 0));
        LeaveRequestbtn.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        LeaveRequestbtn.setForeground(new java.awt.Color(255, 255, 255));
        LeaveRequestbtn.setText("Leave Request");
        LeaveRequestbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LeaveRequestbtnActionPerformed(evt);
            }
        });

        Logoutbtn.setBackground(new java.awt.Color(255, 153, 153));
        Logoutbtn.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        Logoutbtn.setForeground(new java.awt.Color(255, 255, 255));
        Logoutbtn.setText("Log Out");
        Logoutbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutbtnActionPerformed(evt);
            }
        });

        Payslipbtn.setBackground(new java.awt.Color(102, 0, 0));
        Payslipbtn.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        Payslipbtn.setForeground(new java.awt.Color(255, 255, 255));
        Payslipbtn.setText("Employee  Payslip");
        Payslipbtn.setToolTipText("");
        Payslipbtn.setActionCommand(" Payroll ");
        Payslipbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PayslipbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(deletebtn, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                            .addComponent(Clearbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Createbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                            .addComponent(Updatebtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(20, 20, 20))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ViewEmpbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                            .addComponent(LeaveRequestbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Payslipbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Logoutbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 996, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Clearbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Createbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(deletebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Updatebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ViewEmpbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LeaveRequestbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Payslipbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Logoutbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11))
        );

        SSSField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SSSFieldActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Philhealth");

        jLabel10.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("TIN");

        jLabel11.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Pag Ibig");

        jLabel12.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Status");

        jLabel13.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Position");

        jLabel14.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Basic Salary");

        PositionField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PositionFieldActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Rice Subsidy");

        RiceSubcidyField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RiceSubcidyFieldActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Phone Allowance");

        jLabel17.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Clothing Allowance");

        jLabel18.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Full Address");

        jLabel19.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Phone Number");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel4)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(EmployeeNumField, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                                .addComponent(LNameField))
                            .addComponent(FNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BdateField, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(AddressField, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(SSSField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                                    .addComponent(PhilHealthField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(PhoneNumField))))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TinField, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                            .addComponent(PagibigField)
                            .addComponent(StatusField)
                            .addComponent(PositionField))))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15))
                        .addGap(80, 80, 80)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(RiceSubcidyField, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                            .addComponent(BasicSalaryField)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(45, 45, 45)
                        .addComponent(PhoneAllowanceField))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ClothingAllowanceField, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(115, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel10)
                    .addComponent(jLabel14)
                    .addComponent(EmployeeNumField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddressField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TinField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BasicSalaryField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(PhoneNumField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(12, 12, 12)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(FNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(SSSField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(StatusField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(BdateField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(PhilHealthField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(PositionField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15)
                                    .addComponent(RiceSubcidyField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(11, 11, 11)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel16)
                                    .addComponent(PhoneAllowanceField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel17)
                                    .addComponent(ClothingAllowanceField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(PagibigField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(33, 33, 33)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1499, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 752, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SSSFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SSSFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SSSFieldActionPerformed

    private void LeaveRequestbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LeaveRequestbtnActionPerformed
            EmployeeLeaveApp EmployeeLeaveApp = new EmployeeLeaveApp(); 
            EmployeeLeaveApp.setVisible(true); 
    }//GEN-LAST:event_LeaveRequestbtnActionPerformed

    private void ViewEmpbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewEmpbtnActionPerformed
    // Get the selected row index
    int selectedRow = EmployeeTableList.getSelectedRow();

    if (selectedRow != -1) {
        // Check if the selected row has the correct number of columns
        int columnCount = EmployeeTableList.getColumnCount();
        if (columnCount >= 7) { // Adjusted to match the number of columns you're accessing
            // Retrieve data from the selected row
            String employeeNumber = getStringValue(EmployeeTableList.getValueAt(selectedRow, 0));
            String lastName = getStringValue(EmployeeTableList.getValueAt(selectedRow, 1));
            String firstName = getStringValue(EmployeeTableList.getValueAt(selectedRow, 2));
            String sss = getStringValue(EmployeeTableList.getValueAt(selectedRow, 3));
            String philhealth = getStringValue(EmployeeTableList.getValueAt(selectedRow, 4));
            String tin = getStringValue(EmployeeTableList.getValueAt(selectedRow, 5));
            String pagIbig = getStringValue(EmployeeTableList.getValueAt(selectedRow, 6));

            // Create and display the EmployeeProfileDetails frame
            new EmployeeDetailsFrame(
                    employeeNumber,
                    lastName,
                    firstName,
                    sss,
                    philhealth,
                    tin,
                    pagIbig
            );
        } else {
            JOptionPane.showMessageDialog(this, "The selected row does not have enough columns.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(this, "Please select a row first.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
            private String getStringValue(Object value) {
        return value == null ? "" : value.toString();
    
    }//GEN-LAST:event_ViewEmpbtnActionPerformed

    private void UpdatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdatebtnActionPerformed
        updateEmployee();
    }//GEN-LAST:event_UpdatebtnActionPerformed

    private void deletebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebtnActionPerformed
        deleteEmployee();
    }//GEN-LAST:event_deletebtnActionPerformed

    private void CreatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreatebtnActionPerformed
        createEmployee();
    }//GEN-LAST:event_CreatebtnActionPerformed

    private void ClearbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearbtnActionPerformed
        EmployeeNumField.setText("");
        LNameField.setText("");
        FNameField.setText("");
        SSSField.setText("");
        PhilHealthField.setText("");
        TinField.setText("");
        PagibigField.setText("");
        StatusField.setText("");
        PositionField.setText("");
        BasicSalaryField.setText("");
        RiceSubcidyField.setText("");
        PhoneAllowanceField.setText("");
        ClothingAllowanceField.setText("");
        BdateField.setText("");
        AddressField.setText("");
        PhoneNumField.setText("");
    }//GEN-LAST:event_ClearbtnActionPerformed

    private void AddressFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddressFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddressFieldActionPerformed

    private void FNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FNameFieldActionPerformed
        String text = FNameField.getText();
        if (text.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "Valid input: " + text);
        } else {
            JOptionPane.showMessageDialog(this, "Invalid input! Please enter only string.");
        }
    }//GEN-LAST:event_FNameFieldActionPerformed

    private void LNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LNameFieldActionPerformed
        EmployeeNumField.setText(LNameField.getText());
    }//GEN-LAST:event_LNameFieldActionPerformed

           
    private void EmployeeNumFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmployeeNumFieldActionPerformed
        JOptionPane.showMessageDialog(this, "You entered: " + EmployeeNumField.getText());
    }//GEN-LAST:event_EmployeeNumFieldActionPerformed

    private void PositionFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PositionFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PositionFieldActionPerformed

    private void RiceSubcidyFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RiceSubcidyFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RiceSubcidyFieldActionPerformed

    
    // LogOut Section
    private void LogoutbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutbtnActionPerformed
            dispose(); // Close the current frame
            LoginPage loginFrame = new LoginPage(); 
            loginFrame.setVisible(true); 
    }//GEN-LAST:event_LogoutbtnActionPerformed

    private void PayslipbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PayslipbtnActionPerformed
            PayslipApp PayslipApp = new PayslipApp(); 
            PayslipApp.setVisible(true); 
    
    }//GEN-LAST:event_PayslipbtnActionPerformed

    private void BdateFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BdateFieldActionPerformed
       
    }//GEN-LAST:event_BdateFieldActionPerformed

    private void BdateFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BdateFieldFocusGained
        // TODO add your handling code here:
        if (BdateField.getText().equals("MM/DD/YYYY")){
            BdateField.setText("");
            BdateField.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_BdateFieldFocusGained

    private void BdateFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BdateFieldFocusLost
        // TODO add your handling code here:
        if (BdateField.getText().equals("")){
            BdateField.setText("MM/DD/YYYY");
            BdateField.setForeground(new Color(153, 153, 153));
        }
        
    }//GEN-LAST:event_BdateFieldFocusLost
 

    
   
private void updateEmployee() {
    int selectedRow = EmployeeTableList.getSelectedRow();
    if (selectedRow != -1) {
        // Get updated data from text fields
        String updatedLName = LNameField.getText();
        String updatedFName = FNameField.getText();
        String updatedBdate = BdateField.getText();
        String updatedAddress = AddressField.getText();
        String updatedPhoneNum = PhoneNumField.getText();
        String updatedSSS = SSSField.getText();
        String updatedPhilHealth = PhilHealthField.getText();
        String updatedTIN = TinField.getText();
        String updatedPagibig = PagibigField.getText();
        String updatedStatus = StatusField.getText();
        String updatedPosition = PositionField.getText();
        String updatedBasicSalary = BasicSalaryField.getText();
        String updatedRiceSubcidy = RiceSubcidyField.getText();
        String updatedPhoneAllowance = PhoneAllowanceField.getText();
        String updatedClothingAllowance = ClothingAllowanceField.getText();

        // Perform validation
        StringBuilder missingFields = new StringBuilder();

        if (updatedLName.isEmpty()) missingFields.append("Last Name, ");
        if (updatedFName.isEmpty()) missingFields.append("First Name, ");
        if (updatedBdate.isEmpty() || updatedBdate.equals("MM/DD/YYYY") || !isValidDate(updatedBdate)) {
            missingFields.append("Birthday (valid MM/DD/YYYY), ");
        }
        if (updatedAddress.isEmpty()) missingFields.append("Address, ");
        if (updatedPhoneNum.isEmpty()) missingFields.append("Phone Number, ");
        if (updatedPosition.isEmpty()) missingFields.append("Position, ");
        if (updatedSSS.isEmpty()) missingFields.append("SSS Number, ");
        if (updatedPhilHealth.isEmpty()) missingFields.append("PhilHealth Number, ");
        if (updatedTIN.isEmpty()) missingFields.append("TIN, ");
        if (updatedPagibig.isEmpty()) missingFields.append("Pag-IBIG Number, ");
        if (updatedStatus.isEmpty()) missingFields.append("Employment Status, ");
        if (updatedPosition.isEmpty()) missingFields.append("Job Title, ");
        if (updatedBasicSalary.isEmpty()) missingFields.append("Basic Salary, ");
        if (updatedRiceSubcidy.isEmpty()) missingFields.append("Rice Subsidy, ");
        if (updatedPhoneAllowance.isEmpty()) missingFields.append("Phone Allowance, ");
        if (updatedClothingAllowance.isEmpty()) missingFields.append("Clothing Allowance, ");

        // Validate specific fields
        if (!isValidName(updatedLName)) {
            missingFields.append("Last Name (alphabetical characters only), ");
        }
        if (!isValidName(updatedFName)) {
            missingFields.append("First Name (alphabetical characters only), ");
        }
        if (!isNumeric(updatedSSS)) {
            missingFields.append("SSS Number (numeric characters only), ");
        }
        if (!isNumeric(updatedPhilHealth)) {
            missingFields.append("PhilHealth Number (numeric characters only), ");
        }
        if (!isNumeric(updatedTIN)) {
            missingFields.append("TIN (numeric characters only), ");
        }
        if (!isNumeric(updatedPagibig)) {
            missingFields.append("Pag-IBIG Number (numeric characters only), ");
        }
        if (!isValidPhoneNumber(updatedPhoneNum)) {
            missingFields.append("Phone Number (phone number must be 11 digits only), ");
        }

        if (missingFields.length() > 0) {
            // Remove the last comma and space
            missingFields.setLength(missingFields.length() - 2);
            JOptionPane.showMessageDialog(this, "The following fields are required or invalid: " + missingFields.toString());
            return;
        }

        
        // Update the full employee data
        String employeeNumber = EmployeeNumField.getText();
        for (String[] employee : fullEmployeeData) {
            if (employee[0].equals(employeeNumber)) {
                employee[1] = updatedLName;
                employee[2] = updatedFName;
                employee[3] = updatedBdate;
                employee[4] = updatedAddress;
                employee[5] = updatedPhoneNum;
                employee[6] = updatedSSS;
                employee[7] = updatedPhilHealth;
                employee[8] = updatedTIN;
                employee[9] = updatedPagibig;
                employee[10] = updatedStatus;
                employee[11] = updatedPosition;
                employee[12] = updatedBasicSalary;
                employee[13] = updatedRiceSubcidy;
                employee[14] = updatedPhoneAllowance;
                employee[15] = updatedClothingAllowance;
                break;
            }
        }

        // Update the table model
        DefaultTableModel model = (DefaultTableModel) EmployeeTableList.getModel();
        model.setValueAt(updatedLName, selectedRow, 1);
        model.setValueAt(updatedFName, selectedRow, 2);
        model.setValueAt(updatedSSS, selectedRow, 3);
        model.setValueAt(updatedPhilHealth, selectedRow, 4);
        model.setValueAt(updatedTIN, selectedRow, 5);
        model.setValueAt(updatedPagibig, selectedRow, 6);

        // Update the CSV file
        updateCSVFile(fullEmployeeData);
    }
}

// Method to update the CSV file with new data
private void updateCSVFile(List<String[]> fullEmployeeData) {
    try (FileWriter writer = new FileWriter("Employees.csv")) {
        for (String[] employee : fullEmployeeData) {
            for (int i = 0; i < employee.length; i++) {
                writer.write(employee[i]);
                if (i < employee.length - 1) writer.write(",");
            }
            writer.write("\n");
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}



// Method to clear input fields after successful update
private void clearInputFields() {
    EmployeeNumField.setText("");
    LNameField.setText("");
    FNameField.setText("");
    BdateField.setText("");
    AddressField.setText("");
    PhoneNumField.setText("");
    SSSField.setText("");
    PhilHealthField.setText("");
    TinField.setText("");
    PagibigField.setText("");
    StatusField.setText("");
    PositionField.setText("");
    BasicSalaryField.setText("");
    RiceSubcidyField.setText("");
    PhoneAllowanceField.setText("");
    ClothingAllowanceField.setText("");
}





private void deleteEmployee() {
    int selectedRow = EmployeeTableList.getSelectedRow();
    
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Please select an employee to delete.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    DefaultTableModel model = (DefaultTableModel) EmployeeTableList.getModel();

    // Get the employee number from the selected row
    String employeeNumber = (String) EmployeeTableList.getValueAt(selectedRow, 0);

    int option = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete employee " + employeeNumber + "?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);

    if (option == JOptionPane.YES_OPTION) {
        System.out.println("Deleting employee with number: " + employeeNumber);

        // Remove the selected row from the JTable
        model.removeRow(selectedRow);

        // Remove the employee from fullEmployeeData list
        fullEmployeeData.removeIf(employee -> employee[0].equals(employeeNumber));

        // Update the CSV file
        updateCSVFile(fullEmployeeData);

        JOptionPane.showMessageDialog(this, "Employee with number " + employeeNumber + " has been deleted.", "Deletion Success", JOptionPane.INFORMATION_MESSAGE);
    } else {
        System.out.println("Deletion canceled.");
    }
}



// Increment the employee number counter and assign it
private static int nextEmployeeNumber = 1;

private void createEmployee() {
    // Initialize input fields
    int newEmployeeNumber = highestEmployeeNumber + 1;
    highestEmployeeNumber = newEmployeeNumber;
    
    EmployeeNumField.setText(String.valueOf(newEmployeeNumber));
    
    String lastName = LNameField.getText().trim();
    String firstName = FNameField.getText().trim();
    String sssNumber = SSSField.getText().trim();
    String philHealthNumber = PhilHealthField.getText().trim();
    String tin = TinField.getText().trim();
    String pagIbigNumber = PagibigField.getText().trim();
    String employmentStatus = StatusField.getText().trim();
    String jobTitle = PositionField.getText().trim();
    String basicSalary = BasicSalaryField.getText().trim();
    String riceSubsidy = RiceSubcidyField.getText().trim();
    String phoneAllowance = PhoneAllowanceField.getText().trim();
    String clothingAllowance = ClothingAllowanceField.getText().trim();
    String birthday = BdateField.getText().trim();
    String address = AddressField.getText().trim();
    String phoneNumber = PhoneNumField.getText().trim();
    String position = PositionField.getText().trim();

    // Perform validation
    StringBuilder missingFields = new StringBuilder();

            if (lastName.isEmpty()) missingFields.append("Last Name, ");
            if (firstName.isEmpty()) missingFields.append("First Name, ");
            if (birthday.isEmpty() || birthday.equals("MM/DD/YYYY") || !isValidDate(birthday)) {
                missingFields.append("Birthday (valid MM/DD/YYYY), ");
            }
            if (address.isEmpty()) missingFields.append("Address, ");
            if (phoneNumber.isEmpty()) missingFields.append("Phone Number, ");
            if (position.isEmpty()) missingFields.append("Position, ");
            if (sssNumber.isEmpty()) missingFields.append("SSS Number, ");
            if (philHealthNumber.isEmpty()) missingFields.append("PhilHealth Number, ");
            if (tin.isEmpty()) missingFields.append("TIN, ");
            if (pagIbigNumber.isEmpty()) missingFields.append("Pag-IBIG Number, ");
            if (employmentStatus.isEmpty()) missingFields.append("Employment Status, ");
            if (jobTitle.isEmpty()) missingFields.append("Job Title, ");
            if (basicSalary.isEmpty()) missingFields.append("Basic Salary, ");
            if (riceSubsidy.isEmpty()) missingFields.append("Rice Subsidy, ");
            if (phoneAllowance.isEmpty()) missingFields.append("Phone Allowance, ");
            if (clothingAllowance.isEmpty()) missingFields.append("Clothing Allowance, ");

            // Validate specific fields
            if (!isValidName(lastName)) {
                missingFields.append("Last Name (alphabetical characters only), ");
            }
            if (!isValidName(firstName)) {
                missingFields.append("First Name (alphabetical characters only), ");
            }
            if (!isNumeric(sssNumber)) {
                missingFields.append("SSS Number (numeric characters only), ");
            }
            if (!isNumeric(philHealthNumber)) {
                missingFields.append("PhilHealth Number (numeric characters only), ");
            }
            if (!isNumeric(tin)) {
                missingFields.append("TIN (numeric characters only), ");
            }
            if (!isNumeric(pagIbigNumber)) {
                missingFields.append("Pag-IBIG Number (numeric characters only), ");
            }
            if (!isValidPhoneNumber(phoneNumber)) {
                missingFields.append("Phone Number (phone number must be 11 digits only), ");
            }


            if (missingFields.length() > 0) {
                // Remove the last comma and space
                missingFields.setLength(missingFields.length() - 2);
                JOptionPane.showMessageDialog(this, "The following fields are required or invalid: " + missingFields.toString());
                return;
            }

    // Update JTable
    DefaultTableModel model = (DefaultTableModel) EmployeeTableList.getModel();
    model.addRow(new Object[]{
        newEmployeeNumber, 
        lastName, 
        firstName, 
        sssNumber, 
        philHealthNumber, 
        tin, 
        pagIbigNumber, 
        employmentStatus, 
        jobTitle,
        basicSalary, 
        riceSubsidy, 
        phoneAllowance, 
        clothingAllowance,
        birthday, 
        address, 
        phoneNumber, 
        position
    });

    // Add the new employee to fullEmployeeData list
    String[] newEmployee = {
        String.valueOf(newEmployeeNumber), 
        lastName, 
        firstName, 
        birthday, 
        address, 
        phoneNumber, 
        sssNumber, 
        philHealthNumber, 
        tin, 
        pagIbigNumber, 
        employmentStatus, 
        jobTitle,
        basicSalary, 
        riceSubsidy, 
        phoneAllowance, 
        clothingAllowance
    };
    fullEmployeeData.add(newEmployee);
    
    // Update CSV 
    CSVHandler csvHandler = new CSVHandler();
    csvHandler.saveEmployee(
        String.valueOf(newEmployeeNumber), 
        lastName, 
        firstName, 
        birthday, 
        address, 
        phoneNumber, 
        position,
        sssNumber, 
        philHealthNumber, 
        tin, 
        pagIbigNumber, 
        employmentStatus, 
        jobTitle,
        basicSalary, 
        riceSubsidy, 
        phoneAllowance, 
        clothingAllowance
    );

    // Display success message
    JOptionPane.showMessageDialog(this, "Employee created successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
}

// Validation methods

private boolean isValidDate(String dateStr) {
    try {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        sdf.setLenient(false);
        sdf.parse(dateStr);
        return true;
    } catch (ParseException e) {
        return false;
    }
}

private boolean isValidName(String name) {
    return name.matches("[a-zA-Z]+");
}

private boolean isNumeric(String str) {
    return str.matches("\\d+");
}

private boolean isValidPhoneNumber(String phone) {
   
    return phone.matches("\\d{11}"); 
}





    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AddressField;
    private javax.swing.JTextField BasicSalaryField;
    private javax.swing.JTextField BdateField;
    private javax.swing.JButton Clearbtn;
    private javax.swing.JTextField ClothingAllowanceField;
    private javax.swing.JButton Createbtn;
    private javax.swing.JTextField EmployeeNumField;
    private javax.swing.JTable EmployeeTableList;
    private javax.swing.JTextField FNameField;
    private javax.swing.JTextField LNameField;
    private javax.swing.JButton LeaveRequestbtn;
    private javax.swing.JButton Logoutbtn;
    private javax.swing.JTextField PagibigField;
    private javax.swing.JButton Payslipbtn;
    private javax.swing.JTextField PhilHealthField;
    private javax.swing.JTextField PhoneAllowanceField;
    private javax.swing.JTextField PhoneNumField;
    private javax.swing.JTextField PositionField;
    private javax.swing.JTextField RiceSubcidyField;
    private javax.swing.JTextField SSSField;
    private javax.swing.JTextField StatusField;
    private javax.swing.JTextField TinField;
    private javax.swing.JButton Updatebtn;
    private javax.swing.JButton ViewEmpbtn;
    private javax.swing.JButton deletebtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private String getStringVAlue(Object valueAt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
