/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sanjeevaniapp.gui;

import javax.swing.JFrame;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import sanjeevaniapp.dao.AppointmentDao;
import sanjeevaniapp.dao.DoctorDao;
import sanjeevaniapp.dao.PatientDao;
import sanjeevaniapp.pojo.AppointmentPojo;
import sanjeevaniapp.pojo.PatientPojo;

/**
 *
 * @author ACER
 */
public class UpdatePatient extends javax.swing.JFrame {

    String opd, age, city, address, firstName, lastName, mobileNo, patientId;

    public UpdatePatient() {
        initComponents();
        loadPatientId();
        loadDoctorsId();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtLName = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtDate = new javax.swing.JTextField();
        txtPhoneNo = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        txtAge = new javax.swing.JTextField();
        txtCity = new javax.swing.JTextField();
        txtOPD = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaAddress = new javax.swing.JTextArea();
        jcGender = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jcMStatus = new javax.swing.JComboBox<>();
        jcPatientId = new javax.swing.JComboBox<>();
        jcDoctorId = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Update Patient");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, 390, 50));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 35)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Sanjeevani Application");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, -1, -1));

        jPanel3.setBackground(new java.awt.Color(204, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true), "Update Patient", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 18), new java.awt.Color(0, 0, 0))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Patient ID");

        btnUpdate.setBackground(new java.awt.Color(204, 204, 204));
        btnUpdate.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(0, 0, 0));
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("OPD");

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Age");

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Doctor ID");

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("City");

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Address");

        txtLName.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        txtLName.setForeground(new java.awt.Color(0, 0, 0));
        txtLName.setText("Last Name");

        txtFirstName.setBackground(new java.awt.Color(255, 255, 255));
        txtFirstName.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        txtFirstName.setForeground(new java.awt.Color(0, 0, 0));
        txtFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFirstNameActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("First Name");

        txtLastName.setBackground(new java.awt.Color(255, 255, 255));
        txtLastName.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        txtLastName.setForeground(new java.awt.Color(0, 0, 0));

        jLabel10.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Gender");

        jLabel11.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Date");

        jLabel12.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Phone No.");

        txtDate.setEditable(false);
        txtDate.setBackground(new java.awt.Color(255, 255, 255));
        txtDate.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        txtDate.setForeground(new java.awt.Color(0, 0, 0));

        txtPhoneNo.setBackground(new java.awt.Color(255, 255, 255));
        txtPhoneNo.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        txtPhoneNo.setForeground(new java.awt.Color(0, 0, 0));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sanjeevaniapp/images/images (2).jpg"))); // NOI18N
        jLabel13.setText("jLabel13");

        btnBack.setBackground(new java.awt.Color(204, 204, 204));
        btnBack.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        btnBack.setForeground(new java.awt.Color(0, 0, 0));
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnLogout.setBackground(new java.awt.Color(204, 204, 204));
        btnLogout.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(0, 0, 0));
        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        txtAge.setBackground(new java.awt.Color(255, 255, 255));
        txtAge.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        txtAge.setForeground(new java.awt.Color(0, 0, 0));

        txtCity.setBackground(new java.awt.Color(255, 255, 255));
        txtCity.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        txtCity.setForeground(new java.awt.Color(0, 0, 0));
        txtCity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCityActionPerformed(evt);
            }
        });

        txtOPD.setBackground(new java.awt.Color(255, 255, 255));
        txtOPD.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        txtOPD.setForeground(new java.awt.Color(0, 0, 0));

        jTextAreaAddress.setBackground(new java.awt.Color(255, 255, 255));
        jTextAreaAddress.setColumns(20);
        jTextAreaAddress.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jTextAreaAddress.setRows(5);
        jScrollPane1.setViewportView(jTextAreaAddress);

        jcGender.setBackground(new java.awt.Color(255, 255, 255));
        jcGender.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jcGender.setForeground(new java.awt.Color(0, 0, 0));
        jcGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female", "Others" }));
        jcGender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcGenderActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Marial Status");

        jcMStatus.setBackground(new java.awt.Color(255, 255, 255));
        jcMStatus.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jcMStatus.setForeground(new java.awt.Color(0, 0, 0));
        jcMStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Married", "UnMarried" }));

        jcPatientId.setBackground(new java.awt.Color(255, 255, 255));
        jcPatientId.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jcPatientId.setForeground(new java.awt.Color(0, 0, 0));
        jcPatientId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcPatientIdActionPerformed(evt);
            }
        });

        jcDoctorId.setBackground(new java.awt.Color(255, 255, 255));
        jcDoctorId.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jcDoctorId.setForeground(new java.awt.Color(0, 0, 0));
        jcDoctorId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcDoctorIdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jcPatientId, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtOPD, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCity, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jcDoctorId, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(txtAge, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 62, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel15))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jcMStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPhoneNo, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel9)
                            .addComponent(txtLName)
                            .addComponent(jLabel10))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jcGender, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jcPatientId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtLName)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtOPD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel10)
                    .addComponent(jcGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcDoctorId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel11)
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel12)
                    .addComponent(txtPhoneNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jcMStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 5, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUpdate)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(btnLogout))
                .addGap(22, 22, 22))
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 1090, 370));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sanjeevaniapp/images/HomePageBG1.jpg"))); // NOI18N
        jLabel14.setText("jLabel14");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, -10, 1050, 400));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1090, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 760, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if (validateInputs() == false) {
            JOptionPane.showMessageDialog(null, "Please input all the fields");
            return;
        }
        if (validMobileNo() == false) {
            JOptionPane.showMessageDialog(null, "Please enter a valid mobile no.!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            PatientPojo pat = new PatientPojo();
            pat.setOpd(txtOPD.getText().trim());
            pat.setAge(Integer.parseInt(txtAge.getText()));
            pat.setCity(txtCity.getText().trim());
            pat.setAddress(jTextAreaAddress.getText().trim());
            pat.setFirstName(txtFirstName.getText().trim());
            pat.setLastName(txtLastName.getText().trim());
            String slectedDocId = jcDoctorId.getSelectedItem().toString();
            pat.setDoctorId(slectedDocId);
            pat.setPatientId(jcPatientId.getSelectedItem().toString());
            String slectedGender = jcGender.getSelectedItem().toString();
            pat.setGender(slectedGender);
            String slectedMaritalStatus = jcMStatus.getSelectedItem().toString();
            pat.setMarriedStatus(slectedMaritalStatus);
            pat.setMno(txtPhoneNo.getText().trim());
            pat.setAptStatus("REQUESTED");
            String date = txtDate.getText().trim();
            //-----------------------------------------------------------------------
            AppointmentPojo appopojo = new AppointmentPojo();
//            String date = patient.getDate().toString();
            appopojo.setApptDate(date);
            appopojo.setMoileNo(txtPhoneNo.getText().trim());
            appopojo.setOpd(txtOPD.getText().trim());
            appopojo.setPatientId(jcPatientId.getSelectedItem().toString());
            appopojo.setPatientName(txtFirstName.getText() + " " + txtLastName.getText().trim());
            appopojo.setStatus("REQUEST");
            String docName = DoctorDao.getDoctorNameById(jcDoctorId.getSelectedItem().toString());
            appopojo.setDoctorName(docName);
            boolean res1 = PatientDao.updatePatient(pat);
            boolean res2 = AppointmentDao.updateAppointment(appopojo);
            if (res1 && res2) {
                JOptionPane.showMessageDialog(null, "Patient Record Updated", "Success", JOptionPane.INFORMATION_MESSAGE);
                ViewAllPatients frame = new ViewAllPatients();
                this.dispose();
                frame.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Sorry!, Could not Update Patient Record", "Failure", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error in DB:" + ex);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void txtFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFirstNameActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        JFrame frame = new ReceptionistOptionsFrame();
        frame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        int ans = JOptionPane.showConfirmDialog(null, "Are you sure you want to Logout?", "Logging Out!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (ans == JOptionPane.YES_OPTION) {
            JFrame frame = new LoginScreen();
            frame.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void jcPatientIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcPatientIdActionPerformed
        try {
            String patId = jcPatientId.getSelectedItem().toString();
            PatientPojo pat = PatientDao.getPatientDetails(patId);
            txtOPD.setText(pat.getOpd());
            jcDoctorId.setSelectedItem(pat.getDoctorId());
            txtAge.setText(pat.getAge() + "");
            txtCity.setText(pat.getCity());
            jTextAreaAddress.setText(pat.getAddress());
            txtFirstName.setText(pat.getFirstName());
            txtLastName.setText(pat.getLastName());
            jcGender.setSelectedItem(pat.getGender());
            txtDate.setText(pat.getDate() + "");
            txtPhoneNo.setText(pat.getMno());
            jcMStatus.setSelectedItem(pat.getMarriedStatus());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error In DB" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jcPatientIdActionPerformed

    private void jcGenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcGenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcGenderActionPerformed

    private void jcDoctorIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcDoctorIdActionPerformed

    }//GEN-LAST:event_jcDoctorIdActionPerformed

    private void txtCityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCityActionPerformed

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
            java.util.logging.Logger.getLogger(UpdatePatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdatePatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdatePatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdatePatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdatePatient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextAreaAddress;
    private javax.swing.JComboBox<String> jcDoctorId;
    private javax.swing.JComboBox<String> jcGender;
    private javax.swing.JComboBox<String> jcMStatus;
    private javax.swing.JComboBox<String> jcPatientId;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtCity;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JLabel txtLName;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtOPD;
    private javax.swing.JTextField txtPhoneNo;
    // End of variables declaration//GEN-END:variables

    private void loadPatientId() {
        jcGender.setEnabled(false);
        jcMStatus.setEnabled(false);
        jcDoctorId.setEnabled(false);
        try {
            List<String> patList = PatientDao.getAllPatientId();
            for (String patId : patList) {
                jcPatientId.addItem(patId);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error in DB:" + ex);
            ex.printStackTrace();
        }
    }

    private void loadDoctorsId() {
        try {
            List<String> docList = DoctorDao.getAllDoctorId();
            for (String docId : docList) {
                jcDoctorId.addItem(docId);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error in DB:" + ex);
            ex.printStackTrace();
        }
    }

    private boolean validateInputs() {
        opd = txtOPD.getText().trim();
        age = txtAge.getText().trim();
        city = txtCity.getText().trim();
        address = jTextAreaAddress.getText().trim();
        firstName = txtFirstName.getText().trim();
        lastName = txtLastName.getText().trim();
        mobileNo = txtPhoneNo.getText().trim();
        if (opd.isEmpty() || age.isEmpty() || city.isEmpty() || address.isEmpty() || firstName.isEmpty() || lastName.isEmpty() || mobileNo.isEmpty()) {
            return false;
        }
        return true;
    }

    private boolean validMobileNo() {
        if (mobileNo.length() != 10) {
            return false;
        }
        return true;
    }
}
